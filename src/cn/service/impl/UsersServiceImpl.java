package cn.service.impl;

import cn.dao.UsersMapper;
import cn.entity.Users;
import cn.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public UsersMapper getUsersMapper() {
        return usersMapper;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public int add(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public int del(Integer id) {
        return usersMapper.delete(id);
    }

    @Override
    public int update(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public PageInfo<Users> getByMap(Map<String,Object> params) {
        //创建一个分页工具类
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Users> usersList=null;
        usersList=usersMapper.selectAll(params);
        return new PageInfo<Users>(usersList);
    }

    @Override
    public Users getById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Users login(String username, String password) {
        Users users=usersMapper.check(username);
        if(users!=null){
            if(users.getPassword().equals(password)){
                return users;
            }
        }
        return null;
    }

    @Override
    public Users check(String username) {
        return usersMapper.check(username);
    }

    @Override
    public PageInfo<Users> getAllById(Map<String, Object> params) {
        //创建一个分页工具类
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Users> usersList=(List<Users>) params.get("usersList");
        return new PageInfo<Users>(usersList);
    }
}
