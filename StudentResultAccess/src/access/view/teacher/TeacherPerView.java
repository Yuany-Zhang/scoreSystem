package access.view.teacher;

import access.model.TeacherInformation;
import access.view.student.StudentPerView;

import javax.swing.*;
import java.awt.*;

public class TeacherPerView extends JPanel {
    TeacherPerView(TeacherInformation teacher) {
        String textID = "工号： " + teacher.getId();
        String textName = "姓名： " + teacher.getName();
        String textCourse = "授课课程： " + teacher.getCourse();
        String textSex = "性别： " + teacher.getSex();
        String textBirthday = "出生日期： " + teacher.getBirthday();
        String text = "<html> " + textID + "<br/> " + textName + "<br/> " + textCourse +"" +
                "<br/> " + textSex + "<br/> " + textBirthday + "</html>";
        JLabel j = new JLabel(text);
        j.setFont(new Font("root",Font.BOLD,30));
        add(j);
      //  StudentPerView.setPic(this,"icon.gif");
    }
}
