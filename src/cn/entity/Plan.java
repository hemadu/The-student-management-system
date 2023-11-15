package cn.entity;

public class Plan {
    private Integer id;

    private Integer uid;

    private String year;

    private String content;

    private Integer type;

    public Plan(Integer id, Integer uid, String year, String content, Integer type) {
        this.id = id;
        this.uid = uid;
        this.year = year;
        this.content = content;
        this.type = type;
    }

    public Plan() {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}