package com.littleqworks.commons.collection;

import junit.framework.*;
import com.littleqworks.commons.util.PrintUtils;

public class Test extends TestCase {
	public Test(String name){
		super(name);
	}
	
	public void testLinkedStack(){
		LinkedStackImpl<String> linkedStack=new LinkedStackImpl<String>();
		linkedStack.push("a");
		linkedStack.push("b");
		linkedStack.push("c");
		PrintUtils.println(linkedStack.pop());
		PrintUtils.println(linkedStack.pop());
		PrintUtils.println(linkedStack.pop());
	}
	
	public void testArrayStack(){
		ArrayStackImpl<String> arrayStack=new ArrayStackImpl<String>();
		arrayStack.push("a");
		arrayStack.push("b");
		arrayStack.push("c");
		PrintUtils.println(arrayStack.pop());
		PrintUtils.println(arrayStack.pop());
		PrintUtils.println(arrayStack.pop());
	}
	
	public static void compareArrayLinked(){
		LinkedStackImpl<String> linkedStack=new LinkedStackImpl<String>();
		linkedStack.push("a");
		linkedStack.push("b");
		linkedStack.push("c");
		long before=System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			linkedStack.getTopElement();
		}
		long after=System.currentTimeMillis();
		System.out.println(after-before);

		ArrayStackImpl<String> arrayStack=new ArrayStackImpl<String>();
		arrayStack.push("a");
		arrayStack.push("b");
		arrayStack.push("c");
		long before2=System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			arrayStack.getTopElement();
		}
		long after2=System.currentTimeMillis();
		System.out.println(after2-before2);
	}
}
