package postfix;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Stack class for implementation in a PostFix evaluator.
 * Based of the implementation of a Stack found in 
 * "Data Structures Outside In with Java" by Sesh Venguopal
 * @author Sesh Venguopal, slight alterations by Connor Hollis
 * 
 * Differences: Implementation uses ArrayList, not LinkedList. 
 * 				Eliminated next() method, created peek().
 *
 * @param <T> Is capable of holding whatever type is necessary.
 */
public class Stack<T>  {
	
	ArrayList<T> list;
	int cursor;
	
	public Stack(){
		list = new ArrayList<T>();
		cursor = -1;
	}
	
	public void push(T item){
		if(list.size() == 0){
			list.add(item);
		}
		else{
			list.add(item);
		}
	}
	
	public T pop(){
		if(list.isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			return list.remove(list.size()-1);
		}
	}
	
	public int size(){ return list.size();}
	public boolean isEmpty(){ return list.isEmpty();}
	public void clear(){ list.clear();}
	
	public T first(){
		if(list.size()==0){
			return null;
		}
		cursor = 0;
		return list.get(cursor);
	}
	
	public T peek(){
		T result = this.pop();
		this.push(result);
		return result;
	}
}
