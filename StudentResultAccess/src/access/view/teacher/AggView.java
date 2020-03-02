package access.view.teacher;

import access.handle.teacher.ResultCalculation;
import access.model.ResultAggInformation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AggView extends JPanel implements ActionListener {
    JPanel jp1,jp2,jp3;
    DefaultTableModel model;
    JTable table;
    JScrollPane jslp;
    JButton buttonRefesh;
    ResultAggInformation result;
    AggView() {
        ResultAggInformation result = new ResultAggInformation();
        model = new ResultCalculation().showAndSetCal(result);
        table = new JTable(model);
        table.setEnabled(false);
        jslp = new JScrollPane(table);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        buttonRefesh = new JButton("刷新");
        jp1.add(new JLabel("总分平均分："));
        jp1.add(new JLabel(String.valueOf(result.getAverageScoreAgg()) + " "));
        jp1.add(new JLabel("语文平均分："));
        jp1.add(new JLabel(String.valueOf(result.getAverageScoreChinese()) + " "));
        jp1.add(new JLabel("数学平均分："));
        jp1.add(new JLabel(String.valueOf(result.getAverageScoreMath()) + " "));
        jp1.add(new JLabel("英语平均分："));
        jp1.add(new JLabel(String.valueOf(result.getAverageScoreEnglish()) + " "));
        jp2.add(new JLabel("总分 < 180:"));
        jp2.add(new JLabel(String.valueOf(result.getCountDownSix()) + "人  "));
        jp2.add(new JLabel("180 <= 总分 < 210:"));
        jp2.add(new JLabel(String.valueOf(result.getCountSix()) + "人  "));
        jp2.add(new JLabel("210 <= 总分 < 240:"));
        jp2.add(new JLabel(String.valueOf(result.getCountSeven()) + "人  "));
        jp2.add(new JLabel("240 <= 总分 < 270:"));
        jp2.add(new JLabel(String.valueOf(result.getCountEight()) + "人  "));
        jp2.add(new JLabel("总分 >= 270:"));
        jp2.add(new JLabel(String.valueOf(result.getCountNine()) + "人 "));
        jp2.setLayout(new FlowLayout());
        jp2.setLayout(new FlowLayout());
        add(jp1,BorderLayout.NORTH);
        add(jp2,BorderLayout.SOUTH);
        add(jslp,BorderLayout.CENTER);
        add(buttonRefesh,BorderLayout.EAST);
         buttonRefesh.registerKeyboardAction(this,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),
                  JComponent.WHEN_IN_FOCUSED_WINDOW);
        buttonRefesh.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        ResultAggInformation result = new ResultAggInformation();
        table.setModel(new ResultCalculation().showAndSetCal(result));

    }
}
