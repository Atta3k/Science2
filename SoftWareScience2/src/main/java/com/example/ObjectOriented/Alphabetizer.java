package com.example.ObjectOriented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 这个类用于对字符串列表进行字母排序
public class Alphabetizer {
    // 存储待排序的字符串列表
    private ArrayList<String> kwicList;

    // 构造函数，接收一个字符串列表并初始化成员变量
    public Alphabetizer(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    // 获取存储的字符串列表的方法
    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    // 排序方法
    public void sort() {
        // 使用 Java 集合框架的排序方法对字符串列表进行排序，传入自定义的比较器
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    // 内部类，实现比较器接口，用于定义字符串比较的规则
    private class AlphabetizerComparator implements Comparator<String> {
        // 重写比较方法，定义字符串比较的具体逻辑
        @Override
        public int compare(String o1, String o2) {
            // 如果两个字符串都为 null，抛出空指针异常
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            // 获取两个字符串首字符的小写形式进行比较
            char o1c = o1.toLowerCase().charAt(0);
            char o2c = o2.toLowerCase().charAt(0);
            // 计算比较值
            compareValue = o1c - o2c;
            return compareValue;
        }
    }
}
