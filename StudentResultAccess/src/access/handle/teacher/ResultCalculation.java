package access.handle.teacher;

import access.model.ResultAggInformation;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ResultCalculation {
    Connection con;
    PreparedStatement preSql1,preSql2,preSql3;
    Statement sql;
    public ResultCalculation() {
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
    public DefaultTableModel showAndSetCal(ResultAggInformation result) {
        int count = 0,i = 1;
        int chineseAgg = 0,mathAgg = 0,englishAgg = 0,agg = 0;
        int countDownSix = 0,countSix = 0,countSeven = 0,countEight = 0,countNine = 0;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"名次","学号","姓名","语文","数学","英语","总分"});
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM score ORDER BY aggResult DESC ");
            while(rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                double chinese = rs.getDouble(3);
                double math = rs.getDouble(4);
                double english = rs.getDouble(5);
                double aggResult = rs.getDouble(6);
                model.addRow(new Object[]{i,ID, name, chinese, math, english, aggResult});
                i++;
                count++;
                chineseAgg += chinese;
                mathAgg += math;
                englishAgg += english;
                agg += aggResult;
                if (aggResult != 0 && aggResult < 180) {
                    ++countDownSix;
                } else if (aggResult != 0 && aggResult >= 180 && aggResult < 210) {
                    ++countSix;
                } else if (aggResult != 0 && aggResult >= 210 && aggResult < 240) {
                    ++countSeven;
                } else if (aggResult != 0 && aggResult >= 240 && aggResult < 270) {
                    ++countEight;
                } else if (aggResult != 0 && aggResult >= 270) {
                    ++countNine;
                }
            }
            con.close();
        }
        catch (SQLException e) {}
        result.setAverageScoreAgg(agg / count);
        result.setAverageScoreChinese(chineseAgg / count);
        result.setAverageScoreMath(mathAgg / count);
        result.setAverageScoreEnglish(englishAgg / count);
        result.setCountDownSix(countDownSix);
        result.setCountSix(countSix);
        result.setCountSeven(countSeven);
        result.setCountEight(countEight);
        result.setCountNine(countNine);
        return model;
    }
}
