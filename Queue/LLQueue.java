/*
  Team: Over the Moon -- Sachal Malick, Kyle Moon
  APCS2 PD10
  HW25 -- Brits Do Not Wait in Line
  2016-04-05
*/

/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.util.RuntimException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
    {
        _front = null;
        _end = null;
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal )
    {
        LLNode temp = new LLNode<T>(enQVal, null);
        if (this.isEmpty())
        {
            _front = temp;
            _end = temp;
        }
        else
        {
            _end.setNext(temp);
            _end = temp;
        }
    }//O(?)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue()
    {
        if (this.isEmpty())
        {
            System.out.println("***Cannot dequeue from empty queue***");
            return null;
        }
        T retV = _front.getValue();
        _front = _front.getNext();
        return retV;
    }//O(?)


    // means of peeking at thing next in line for removal
    public T peekFront()
    {
        T retV = _front.getValue();
        return retV;
    }//O(?)


    public boolean isEmpty()
    {
        return _front == null;
    }//O(?)


    // print each node, separated by spaces
    public String toString()
    {
        String retS = "";
        LLNode<T> temp = _front;
        while (temp != null)
        {
            retS += temp + " ";
            temp = temp.getNext();
        }
        return retS;
    }//O(?)

    public static void main( String[] args )
    {
       Queue<String> LLQueuelJ = new LLQueue<String>();
       System.out.println("\nnow enqueuing thrice...");
       LLQueuelJ.enqueue("James");
       LLQueuelJ.enqueue("Todd");
       LLQueuelJ.enqueue("Smith");

       System.out.println("\nnow testing toString()...");
	   System.out.println( LLQueuelJ ); //for testing toString()...

	   System.out.println("\nnow dequeuing thrice...");
	   System.out.println( LLQueuelJ.dequeue() );
	   System.out.println( LLQueuelJ.dequeue() );
	   System.out.println( LLQueuelJ.dequeue() );

	   System.out.println("\nDequeuing from empty queue should yield error...");
	   System.out.println( LLQueuelJ.dequeue() );
    }//end main
    
}//end class LLQueue
