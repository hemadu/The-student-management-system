package cn.service.impl;

import cn.dao.GrowMapper;
import cn.entity.Grow;
import cn.service.GrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GrowServiceImpl implements GrowService {

    @Autowired
    private GrowMapper growMapper;

    public GrowMapper getGrowMapper() {
        return growMapper;
    }

    public void setGrowMapper(GrowMapper growMapper) {
        this.growMapper = growMapper;
    }

    @Override
    public int add(Grow grow) {//生成预约单
        return growMapper.insert(grow);
    }

    @Override
    public int del(Integer id) {
        return growMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Grow grow) {
        return growMapper.updateByPrimaryKeySelective(grow);
    }



    @Override
    public PageInfo<Grow> getByUid(Map params) {
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Grow> growList=null;
        growList=growMapper.getByUid(params);
        return new PageInfo<Grow>(growList);
    }

    @Override
    public Grow getById(Integer id) {
        return growMapper.selectByPrimaryKey(id);
    }
}
