package com.krupp.feign.controller;

import com.krupp.feign.client.HelloClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(String string) {
        if (StringUtils.isBlank(string)){
            string = "2020";
        }
        String echo = helloClient.echo(string);
        return echo;
    }
}
