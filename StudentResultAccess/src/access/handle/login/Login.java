package access.handle.login;

import access.model.IDAndPassword;

import javax.swing.*;
import java.sql.*;

public class Login {
    Connection con;
    PreparedStatement preSql;
    Statement sql;

    public Login() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uri = "jdbc:mysql://localhost:3306/access?useSSL=false";
        try {
            con = DriverManager.getConnection(uri, "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public IDAndPassword queryVerify(IDAndPassword idAndPassword) {
        String ID = idAndPassword.getID();
        IDAndPassword.GL_ID = ID;
        String password = idAndPassword.getPassword();
        String sqlStr = "SELECT ID,Password FROM login where ID = ? and Password = ?";
        try{
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1,ID);
            preSql.setString(2,password);
            ResultSet rs = preSql.executeQuery();
            if(rs.next() == true) {
                idAndPassword.setID(ID);
                idAndPassword.setLoginSuccess(true);
                JOptionPane.showMessageDialog(null,"登录成功","恭喜",
                                JOptionPane.WARNING_MESSAGE);
            }
            else{
                idAndPassword.setLoginSuccess(false);
                JOptionPane.showMessageDialog(null,"账号或密码输入错误","登陆失败",
                                JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        }
        catch (SQLException e) {}
            return idAndPassword;
    }
}
