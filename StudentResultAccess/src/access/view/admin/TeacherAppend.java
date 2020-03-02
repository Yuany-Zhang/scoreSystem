package access.view.admin;
import access.handle.admin.HandleTeacherInformation;
import access.model.TeacherInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class TeacherAppend extends JPanel implements ActionListener {
    TeacherInformation teacher;
    JRadioButton radioM, radioF;
    ButtonGroup group;
    JTextField inputID, inpurName, inputCourse, inputBirth, deleteID;
    JButton buttonAppend, buttonDelete;
    DefaultTableModel model;
    JTable table;
    JScrollPane jsp;
    JPanel panel1,panel2;

    TeacherAppend() {
        teacher = new TeacherInformation();
        inputID = new JTextField(12);
        inpurName = new JTextField(12);
        inputCourse = new JTextField(12);
        deleteID = new JTextField(12);
        radioM = new JRadioButton("男");
        radioF = new JRadioButton("女");
        group = new ButtonGroup();
        group.add(radioM);
        group.add(radioF);
        inputBirth = new JTextField(12);
        buttonAppend = new JButton("增加");
        buttonDelete = new JButton("删除");
        panel1 = new JPanel();
        panel2 = new JPanel();
        add(new JLabel("工号:"));
        add(inputID);
        add(new JLabel("姓名："));
        add(inpurName);
        add(new JLabel("授课科目："));
        add(inputCourse);
        add(new JLabel("性别："));
        add(radioM);
        add(radioF);
        panel1.add(new JLabel("生日(****-**-**)："));
        panel1.add(inputBirth);
        panel1.add(buttonAppend);
        add(panel1);
        model = new HandleTeacherInformation().showTeacherInformation();
        table = new JTable(model);
        table.setEnabled(false);
        jsp = new JScrollPane(table);
        add(jsp);
        jsp.setBounds(150, 150, 600, 100);
        panel2.add(new JLabel("输入工号删除该教师信息："));
        panel2.add(deleteID);
        panel2.add(buttonDelete);
        add(panel2);
        buttonAppend.addActionListener(this);
        buttonDelete.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAppend) {
            teacher.setId(inputID.getText());
            teacher.setName(inpurName.getText());
            teacher.setCourse(inputCourse.getText());
            teacher.setSex(radioM.isSelected() ? radioM.getText() : radioF.getText());
            teacher.setBirthday(inputBirth.getText());
            HandleTeacherInformation handleTeacherInformation = new HandleTeacherInformation();
            handleTeacherInformation.writeTeacherInformation(teacher);
        }
        else if(e.getSource() == buttonDelete) {
            HandleTeacherInformation handleTeacherInformation = new HandleTeacherInformation();
            handleTeacherInformation.deleteTeacherInformation(deleteID.getText());
        }
        table.setModel(new HandleTeacherInformation().showTeacherInformation());
    }
}
