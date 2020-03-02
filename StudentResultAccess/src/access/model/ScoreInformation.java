package access.model;

public class ScoreInformation {
    String studentID;
    String name;
    double Chinese;
    double math;
    double English;
    double agg;
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public void setChinese(double chinese) {
        this.Chinese = chinese;
    }
    public void setMath(double math) {
        this.math = math;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgg(double agg) {
        this.agg = agg;
    }

    public String getName() {
        return name;
    }

    public double getAgg() {
        return agg;
    }

    public void setEnglish(double english) {
        this.English = english;
    }
    public String getStudentID() {
        return studentID;
    }

    public double getChinese() {
        return Chinese;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return English;
    }
}
