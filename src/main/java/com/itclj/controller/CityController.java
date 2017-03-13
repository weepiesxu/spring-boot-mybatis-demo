package com.itclj.controller;

import com.itclj.model.CityBean;
import com.itclj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@Controller
@RequestMapping("/city")
public class CityController {

  @Autowired
  private CityService cityService;

  @ResponseBody
  @RequestMapping("/detail/{id}")
  public CityBean findById(@PathVariable Short id) {
    return cityService.findById(id);
  }

}
