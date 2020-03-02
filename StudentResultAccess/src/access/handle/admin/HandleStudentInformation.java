package access.handle.admin;
import access.model.StudentInformation;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HandleStudentInformation {
    Connection con;
    PreparedStatement preSql1,preSql2,preSql3;
    Statement sql;
    public HandleStudentInformation() {
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
    public void writeStudentInformation(StudentInformation studentInformation) {
        String sqlStr1 = "insert into students values(?,?,?,?)";
        String sqlStr2 = "insert into login value(?,?)";
        String sqlStr3 = "insert into score(StudentID,StudentName) value(?,?)";
        int ok1 = 0,ok2 = 0,ok3 = 0;
        try{
            preSql1 = con.prepareStatement(sqlStr1);
            preSql2 = con.prepareStatement(sqlStr2);
            preSql3 = con.prepareStatement(sqlStr3);
            preSql1.setString(1,studentInformation.getId());
            preSql1.setString(2,studentInformation.getName());
            preSql1.setString(3,studentInformation.getSex());
            preSql1.setString(4,studentInformation.getBirthday());
            preSql2.setString(1,studentInformation.getId());
            preSql2.setString(2,"123456");  //设置初始密码为“123456”
            preSql3.setString(1,studentInformation.getId());
            preSql3.setString(2,studentInformation.getName());
            ok1 = preSql1.executeUpdate();
            ok2 = preSql2.executeUpdate();
            ok3 = preSql3.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ID非法或重复","警告",
                                        JOptionPane.WARNING_MESSAGE);
        }
        if(ok1 != 0 && ok2 != 0 && ok3 != 0) {
            JOptionPane.showMessageDialog(null,"新增加学生成功","成功",
                                        JOptionPane.INFORMATION_MESSAGE);
            System.out.println("!!!");
        }
    }

    public void deleteStudentInformation(String ID) {
        String sqlStr1 = "delete from students where StudentID = '"+ ID + "'";
        String sqlStr2 = "delete from login where ID = '"+ ID + "'";
        String sqlStr3 = "delete from score where StudentID = '" + ID + "'";
        int ok1 = 0,ok2 = 0,ok3 = 0;
        try{
            sql = con.createStatement();
            ok1 = sql.executeUpdate(sqlStr1);
            ok2 = sql.executeUpdate(sqlStr2);
            ok3 = sql.executeUpdate(sqlStr3);
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if(ok1 != 0 && ok2 != 0 && ok3 != 0) {
            JOptionPane.showMessageDialog(null,"删除成功","成功",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("!!!");
        }
        else {
            JOptionPane.showMessageDialog(null,"学号输入非法或该学号不存在","警告",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    public DefaultTableModel showStudentInformation() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"学号","姓名","性别","生日"});
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM students");
            while(rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String sex = rs.getString(3);
                Date date = rs.getDate(4);
                model.addRow(new Object[] {ID,name,sex,date});
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
