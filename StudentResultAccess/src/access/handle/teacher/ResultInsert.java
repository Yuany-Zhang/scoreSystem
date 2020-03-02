package access.handle.teacher;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class ResultInsert {
    Connection con;
    PreparedStatement preSql;
    Statement sql;
    public ResultInsert() {
        try{ Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String uri = "jdbc:mysql://localhost:3306/access?useSSL=false";
        try{
            con = DriverManager.getConnection(uri,"root","123456");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public DefaultTableModel showResult(String course) {
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row,int col) {
                if(col == 2) {
                    return true;
                }
                else{
                    return false;
                }
            }
        };
        model.setColumnIdentifiers(new Object[]{"学号","姓名", course+"成绩"});
        if (course.equals("语文")) {
            course = "Chinese";
        } else if (course.equals("数学")) {
            course = "math";
        } else if (course.equals("英语")) {
            course = "English";
        }
        try {
            sql = con.createStatement();
            double result = 0;
            ResultSet rs = null;
            rs = sql.executeQuery("SELECT score.StudentID,StudentName,Chinese,math,English FROM score");
            int n = 1;
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                double chinese = rs.getDouble(3);
                double math = rs.getDouble(4);
                double english = rs.getDouble(5);
                if (course.equals("Chinese")) {
                    result = chinese;
                } else if (course.equals("math")) {
                    result = math;
                } else if (course.equals("English")) {
                    result = english;
                }
                model.addRow(new Object[]{ID, name, result}); //加入表格
                if(chinese != 0 && math != 0 && english != 0) {
                    double aggRes = chinese + math + english;
                    String sqlStr = "UPDATE score set aggResult = ? where StudentID = ?";
                    try{
                        preSql = con.prepareStatement(sqlStr);
                        preSql.setDouble(1,aggRes);
                        preSql.setString(2,ID);
                        preSql.execute();

                    } catch (SQLException e1) {}
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String finalCourse = course;
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int type = e.getType();
                int row = e.getFirstRow();
                int column = e.getColumn();
                String newValue = model.getValueAt(row,column).toString();
                String ID = model.getValueAt(row,0).toString();
                double score = Double.parseDouble(newValue);
                String sqlStr = "UPDATE score set " + finalCourse + "= ? where StudentID = ?";
                try{
                    preSql = con.prepareStatement(sqlStr);
                    preSql.setDouble(1,score);
                    preSql.setString(2,ID);
                    preSql.execute();
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return model;
    }
}
