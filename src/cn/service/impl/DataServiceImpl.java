package cn.service.impl;

import cn.dao.DataMapper;
import cn.entity.Data;
import cn.service.DataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    public DataMapper getDataMapper() {
        return dataMapper;
    }

    public void setDataMapper(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    @Override
    public int add(Data data) {//生成预约单
        return dataMapper.insert(data);
    }

    @Override
    public int del(Integer id) {
        return dataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Data data) {
        return dataMapper.updateByPrimaryKeySelective(data);
    }



    @Override
    public PageInfo<Data> getByUid(Map params) {
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Data> dataList=null;
        dataList=dataMapper.getByUid(params);
        return new PageInfo<Data>(dataList);
    }

    @Override
    public Data getById(Integer id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer pk(Map params) {
        Integer uid=(Integer)params.get("uid");
        Integer fid=(Integer)params.get("fid");
        Integer type=(Integer)params.get("type");
        Map<String,Object> temp=new HashMap<String,Object>();
        temp.put("id",uid);
        temp.put("type",type);
        List<Data> dataList1=dataMapper.getByMap(temp);
        Map<String,Object> temp1=new HashMap<String,Object>();
        temp1.put("id",fid);
        temp1.put("type",type);
        List<Data> dataList2=dataMapper.getByMap(temp1);
        if(type==0){//学科成绩
            Double sum1=0.0;
            Double sum2=0.0;
        for(Data d:dataList1){
        sum1+=Double.parseDouble(d.getScore());
        }
        for(Data d:dataList2){
        sum2+=Double.parseDouble(d.getScore());
        }
            if(sum1>sum2){
                return 0;
            }else if(sum1<sum2){
                return 1;
            }else{
                return 2;
            }

        }else{
            if(dataList1.size()>dataList2.size()){
                return 0;
            }else if(dataList1.size()<dataList2.size()){
                return 1;
            }else{
                return 2;
            }
        }
    }
}
