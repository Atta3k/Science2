package com.example.EventSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 实现了 Observer 接口，表明这个类可以作为观察者来接收通知并执行特定操作
public class Alphabetizer implements Observer {
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

    // 实现 Observer 接口中的方法，当被通知时执行排序操作
    @Override
    public void toDo() {
        // 使用 Java 集合框架的排序方法对字符串列表进行排序
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    // 内部类，用于定义比较两个字符串的规则
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
