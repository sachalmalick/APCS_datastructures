/*
  Team: Over the Moon -- Sachal Malick, Kyle Moon
  APCS2 PD10
  HW24 -- Schemin
  2016-02-2016
*/

/*****************************************************
 * class LLStack
 * Implements ADT stack as specified in local Stack.java
 * Generically typed
 * Uses a LinkedList as underlying container
 *****************************************************/

import java.util.LinkedList;


public class LLStack<T> implements Stack<T> {

    LinkedList <T> _stack;
    private int _stackSize;


    public LLStack() {
        _stack = new LinkedList<T>();
        _stackSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return _stackSize == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return _stack.get(_stackSize-1);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T temp = peek();
        _stack.remove(_stackSize-1);
        _stackSize--;
        return temp;
    }

    @Override
    public void push(T x) {
        _stack.add(x);
        _stackSize++;
    }

    @Override
    public int size() {
        return _stackSize;
    }

    //main method for testing
    public static void main( String[] args ) {

        Stack<String> tastyStack = new LLStack<String>();

        tastyStack.push("aoo");
        tastyStack.push("coo");
        tastyStack.push("doo");
        tastyStack.push("eoo");
        tastyStack.push("foo");
        tastyStack.push("goo");
        tastyStack.push("hoo");
        tastyStack.push("ioo");
        tastyStack.push("joo");
        tastyStack.push("coocoo");
        tastyStack.push("cachoo");

        //cachoo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //coocoo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //joo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //ioo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //hoo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //goo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //foo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //eoo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //doo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //coo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //boo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        //aoo
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );

        //stack empty by now; SOP(null)
        System.out.println( "peek: " + tastyStack.peek() );
        System.out.println( "pop: " + tastyStack.pop() );
        System.out.println( tastyStack.pop() );
    }//end main()



}//end class LLStack
