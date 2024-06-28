package com.miko.simpledbapplication.controller;

import com.miko.simpledbapplication.model.SqlCommand;
import com.miko.simpledbapplication.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/db")
public class DbController {

    private final DbService dbService;

    @Autowired
    public DbController(DbService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/execute")
    public Map<String, String> executeSql(@RequestBody SqlCommand command) {
        return dbService.executeSql(command.getSql());
    }
}
