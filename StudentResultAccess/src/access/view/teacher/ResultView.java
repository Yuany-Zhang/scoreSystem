package access.view.teacher;

import access.model.TeacherInformation;
import access.handle.teacher.ResultInsert;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ResultView extends JPanel implements ActionListener {
    DefaultTableModel model;
    JTable table;
    JScrollPane jsp;
    JButton buttonRefesh;
    static String course;
    ResultView(TeacherInformation teacher) {
        course = teacher.getCourse();
        buttonRefesh = new JButton("刷新");
        model = new ResultInsert().showResult(course);
        table = new JTable(model);
        jsp = new JScrollPane(table);
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),"doNothing");  //让table的Enter功能失效
        table.getActionMap().put("doNothing", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        add(jsp, BorderLayout.CENTER);
        add(buttonRefesh,BorderLayout.EAST);
        jsp.setBounds(150, 150, 600, 100);
        buttonRefesh.addActionListener(this);
        buttonRefesh.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),
                JComponent.WHEN_IN_FOCUSED_WINDOW); //快捷键
    }
    public void actionPerformed(ActionEvent e) {
        table.setModel(new ResultInsert().showResult(course));
    }
}
