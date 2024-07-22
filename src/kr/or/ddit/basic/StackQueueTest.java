package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
    /**
     *  Stack -> 후입선출 LIFO
     *  Queue -> 선입선출 FIFO
     *
     *  스택 큐는 LinkedList를 이요하여 사용할수있음
     */

    public static void main(String[] args) {

        /**
         * stack의 명령
         * 1. 자료의 입력 : push(입력값)
         * 2. 자료의 출력 : pop() 값을 꺼내고 자료를 스택에서 삭제
         *                peek() 삭제없이 자료 꺼내기
         */

        Stack<String> stack = new Stack<>();

        stack.push("안녕");
        stack.push("나는");
        stack.push("지렁이야");
        stack.push("반가워");

        System.out.println("stack = " + stack);

        String data = stack.pop();
        System.out.println("data = " + data);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack = " + stack);

        System.out.println("----------------------------");


        /**
         * Queue의 명령
         * 자료 입력 : offer(입력값)
         * 자료 출력 : poll() -> 자료를 꺼내오고 꺼내온 데이터를 Queue에서 삭제
         *            peek() -> 삭제안하고 꺼내옴
         *
         */

        Queue<String> queue = new LinkedList<>();

        queue.offer("안녕");
        queue.offer("나는");
        queue.offer("지렁이야");
        queue.offer("반가워");

        System.out.println("queue = " + queue);

        String temp = queue.poll();
        System.out.println("temp = " + temp);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);

        queue.offer("너는 누구니");
        System.out.println("queue = " + queue);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);
    }


}
