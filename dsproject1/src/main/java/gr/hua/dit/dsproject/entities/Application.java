package gr.hua.dit.dsproject.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bachelorDegreeTitle")
    private String bachelorDegreeTitle;

    @Column(name = "bachelorDegreeGrade")
    private String bachelorDegreeGrade;
    @Column(name = "teachers")
    private String teachers;

    @Column(name = "mastername")
    private String mastername;
    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    @ManyToOne(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User User;

    private int priorityNumber;
    private boolean setAcceptedbySecretary;
    private boolean setAcceptedbyTeacher;
    public Application(User user, String bachelorDegreeTitle, double bachelorDegreeGrade) {
    }

    public Application() {
    }

    public Application(String mastername,String bachelorDegreeTitle, String bachelorDegreeGrade) {
        this.mastername = mastername;
        this.bachelorDegreeTitle = bachelorDegreeTitle;
        this.bachelorDegreeGrade = bachelorDegreeGrade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
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

    public gr.hua.dit.dsproject.entities.User getUser() {
        return User;
    }

    public void setUser(gr.hua.dit.dsproject.entities.User user) {
        User = user;
    }

    @Override
    public String toString() {
        return "Application{" +
                "bachelorDegreeTitle='" + bachelorDegreeTitle + '\'' +
                ", bachelorDegreeGrade='" + bachelorDegreeGrade + '\'' +
                '}';
    }

    public void setPriorityNumber(int priorityNumber) {
    }

    public void setAcceptedbySecretary(boolean b) {
        this.setAcceptedbySecretary = b;
    }
    public void setAcceptedbyTeacher(boolean b) {
        this.setAcceptedbyTeacher= b;
    }

    public boolean getAcceptedbySecretary() {
        return setAcceptedbySecretary;
    }

    public boolean getAcceptedbyTeacher()  {
        return setAcceptedbyTeacher;
    }
}
