package com.example.EventSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// 实现了 Observer 接口，表明这个类可以作为观察者来接收通知并执行特定操作
public class Input implements Observer {

    // 存储从文件读取的每行文本内容的列表
    private ArrayList<String> lineTxt = new ArrayList<String>();

    // 获取存储的每行文本内容列表的方法
    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

    // 存储要读取的文件名
    private String fileName;

    // 构造函数，接收文件名并初始化成员变量
    public Input(String fileName) {
        this.fileName = fileName;
    }

    // 实现 Observer 接口中的方法，当被通知时执行读取文件操作
    @Override
    public void toDo() {
        BufferedReader inputFile = null;
        try {
            // 创建一个 BufferedReader 用于读取指定文件
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            // 如果在创建 BufferedReader 过程中出现异常，打印堆栈信息
            e.printStackTrace();
        }
        String line;
        try {
            // 逐行读取文件内容，直到没有更多行可读
            while ((line = inputFile.readLine())!= null) {
                // 将读取的每行内容添加到 lineTxt 列表中
                lineTxt.add(line);
            }
        } catch (IOException e) {
            // 如果在读取文件过程中出现 IOException，打印堆栈信息
            e.printStackTrace();
        }
    }
}
