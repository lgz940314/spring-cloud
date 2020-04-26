package com.krupp.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-provider")
public interface HelloClient {

    @RequestMapping(value = "/echo/{string}")
    String echo(@PathVariable String string);

}
