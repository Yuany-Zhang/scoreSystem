package access.view.login;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;


public class LoginWindow extends JFrame {
    public static  ImageIcon img=new ImageIcon("icon.jpg");  //标题栏图标，作为全局使用
    LoginView loginView;
    public LoginWindow() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        setResizable(false);  //forbiden max screen
        setScreenCentor(this);

        loginView = new LoginView();
        add(loginView, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(LoginWindow.img.getImage());
        setVisible(true);
    }
    public static void main(String args[]) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        LoginWindow window = new LoginWindow();
        String imgSrc = "timg,jpg";
        window.setTitle("登陆界面");
    }

    public static void setScreenCentor(JFrame jFrame)
    {
        jFrame.setResizable(false);  //forbiden max screen
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screensize.getWidth() / 2 - 700 / 2;
        int screenHight = (int)screensize.getHeight() / 2 - 650 / 2;
        jFrame.setBounds(screenWidth,screenHight,700,650);
    }

}
