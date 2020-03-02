package access.view.student;

import access.handle.student.SearchScore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SearchView extends JPanel implements ActionListener {
    JTextField inputID;
    JButton buttonSearch;
    JPanel p;
    JTable table;
    JScrollPane jsp;
    DefaultTableModel model;
    SearchView() {
        model = new SearchScore().TableAllScore();
        table = new JTable(model);
        table.setEnabled(false);
        jsp = new JScrollPane(table);
        p = new JPanel();
        inputID = new JTextField(12);
        buttonSearch = new JButton("查询");
        add(new JLabel("输入学号查询成绩："));
        add(inputID);
        add(buttonSearch);
        add(jsp);
        buttonSearch.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        buttonSearch.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        String ID = inputID.getText();
        ScoreDialog scoreDialog = new ScoreDialog((JFrame)SwingUtilities.getWindowAncestor(this), "成绩查询", ID);
        scoreDialog.setVisible(true);
    }

}
