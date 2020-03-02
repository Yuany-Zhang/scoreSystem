package access.view.changePassword;

import access.handle.changePassword.ChangePassword;
import access.model.IDAndPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ChangePasswordView extends JPanel implements ActionListener {
    JPanel p1,p2,p3;
    IDAndPassword idAndPassword;
    JTextField inputID;
    JPasswordField inputOldPassword;
    JPasswordField inputNewPassword;
    JButton buttonChange;
    Box box;
    public ChangePasswordView() {
        idAndPassword = new IDAndPassword();
        inputID = new JTextField(20);
        inputOldPassword = new JPasswordField(20);
        inputNewPassword = new JPasswordField(20);
        box = Box.createVerticalBox();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        buttonChange = new JButton("确认修改");
        p1.add(new JLabel("账号："));
        p1.add(inputID);
        p2.add(new JLabel("密码："));
        p2.add(inputOldPassword);
        p3.add(new JLabel("新密码："));
        p3.add(inputNewPassword);
        add(buttonChange);
        box.add(p1);
        box.add(p2);
        box.add(p3);
        box.add(buttonChange);
        add(box);
        buttonChange.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        buttonChange.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        idAndPassword.setID(inputID.getText());
        char[] pw1 = inputOldPassword.getPassword();
        char[] pw2 = inputNewPassword.getPassword();
        idAndPassword.setPassword(new String(pw1));
        idAndPassword.setNewPassword(new String(pw2));
        ChangePassword changePassword = new ChangePassword();
        idAndPassword = changePassword.queryVerify(idAndPassword);
    }
}
