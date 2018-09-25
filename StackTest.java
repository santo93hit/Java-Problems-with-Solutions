package com.test;

public class StackTest {

	 public static void main(String a[]){
	        MyGenericsStack<String> stringStack = new MyGenericsStack<String>(2);
	        stringStack.push("java2novice");
	        MyGenericsStack<Integer> integerStack = new MyGenericsStack<Integer>(2);
	        integerStack.push(23);
	    }

}
