package com.littleqworks.commons.collection;

import java.util.*;

public class ArrayStackImpl<E> implements ArrayStack<E>{
	private ArrayList<E> arrayList=new ArrayList<E>(STACK_SIZE);
	
	/**
	 * ����ջ�Ƿ�Ϊ��
	 * @return �����ջΪ���򷵻�true�����򷵻�false
	 */
	public boolean isEmpty(){
		return arrayList.isEmpty();
	}
	
	/**
	 * ����ջ�Ƿ�����
	 * @return �����ջΪ���򷵻�true�����򷵻�false
	 */
	public boolean isFull(){
		return arrayList.size()==STACK_SIZE;
	}

	/**
	 * ����ջ��Ԫ��
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
	 */
	public E pop() throws StackEmptyException{
		if(arrayList.isEmpty()){
			throw new StackEmptyException("ArrayStack is empty.");
		}
		E temp=arrayList.get(arrayList.size()-1);
		arrayList.remove(arrayList.size()-1);
		return temp;
	}
	
	/**
	 * ��һ��Ԫ��ѹ���ջ
	 * @param element Ԫ��
	 */
	public void push(E element) throws StackOverflowException{
		if(isFull()){
			throw new StackOverflowException("ArrayStack overflows.");
		}
		arrayList.add(element);
	}
	
	/**
	 * ��ȡջ��Ԫ�أ������ı��ջ�Ľṹ
	 * @return E ջ��Ԫ��
	 * @throws StackEmptyException ��ջ��ʱ
	 */
	public E getTopElement() throws StackEmptyException{
		if(arrayList.isEmpty()){
			throw new StackEmptyException("ArrayStack is empty.");
		}
		return arrayList.get(arrayList.size()-1);
	}
}
