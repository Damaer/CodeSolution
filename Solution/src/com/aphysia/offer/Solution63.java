package com.aphysia.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution63 {
    private int count = 0;
    private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 1) {
            // 奇数的时候，需要最小堆的元素比最大堆的元素多一个。
            // 先放到最大堆里面，然后弹出最大的
            max.offer(num);
            // 把最大的放进最小堆
            min.offer(max.poll());
        } else {
            // 放进最小堆
            min.offer(num);
            // 把最小的放进最大堆
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return (double) min.peek();
        }
    }

}
