package access.view.student;

import access.handle.student.SearchScore;
import access.model.ScoreInformation;

import javax.swing.*;
import java.awt.*;

public class ScoreDialog extends JDialog {  //查找成绩的弹出来的文本框
    public ScoreDialog(JFrame f, String s, String id) {
        super(f,s);
        ScoreInformation score = new SearchScore().SearchAllScore(id);
        String textID = "学号 ： " + score.getStudentID();
        String textName = "姓名： " + score.getName();
        String textChinese = "语文： " + score.getChinese();
        String textMath = "数学： " + score.getMath();
        String textEnglish = "英语： " + score.getEnglish();
        String textAgg = "总分： " + score.getAgg();
        String text = "<html> " + textID + "<br/> " + textName + "<br/> " + textChinese +"" +
                "<br/> " + textMath + "<br/> " + textEnglish + "<br/> " + textAgg + "</html>";
        add(new JLabel(text),JLabel.CENTER);
        setLayout(new FlowLayout());
        setBounds(120,120,200,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
