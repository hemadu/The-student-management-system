package cn.entity;

public class Grade {
    private Integer id;

    private Integer tid;

    private Integer sid;

    private String grade;

    private String name;

    public Grade(Integer id, Integer tid, Integer sid, String grade, String name) {
        this.id = id;
        this.tid = tid;
        this.sid = sid;
        this.grade = grade;
        this.name = name;
    }

    public Grade() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}