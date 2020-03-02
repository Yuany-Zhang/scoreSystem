package access.view.student;

import access.model.StudentInformation;
import access.view.login.LoginWindow;

import javax.swing.*;
import java.awt.*;

public class StudentWindow extends JFrame {
    StudentView view;
    public StudentWindow(StudentInformation student) {
        //setBounds(100,100,700,650);
        LoginWindow.setScreenCentor(this);
        view = new StudentView(student);
        add(view, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(LoginWindow.img.getImage());
        setVisible(true);
    }

}
