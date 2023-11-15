package cn.entity;

public class Data {
    private Integer id;

    private String pic;

    private Integer uid;

    private String name;

    private String score;

    private Integer type;

    private Integer role;

    public Data(Integer id, String pic, Integer uid, String name, String score, Integer type, Integer role) {
        this.id = id;
        this.pic = pic;
        this.uid = uid;
        this.name = name;
        this.score = score;
        this.type = type;
        this.role = role;
    }

    public Data() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}