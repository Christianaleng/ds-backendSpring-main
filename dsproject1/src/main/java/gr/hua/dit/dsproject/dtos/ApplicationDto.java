package gr.hua.dit.dsproject.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gr.hua.dit.dsproject.entities.User;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationDto {
    private String bachelorDegreeTitle;
    private String bachelorDegreeGrade;
    private String teachers;
    private String priority_number;
    private String mastername;
    private long id;
    private boolean setAcceptedbySecretary;
    private boolean setAcceptedbyTeacher;
    private User User;


    public gr.hua.dit.dsproject.entities.User getUser() {
        return User;
    }

    public void setUser(gr.hua.dit.dsproject.entities.User user) {
        User = user;
    }

    public String getPriority_number() {
        return priority_number;
    }

    public void setPriority_number(String priority_number) {
        this.priority_number = priority_number;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBachelorDegreeTitle() {
        return bachelorDegreeTitle;
    }

    public void setBachelorDegreeTitle(String bachelorDegreeTitle) {
        this.bachelorDegreeTitle = bachelorDegreeTitle;
    }

    public String getBachelorDegreeGrade() {
        return bachelorDegreeGrade;
    }

    public void setBachelorDegreeGrade(String bachelorDegreeGrade) {
        this.bachelorDegreeGrade = bachelorDegreeGrade;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public boolean isSetAcceptedbySecretary() {
        return setAcceptedbySecretary;
    }

    public void setSetAcceptedbySecretary(boolean setAcceptedbySecretary) {
        this.setAcceptedbySecretary = setAcceptedbySecretary;
    }

    public boolean isSetAcceptedbyTeacher() {
        return setAcceptedbyTeacher;
    }

    public void setSetAcceptedbyTeacher(boolean setAcceptedbyTeacher) {
        this.setAcceptedbyTeacher = setAcceptedbyTeacher;
    }
}
