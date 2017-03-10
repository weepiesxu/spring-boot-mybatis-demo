package com.itclj.dao;

import com.itclj.model.CityBean;
import com.itclj.model.CityBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityBeanMapper {
    long countByExample(CityBeanExample example);

    int deleteByExample(CityBeanExample example);

    int deleteByPrimaryKey(Short cityId);

    int insert(CityBean record);

    int insertSelective(CityBean record);

    List<CityBean> selectByExample(CityBeanExample example);

    CityBean selectByPrimaryKey(Short cityId);

    int updateByExampleSelective(@Param("record") CityBean record, @Param("example") CityBeanExample example);

    int updateByExample(@Param("record") CityBean record, @Param("example") CityBeanExample example);

    int updateByPrimaryKeySelective(CityBean record);

    int updateByPrimaryKey(CityBean record);
}