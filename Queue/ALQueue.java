/*
  Team: Over the Moon -- Sachal Malick, Kyle Moon
  APCS2 PD10
  HW26 -- Nor Do Aussies
  2016-04-05
*/

/*****************************************************
 * class ALQueue
 * uses an ArrayList to implement abstract data type QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.ArrayList;


public class ALQueue<T> implements Queue<T> {

    private ArrayList<T> _queue;

    // default constructor
    public ALQueue()
	{
    	_queue = new ArrayList<T>();
	}

    // means of adding an item to collection
    public void enqueue( T x )
    {
    	_queue.add(x);
    }//O(?)


    // means of removing an item from collection
    public T dequeue()
    {
    	if (_queue.isEmpty()) {
    		System.out.println("no can do brotha");
    		return null;
    	}
    	T tmp =  _queue.get(0);
    	_queue.remove(0);
    	return tmp;
    }//O(?)


    // means of "peeking" at the front item
    public T peekFront()
    {
    	return _queue.get(0);

    }//O(?)


    // means of checking to see if collection is empty
    public boolean isEmpty()
    {
    	return _queue.size() == 0;
    }//O(?)


    public String toString()
    {
    	String rs = "";
    	for (T a : _queue) {
    		rs+=a;
    	}
    	return rs;
    }


    //main method for testing
    public static void main( String[] args ) {

	Queue<String> ALBSure = new ALQueue<String>();

	System.out.println("\nnow enqueuing thrice...");
	ALBSure.enqueue("Al");
	ALBSure.enqueue("B.");
	ALBSure.enqueue("Sure!");

	System.out.println("\nnow testing toString()...");
	System.out.println( ALBSure ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice...");
	System.out.println( ALBSure.dequeue() );
	System.out.println( ALBSure.dequeue() );
	System.out.println( ALBSure.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error...");
	System.out.println( ALBSure.dequeue() );

    }//end main


}//end class ALQueue
