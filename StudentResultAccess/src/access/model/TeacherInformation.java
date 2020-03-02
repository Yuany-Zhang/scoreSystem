package access.model;

public class TeacherInformation {
    String id;
    String name;
    String course;
    String sex;
    String birthday;
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name;}
    public void setCourse(String course) { this.course = course;}
    public void setSex(String sex) { this.sex = sex;}
    public void setBirthday(String birthday) { this.birthday = birthday;}
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCourse() {
        return course;
    }
    public String getSex() {
        return sex;
    }
    public String getBirthday() {
        return birthday;
    }
}
