package com.sb.controller;

import com.sb.model.User;
import com.sb.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sammy
 * @Date: 2018/5/22 11:45
 * @Description:
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {


    @Autowired
    MongoService mongoService;

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public String insert(@RequestBody User user) {

        mongoService.insert(user);
        return "OK";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.GET})
    public String find(@RequestBody User user) {

        return "OK";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String update(@RequestBody User user) {

        return "OK";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public String delete(@RequestBody User user) {

        return "OK";
    }

}
