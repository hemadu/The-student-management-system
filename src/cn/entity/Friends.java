package cn.entity;

public class Friends {
    private Integer id;

    private Integer uid;

    private Integer fid;

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Friends(Integer id, Integer uid, Integer fid) {
        this.id = id;
        this.uid = uid;
        this.fid = fid;
    }

    public Friends() {
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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}