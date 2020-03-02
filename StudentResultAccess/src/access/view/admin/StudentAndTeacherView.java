package access.view.admin;

import access.view.changePassword.ChangePasswordView;
import access.view.login.LoginWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class StudentAndTeacherView extends JPanel implements ActionListener {
    JTabbedPane p;
    StudentAppend studentAppend;
    TeacherAppend teacherAppend;
    ChangePasswordView changePasswordView;
    JButton buttonReturn;
    public StudentAndTeacherView() {
        studentAppend = new StudentAppend();
        teacherAppend = new TeacherAppend();
        changePasswordView = new ChangePasswordView();
        buttonReturn = new JButton("点击或按ESC退回登陆界面");
        setLayout(new BorderLayout());
        p = new JTabbedPane();
        p.add("学生添加/删除",studentAppend);
        p.add("教师添加/删除",teacherAppend);
        p.add("修改密码",changePasswordView);
        add(p,BorderLayout.CENTER);
        add(buttonReturn,BorderLayout.NORTH);
        buttonReturn.addActionListener(this);
        buttonReturn.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    public void actionPerformed(ActionEvent e) {
        LoginWindow window = null;
        try {
            window = new LoginWindow();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        window.setTitle("登录界面");
        SwingUtilities.getWindowAncestor(this).dispose(); //将上一窗口关闭
    }
}
