package access.view.teacher;
import access.model.TeacherInformation;
import access.view.login.LoginWindow;

import javax.swing.*;
import java.awt.*;

public class TeacherWindow extends JFrame {
    TeacherView view;
    public TeacherWindow(TeacherInformation teacher) {
        //setBounds(100,100,700,650);
        LoginWindow.setScreenCentor(this);
        view = new TeacherView(teacher);
        add(view, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(LoginWindow.img.getImage());  //设置标题栏图标
        setVisible(true);
    }
}
