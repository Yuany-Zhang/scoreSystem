package access.view.admin;
import access.handle.admin.HandleStudentInformation;
import access.model.StudentInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentAppend extends JPanel implements ActionListener {
    StudentInformation student;
    JRadioButton radioM, radioF;
    ButtonGroup group;
    JTextField inputID, inpurName, inputBirth, deleteID;
    JButton buttonAppend, buttonDelete;
    DefaultTableModel model;
    JTable table;
    JScrollPane jsp;
    JPanel panel1,panel2;

    StudentAppend() {
        student = new StudentInformation();
        inputID = new JTextField(12);
        inpurName = new JTextField(12);
        deleteID = new JTextField(12);
        radioM = new JRadioButton("男");
        radioF = new JRadioButton("女");
        group = new ButtonGroup();
        panel1 = new JPanel();
        panel2 = new JPanel();
        group.add(radioM);
        group.add(radioF);
        inputBirth = new JTextField(12);
        buttonAppend = new JButton("增加");
        buttonDelete = new JButton("删除");
        add(new JLabel("学号:"));
        add(inputID);
        add(new JLabel("姓名："));
        add(inpurName);
        add(new JLabel("性别："));
        add(radioM);
        add(radioF);
        panel1.add(new JLabel("生日(****-**-**)："));
        panel1.add(inputBirth);
        add(panel1);
        add(buttonAppend);
        model = new HandleStudentInformation().showStudentInformation();
        table = new JTable(model);
        table.setEnabled(false);
        jsp = new JScrollPane(table);
        add(jsp);
        jsp.setBounds(0, 150, 60, 80);
        panel2.add(new JLabel("输入学号删除该学生信息："));
        panel2.add(deleteID);
        panel2.add(buttonDelete);
        add(panel2);
        buttonAppend.addActionListener(this);
        buttonDelete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAppend) {
            student.setId(inputID.getText());
            student.setName(inpurName.getText());
            student.setSex(radioM.isSelected() ? radioM.getText() : radioF.getText());
            student.setBirthday(inputBirth.getText());
            HandleStudentInformation handleStudentInformation = new HandleStudentInformation();
            handleStudentInformation.writeStudentInformation(student);
        } else if (e.getSource() == buttonDelete) {
            HandleStudentInformation handleStudentInformation = new HandleStudentInformation();
            handleStudentInformation.deleteStudentInformation(deleteID.getText());
        }
        table.setModel(new HandleStudentInformation().showStudentInformation());
    }
}
