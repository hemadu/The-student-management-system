package cn.service.impl;

import cn.dao.FriendsMapper;
import cn.entity.Friends;
import cn.service.FriendsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsMapper friendsMapper;

    public FriendsMapper getFriendsMapper() {
        return friendsMapper;
    }

    public void setFriendsMapper(FriendsMapper friendsMapper) {
        this.friendsMapper = friendsMapper;
    }

    @Override
    public int add(Friends friends) {//生成预约单
        return friendsMapper.insert(friends);
    }

    @Override
    public int del(Integer id) {
        return friendsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Friends friends) {
        return friendsMapper.updateByPrimaryKeySelective(friends);
    }

    @Override
    public PageInfo<Friends> getByUid(Map<String, Object> params) {
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Friends> friendsList=null;
        friendsList=friendsMapper.getByUid(params);
        return new PageInfo<Friends>(friendsList);
    }

    @Override
    public Friends getById(Integer id) {
        return friendsMapper.selectByPrimaryKey(id);
    }

}
