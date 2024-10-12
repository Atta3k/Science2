package com.example.EventSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

// 实现了 Observer 接口，表明这个类可以作为观察者来接收通知并执行特定操作
public class Shift implements Observer {
    // 存储经过循环移位后的字符串列表
    private ArrayList<String> kwicList = new ArrayList<String>();
    // 存储原始输入的字符串列表
    private ArrayList<String> lineTxt;

    // 构造函数，接收原始输入的字符串列表并初始化成员变量
    public Shift(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    // 获取经过循环移位后的字符串列表的方法
    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    // 获取原始输入的字符串列表的方法
    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

    // 实现 Observer 接口中的方法，当被通知时执行循环移位操作
    @Override
    public void toDo() {
        // 获取原始输入字符串列表的迭代器
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            // 使用 StringTokenizer 对当前行进行分割，获取每个单词
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<String>();
            int i = 0;
            // 循环添加单词到 tokens 列表
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            // 切割各个单词，不断改变起始值和利用循环实现位移
            for (i = 0; i < count; i++) {
                // 创建一个 StringBuffer 用于存储当前位移后的字符串
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    // 当索引超出单词数量时，从头继续位移
                    if (index >= count)
                        index = 0;
                    // 将单词添加到 StringBuffer
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                // 将当前位移后的字符串存入 kwicList
                String tmp = lineBuffer.toString();
                kwicList.add(tmp);
            }
        }
    }
}
