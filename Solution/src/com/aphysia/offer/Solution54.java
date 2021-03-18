package com.aphysia.offer;

import java.util.Queue;
import java.util.LinkedList;
import java.lang.Character;

public class Solution54 {
    int[] charCount = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    // 模拟输入字符
    public void Insert(char ch) {
        if (charCount[ch] == 0) {
            queue.add(ch);
        }
        charCount[ch]++;
    }

    // 模拟输出第一个只出现一次的字符
    public char FirstAppearingOnce() {
        Character character = null;
        char c = 0;
        // 取出队列的第一个
        while ((character = queue.peek()) != null) {
            // 取出里面的字符
            c = character.charValue();
            // 判断个数是不是为1
            if (charCount[c] == 1) {
                return c;
            }
            else {queue.remove();}
        }
        return '#';
    }
}
