package com.ibm.thread.test01;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sky on 2017/6/14.
 */
public class QueueTest {
    public static void main(String[] args) {

    }

    @Test
    public void testQueue() {
        Queue<String> queue = new LinkedList();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println("Head of queue is: " + queue.poll());
        System.out.println("Head of queue is: " + queue.poll());
        System.out.println("Head of queue is: " + queue.poll());
        System.out.println("Head of queue is: " + queue.poll());
        System.out.println("Head of queue is: " + queue.poll());
    }
}
