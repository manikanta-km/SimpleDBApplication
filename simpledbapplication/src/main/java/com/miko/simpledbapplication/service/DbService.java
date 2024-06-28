package com.miko.simpledbapplication.service;


import com.miko.simpledbapplication.util.RedisUtil;
import com.miko.simpledbapplication.util.SqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DbService {

    private static final String METADATA_FILE = "metadata.txt";
    private static final String TABLE_FILE = "table.txt";
    private final RedisUtil redisUtil;

    @Autowired
    public DbService(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public Map<String, String> executeSql(String sql) {
        Map<String, String> response = new HashMap<>();
        try {
            if (SqlParser.isCreateTable(sql)) {
                handleCreateTable(SqlParser.parseCreateTable(sql));
                response.put("status", "success");
                response.put("message", "Table created successfully");
                response.put("command", sql);
                redisUtil.incrementCounter("SUCCESS");
            } else if (SqlParser.isInsertInto(sql)) {
                handleInsertInto(SqlParser.parseInsertInto(sql));
                response.put("status", "success");
                response.put("message", "Row(s) inserted successfully");
                response.put("command", sql);
                redisUtil.incrementCounter("SUCCESS");
            } else {
                throw new IllegalArgumentException("Invalid SQL command");
            }
        } catch (Exception e) {
            redisUtil.incrementCounter("FAILURE");
            response.put("status", "error");
            response.put("message", "Failed to execute SQL command");
            response.put("details", e.getMessage());
            response.put("command", sql);
        }
        return response;
    }

    private void handleCreateTable(String metadata) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(METADATA_FILE, true))) {
            writer.write(metadata);
            writer.newLine();
        }
    }

    private void handleInsertInto(String[] values) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TABLE_FILE, true))) {
            writer.write(values[1]);
            writer.newLine();
        }
    }
}
