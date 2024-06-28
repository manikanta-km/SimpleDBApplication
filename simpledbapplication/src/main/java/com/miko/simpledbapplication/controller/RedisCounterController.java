package com.miko.simpledbapplication.controller;

import com.miko.simpledbapplication.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/db/counters")
public class RedisCounterController {

    private final RedisUtil redisUtil;

    @Autowired
    public RedisCounterController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @GetMapping
    public Map<String, Long> getCounters() {
        Map<String, Long> counters = new HashMap<>();
        counters.put("SUCCESS", redisUtil.getCounter("SUCCESS"));
        counters.put("FAILURE", redisUtil.getCounter("FAILURE"));
        return counters;
    }
}
