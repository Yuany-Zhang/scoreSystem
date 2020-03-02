package access.handle.login;

import access.model.StudentInformation;
import access.model.TeacherInformation;

import java.sql.*;

public class UserInformation {
    Connection con;
    PreparedStatement preSql1, preSql2, preSql3;
    Statement sql;

    public UserInformation() {
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
    public TeacherInformation getNewTeacher(String ID) {  //得到登录用户为老师的用户的具体信息
        TeacherInformation teacher = new TeacherInformation();
        String id,name = null,course = null,sex = null,birthday = null;
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM teacher WHERE TeacherID = '" + ID +"'");
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                course = rs.getString(3);
                sex = rs.getString(4);
                birthday = rs.getString(5);
            }
            teacher.setId(ID);
            teacher.setName(name);
            teacher.setCourse(course);
            teacher.setSex(sex);
            teacher.setBirthday(birthday);

        }catch (SQLException e) {}
        return teacher;
    }
    public StudentInformation getNewStudent(String ID) {    //得到登录用户为学生的用户的具体信息
        StudentInformation student = new StudentInformation();
        String id,name = null,sex = null,birthday = null;
        try{
            sql = con.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM students WHERE StudentID = '" + ID +"'");
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                sex = rs.getString(3);
                birthday = rs.getString(4);
            }
            student.setId(ID);
            student.setName(name);
            student.setSex(sex);
            student.setBirthday(birthday);

        }catch (SQLException e) {}
        return student;
    }
}
