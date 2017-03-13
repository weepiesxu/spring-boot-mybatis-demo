package com.itclj.service;

import com.alibaba.fastjson.JSON;
import com.itclj.model.CityBean;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

  private static Logger logger= LoggerFactory.getLogger(CityServiceTest.class);

  @Autowired
  private CityService cityService;

  @Test
  public void save() {
    CityBean cityBean = new CityBean();
    cityBean.setCity("城市名称05");
    cityBean.setCountryId((short) 1);
    cityService.save(cityBean);
  }

  @Test
  public void listPage() {
    Integer pageNum=1;//页码，从1开始
    Integer pageSize=10;//每页记录数
    CityBean cityBean = new CityBean();
    //cityBean.setCity("Zaria");
    List<CityBean> list = cityService.listPage(cityBean,pageNum,pageSize);
    logger.info(JSON.toJSONString(list));

  }
}
