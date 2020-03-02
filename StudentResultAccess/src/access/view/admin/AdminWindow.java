package access.view.admin;

import access.view.login.LoginWindow;

import javax.swing.*;
import java.awt.*;

public class AdminWindow extends JFrame{
    StudentAndTeacherView view;
    public AdminWindow() {
        //setBounds(100,100,700,650);
        LoginWindow.setScreenCentor(this);
        view = new StudentAndTeacherView();
        add(view, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
