package access.handle.changePassword;
import access.model.IDAndPassword;
import access.model.TeacherInformation;

import javax.swing.*;
import java.sql.*;

public class ChangePassword {
    Connection con;
    PreparedStatement preSql1,preSql2;
    Statement sql;
    public ChangePassword() {
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
    public IDAndPassword queryVerify(IDAndPassword idAndPassword) {
        String id = idAndPassword.getID();
        String ol  = IDAndPassword.GL_ID;
        if(ol.equals(id) || ol.equals("admin"))
        {
            String password = idAndPassword.getPassword();
            String newPassword = idAndPassword.getNewPassword();
            String sqlStr1 = "SELECT ID, Password from login where ID = ? and Password = ?";
            String sqlStr2 = "UPDATE login set Password  = ? where ID = ?";
            try{
                preSql1 = con.prepareStatement(sqlStr1);
                preSql1.setString(1,id);
                preSql1.setString(2,password);
                ResultSet rs = preSql1.executeQuery();
                if(rs.next() == true) {
                    try{
                        preSql2 = con.prepareStatement(sqlStr2);
                        preSql2.setString(1,newPassword);
                        preSql2.setString(2,id);
                        preSql2.execute();
                    }catch (SQLException e) {}
                    JOptionPane.showMessageDialog(null,"修改密码成功","成功",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"账户或密码错误","错误",JOptionPane.WARNING_MESSAGE);
                }
                con.close();
            }
            catch (SQLException e) {}
            return idAndPassword;
        }else
        {
            JOptionPane.showMessageDialog(null,"不得呀,修改别人的密码不是很友好的！","做咩呀",JOptionPane.ERROR_MESSAGE);
        }
        return idAndPassword;
    }
    public void showInformation(TeacherInformation teacher) {
        return;
    }
}
