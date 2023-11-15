package cn.entity;

public class Grow {
    private Integer id;

    private Integer uid;

    private String pic;

    private String date;

    private String title;

    private String content;

    private String type;

    private Integer role;

    public Grow(Integer id, Integer uid, String pic, String date, String title, String content, String type, Integer role) {
        this.id = id;
        this.uid = uid;
        this.pic = pic;
        this.date = date;
        this.title = title;
        this.content = content;
        this.type = type;
        this.role = role;
    }

    public Grow() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}