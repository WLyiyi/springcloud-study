package com.lw.service;

import com.lw.entities.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Feign使用Hystric熔断机制。
 */
@FeignClient(value = "STUDY-SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {


    @GetMapping(value = "/dept/findById/{deptNo}")
     DeptEntity findById(@PathVariable("deptNo") Long deptNo);

    @GetMapping(value = "/dept/findAll")
     List findAll();
}