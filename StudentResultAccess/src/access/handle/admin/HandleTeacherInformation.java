package access.handle.admin;
import access.model.TeacherInformation;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HandleTeacherInformation {
    Connection con;
    PreparedStatement preSql1,preSql2;
    Statement sql;
    public HandleTeacherInformation() {
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
    public void writeTeacherInformation(TeacherInformation teacherInformation) {
        String sqlStr1 = "insert into teacher values(?,?,?,?,?)";
        String sqlStr2 = "insert into login value(?,?)";
        int ok1 = 0,ok2 = 0;
        try{
            preSql1 = con.prepareStatement(sqlStr1);
            preSql2 = con.prepareStatement(sqlStr2);
            preSql1.setString(1,teacherInformation.getId());
            preSql1.setString(2,teacherInformation.getName());
            preSql1.setString(3,teacherInformation.getCourse());
            preSql1.setString(4,teacherInformation.getSex());
            preSql1.setString(5,teacherInformation.getBirthday());
            preSql2.setString(1,teacherInformation.getId());
            preSql2.setString(2,"123456");  //设置初始密码为“123456”
            ok1 = preSql1.executeUpdate();
            ok2 = preSql2.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ID非法或重复","警告",
                    JOptionPane.WARNING_MESSAGE);
        }
        if(ok1 != 0 && ok2 != 0) {
            JOptionPane.showMessageDialog(null,"新增加教师成功","成功",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteTeacherInformation(String ID) {
        String sqlStr1 = "delete from teacher where TeacherID = '"+ ID + "'";
        String sqlStr2 = "delete from login where ID = '" + ID + "'";
        int ok1 = 0,ok2 = 0;
        try{
            sql = con.createStatement();
            ok1 = sql.executeUpdate(sqlStr1);
            ok2 = sql.executeUpdate(sqlStr2);
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if(ok1 != 0 && ok2 != 0) {
            JOptionPane.showMessageDialog(null,"删除成功","成功",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"学号输入非法或错误","警告",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    public DefaultTableModel showTeacherInformation() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"工号","姓名","授课科目","性别","生日"});
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM teacher");
            while(rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String course = rs.getString(3);
                String sex = rs.getString(4);
                Date date = rs.getDate(5);
                model.addRow(new Object[] {ID,name,course,sex,date});
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}