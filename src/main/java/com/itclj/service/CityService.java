package com.itclj.service;

import com.itclj.model.CityBean;

/**
 * Created by lujun.chen on 2017/3/13.
 */
public interface CityService {

  /**
   * 保存
   */
  Boolean save(CityBean cityBean);

  /**
   * 按照ID获取
   */
  public CityBean findById(Short id);

}
