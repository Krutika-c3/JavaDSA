package com.gfg.dsa.practice.stack;

public class StackMain {
    public static void main(String[] args) throws StackException {
        System.out.println("Infinite stack");

        CustomStack stack = new DynamicStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("---------------");
        System.out.println("5 level stack");

        CustomStack stack2 = new CustomStack(5);

        stack2.push(34);
        stack2.push(45);
        stack2.push(2);
        stack2.push(9);
        stack2.push(18);
        stack2.push(89); // stack won't allow - stack overflow

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop()); // stack will be empty before this
    }
}
