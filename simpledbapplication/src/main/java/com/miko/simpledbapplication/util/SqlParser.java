package com.miko.simpledbapplication.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlParser {
    private static final Pattern CREATE_TABLE_PATTERN = Pattern.compile("CREATE TABLE \\((.*)\\)", Pattern.CASE_INSENSITIVE);
    private static final Pattern INSERT_INTO_PATTERN = Pattern.compile("INSERT INTO VALUES \\((.*)\\) VALUES \\((.*)\\)", Pattern.CASE_INSENSITIVE);

    public static boolean isCreateTable(String sql) {
        return CREATE_TABLE_PATTERN.matcher(sql).matches();
    }

    public static boolean isInsertInto(String sql) {
        return INSERT_INTO_PATTERN.matcher(sql).matches();
    }

    public static String parseCreateTable(String sql) {
        Matcher matcher = CREATE_TABLE_PATTERN.matcher(sql);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String[] parseInsertInto(String sql) {
        Matcher matcher = INSERT_INTO_PATTERN.matcher(sql);
        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        return null;
    }
}
