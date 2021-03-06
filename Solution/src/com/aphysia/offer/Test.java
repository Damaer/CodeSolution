package com.aphysia.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        removeVector();
    }

    public static void removeVector() {
        List list = new Vector();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    list.remove(0);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    list.remove(0);
                }
            }
        });
        long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        while (!list.isEmpty()) {

        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000 / 60);
    }
}
