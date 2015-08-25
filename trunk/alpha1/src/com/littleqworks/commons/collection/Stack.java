package com.littleqworks.commons.collection;

/**
 * 泛型堆栈接口
 * @author 谭孟泷<TanMenglong@gmail.com>
 *
 * @param <E> 堆栈存储的元素类型
 */
public  interface Stack<E> {	
	/**
	 * 检测堆栈是否为空
	 * @return 如果堆栈为空则返回true，否则返回false
	 */
	public boolean isEmpty();
	
	/**
	 * 弹出栈顶元素
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E pop() throws StackEmptyException;
	
	/**
	 * 将一个元素压入堆栈
	 * @param element 元素
	 */
	public void push(E element);
	
	/**
	 * 获取栈顶元素，但不改变堆栈的结构
	 * @return E 栈顶元素
	 * @throws StackEmptyException 当栈空时
	 */
	public E getTopElement() throws StackEmptyException;
}
