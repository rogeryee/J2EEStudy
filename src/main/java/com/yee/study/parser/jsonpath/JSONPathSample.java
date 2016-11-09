package com.yee.study.parser.jsonpath;

import com.jayway.jsonpath.JsonPath;
import com.yee.study.utilites.FileUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Author: RogerYee
 * Create: 10/31/16
 */
public class JSONPathSample
{
    public static void main(String[] args) throws IOException
    {
        JSONPathSample sample = new JSONPathSample();
        String filePath = sample.getClass().getResource("sample.json").getPath();

        byte[] bytes = FileUtil.readAsByteArray(new FileInputStream(filePath));
        String json = new String(bytes);

        System.out.println(json);

        // 1. 简单读取JSON
        List<String> authors = JsonPath.read(json, "$.store.book[*].author");
        System.out.println("authors = " + authors);
    }
}
