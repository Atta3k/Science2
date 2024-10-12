package com.example.EventSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// 实现了 Observer 接口，表明这个类可以作为观察者来接收通知并执行特定操作
public class Output implements Observer {
    // 存储要输出的字符串列表
    private ArrayList<String> kwicList;
    // 用于写入文件的 BufferedWriter
    private BufferedWriter outputFile;
    // 输出文件的文件名
    private String filename;

    // 构造函数，接收字符串列表和文件名并初始化成员变量
    public Output(ArrayList<String> kwicList, String filename) {
        this.kwicList = kwicList;
        this.filename = filename;
    }

    // 实现 Observer 接口中的方法，当被通知时执行输出操作
    @Override
    public void toDo() {
        // 获取字符串列表的迭代器
        Iterator<String> it = kwicList.iterator();
        try {
            // 创建 BufferedWriter 用于写入指定文件名的文件
            outputFile = new BufferedWriter(new FileWriter(filename));
            // 遍历字符串列表并写入文件
            while (it.hasNext()) {
                outputFile.write(it.next() + "\n");
            }
        } catch (IOException e) {
            // 如果在写入文件过程中出现 IOException，打印堆栈信息
            e.printStackTrace();
        } finally {
            try {
                // 如果 BufferedWriter 不为 null，关闭它以释放资源
                if (outputFile!= null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                // 如果在关闭 BufferedWriter 过程中出现 IOException，打印堆栈信息
                e.printStackTrace();
            }
        }
    }
}
