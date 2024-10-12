package com.example.EventSystem;

// 这个类继承自 Subject，表明它可以作为主题被观察者观察
public class KWICSubject extends Subject {
    // 启动 KWIC 的方法
    public void startKWIC() {
        // 循环通知四个观察者
        for (int i = 0; i < 4; i++) {
            // 调用父类的通知单个观察者的方法
            super.notifyOneObserver(i);
        }
    }
}
