package access.handle.student;

import access.model.ScoreInformation;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SearchScore {
    Connection con;
    PreparedStatement preSql1, preSql2, preSql3;
    Statement sql;

    public SearchScore() {
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
    public ScoreInformation SearchAllScore(String ID) {
        ScoreInformation score = new ScoreInformation();
        String id,name = null;
        double chinese = 0,math = 0,english = 0,agg = 0;
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM score WHERE StudentID = '" + ID +"'");
            while(rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                chinese = rs.getDouble(3);
                math = rs.getDouble(4);
                english = rs.getDouble(5);
                agg = rs.getDouble(6);
            }
            score.setStudentID(ID);
            score.setName(name);
            score.setChinese(chinese);
            score.setMath(math);
            score.setEnglish(english);
            score.setAgg(agg);
        } catch (SQLException e) {}
        return score;
    }
    public DefaultTableModel TableAllScore() {
        String ID,name = null;
        double chinese = 0,math = 0,english = 0,agg = 0;
        int i = 0;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"名次","学号","姓名","语文","数学","英语","总分"});
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM score ORDER BY aggResult DESC");
            while(rs.next()) {
                ID = rs.getString(1);
                name = rs.getString(2);
                chinese = rs.getDouble(3);
                math = rs.getDouble(4);
                english = rs.getDouble(5);
                agg = rs.getDouble(6);
                i++;
                model.addRow(new Object[]{i,ID,name,chinese,math,english,agg});
            }
        } catch (SQLException e) {}
        return model;
    }
}
