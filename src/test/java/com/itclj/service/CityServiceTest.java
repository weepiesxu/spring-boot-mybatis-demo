package com.itclj.service;

import com.itclj.model.CityBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

  @Autowired
  private CityService cityService;

  @Test
  public void save() {
    CityBean cityBean = new CityBean();
    cityBean.setCity("城市名称05");
    cityBean.setCountryId((short) 1);
    cityService.save(cityBean);
  }

}
