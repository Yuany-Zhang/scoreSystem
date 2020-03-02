package access.model;

public class ResultAggInformation {
    double averageScoreAgg;
    double averageScoreChinese;
    double averageScoreMath;
    double averageScoreEnglish;
    int countDownSix,countSix,countSeven,countEight,countNine;
    public void setAverageScoreAgg(double averageScoreAgg) {
        this.averageScoreAgg = averageScoreAgg;
    }
    public void setAverageScoreChinese(double averageScoreChinese) {
        this.averageScoreChinese = averageScoreChinese;
    }
    public void setAverageScoreMath(double averageScoreMath) {
        this.averageScoreMath = averageScoreMath;
    }
    public void setAverageScoreEnglish(double averageScoreEnglish) {
        this.averageScoreEnglish = averageScoreEnglish;
    }
    public void setCountDownSix(int downSix) {
        this.countDownSix = downSix;
    }
    public void setCountSix(int six) {
        this.countSix = six;
    }
    public void setCountSeven(int seven) {
        this.countSeven = seven;
    }
    public void setCountEight(int eight) {
        this.countEight = eight;
    }
    public void setCountNine(int nine) {
        this.countNine = nine;
    }
    public double getAverageScoreAgg() {
        return averageScoreAgg;
    }

    public double getAverageScoreChinese() {
        return averageScoreChinese;
    }

    public double getAverageScoreEnglish() {
        return averageScoreEnglish;
    }

    public double getAverageScoreMath() {
        return averageScoreMath;
    }

    public int getCountDownSix() {
        return countDownSix;
    }

    public int getCountEight() {
        return countEight;
    }

    public int getCountNine() {
        return countNine;
    }

    public int getCountSeven() {
        return countSeven;
    }

    public int getCountSix() {
        return countSix;
    }
}

