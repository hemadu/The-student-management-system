package cn.dao;
import cn.entity.Grow;
import java.util.List;
import java.util.Map;

public interface GrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grow record);

    int insertSelective(Grow record);

    Grow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grow record);

    int updateByPrimaryKey(Grow record);

    List<Grow> getByUid(Map<String,Object> params);
}