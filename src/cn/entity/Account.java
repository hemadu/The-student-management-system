package cn.entity;

public class Account {
    private Integer id;

    private Integer uid;

    private Double price;

    private Integer type;

    private Integer role;

    public Account(Integer id, Integer uid, Double price, Integer type, Integer role) {
        this.id = id;
        this.uid = uid;
        this.price = price;
        this.type = type;
        this.role = role;
    }

    public Account() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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