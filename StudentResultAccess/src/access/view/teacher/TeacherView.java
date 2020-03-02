package access.view.teacher;

import access.view.login.LoginWindow;
import access.model.TeacherInformation;
import access.view.changePassword.ChangePasswordView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class TeacherView extends JPanel implements ActionListener {
    JTabbedPane p;
    ResultView resultView;
    AggView aggView;
    ChangePasswordView changePasswordView;
    TeacherPerView teacherPerView;
    JButton buttonReturn;
    public TeacherView(TeacherInformation teacher) {
        resultView = new ResultView(teacher);
        teacherPerView = new TeacherPerView(teacher);
        aggView = new AggView();
        changePasswordView = new ChangePasswordView();
        buttonReturn = new JButton("点击或按ESC返回登录界面");
        setLayout(new BorderLayout());
        p = new JTabbedPane();
        p.add("教师信息",teacherPerView);
        p.add("成绩录入",resultView);
        p.add("成绩统计",aggView);
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
