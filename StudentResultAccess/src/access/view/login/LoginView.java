package access.view.login;

import access.handle.login.Login;
import access.handle.login.UserInformation;
import access.model.StudentInformation;
import access.model.TeacherInformation;
import access.view.admin.AdminWindow;
import access.model.IDAndPassword;
import access.view.student.StudentWindow;
import access.view.teacher.TeacherWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LoginView extends JPanel implements ActionListener {
    IDAndPassword idAndPassword;
    JTextField inputID;
    JPasswordField inputPassword;
    JButton buttonLogin;
    JButton buttonQuit;
    boolean loginSuccess;
    String ID;
    JLabel jTitle,jImage,jL1,jL2;
    ImageIcon image;
    LoginView() {
        image = new ImageIcon("timg.jpg");
        jImage = new JLabel(image);
        jTitle = new JLabel("学生成绩管理系统");
        idAndPassword = new IDAndPassword();
        inputID = new JTextField(20);
        inputPassword = new JPasswordField(20);
        buttonLogin = new JButton("登录");
        buttonQuit = new JButton("退出");
        inputID.setPreferredSize(new Dimension(23,23));
        inputPassword.setPreferredSize(new Dimension(23,23));
        jTitle.setFont(new Font("宋体",Font.BOLD,35));
        jL1 =new JLabel("账号： ");
        jL1.setFont(new Font("root",Font.BOLD,25));
        jL2 = new JLabel("密码： ");
        jL2.setFont(new Font("root",Font.BOLD,25));
        setLayout(null);
        add(jL1);
        add(inputID);
        add(jL2);
        add(inputPassword);
        add(buttonLogin);
        add(buttonQuit);
        add(jTitle,JLayeredPane.DRAG_LAYER);
        add(jImage,JLayeredPane.DEFAULT_LAYER);
        jL1.setBounds(210,130,100,25);
        inputID.setBounds(285,130,150,25);
        jL2.setBounds(210,185,100,25);
        inputPassword.setBounds(285,185,150,25);
        buttonLogin.setBounds(205,230,80,25);
        buttonQuit.setBounds(360,230,80,25);
        jImage.setBounds(0,0,700,650);
        jTitle.setBounds(191,-20,350,200);
        buttonLogin.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),
                                JComponent.WHEN_IN_FOCUSED_WINDOW);
        //buttonQuit.registerKeyboardAction(this,);
        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"退出程序","退出",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        buttonLogin.addActionListener(this);

    }
    public boolean isLoginSuccess() {
        return loginSuccess;
    }
    public String getID() {
        return ID;
    }
    public void actionPerformed(ActionEvent e) {
        idAndPassword.setID(inputID.getText());
        char[] pw = inputPassword.getPassword();
        idAndPassword.setPassword(new String(pw));
        Login login = new Login();
        idAndPassword = login.queryVerify(idAndPassword);
        loginSuccess = idAndPassword.getLoginSuccess();
        ID = idAndPassword.getID();
        if(loginSuccess == true && (ID.contains("S") || ID.contains("s"))) {
            StudentInformation student = new UserInformation().getNewStudent(ID);
            StudentWindow window = new StudentWindow(student);
            SwingUtilities.getWindowAncestor(this).dispose(); //将上一窗口关闭
            window.setTitle("学生界面");
        } else if(loginSuccess == true && ( ID.contains("T") || ID.contains("t"))) {
            TeacherInformation teacher= new UserInformation().getNewTeacher(ID);
            TeacherWindow window = new TeacherWindow(teacher);
            SwingUtilities.getWindowAncestor(this).dispose();
            window.setTitle("教师界面");
        } else if(loginSuccess == true && ( ID.contains("A") || ID.contains("a")))  {
            AdminWindow window = new AdminWindow();
            SwingUtilities.getWindowAncestor(this).dispose();
            window.setTitle("管理员界面");
        }
    }
}
