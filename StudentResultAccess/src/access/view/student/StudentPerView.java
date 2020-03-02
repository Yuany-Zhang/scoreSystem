package access.view.student;

import access.model.StudentInformation;

import javax.swing.*;
import java.awt.*;

public class StudentPerView extends JPanel{
    StudentPerView(StudentInformation student) {
        String textID = "学号： " + student.getId();
        String textName = "姓名： " + student.getName();
        String textSex = "性别： " + student.getSex();
        String textBirthday = "出生日期： " + student.getBirthday();
        String text = "<html>" + textID + "</font> <br/> " + textName + "<br/> " + textSex + "<br/> " + textBirthday + "</html>";

        JLabel l1 = new JLabel(text);
        l1.setFont(new Font("root",Font.BOLD,30));
        add(l1,BorderLayout.CENTER);
      // setPic(this,"icon.gif");
    }

    public static void setPic(JPanel jPanel, String srcPicPath)
    {  //设置显示学生、教师图片
        ImageIcon pic = new ImageIcon(srcPicPath);
        JLabel jl = new JLabel(pic);
        jPanel.add(jl);
        jl.setLocation(350,400);
    }
}
