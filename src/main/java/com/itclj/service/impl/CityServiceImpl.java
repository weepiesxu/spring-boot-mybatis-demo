package com.itclj.service.impl;

import com.itclj.dao.CityBeanMapper;
import com.itclj.model.CityBean;
import com.itclj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@Service(value = "cityService")
public class CityServiceImpl implements CityService {

  @Autowired
  private CityBeanMapper cityBeanMapper;

  @Transactional
  public Boolean save(CityBean cityBean) {
    if (null == cityBean.getCityId()) {
      return cityBeanMapper.insert(cityBean)>0?true:false;
    }else{
      return cityBeanMapper.updateByPrimaryKey(cityBean)>0?true:false;
    }
  }
}
