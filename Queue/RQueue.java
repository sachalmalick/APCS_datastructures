/*****************************************************
Team Over The Moon (Sachal Malick and Kyle Moon)
APCS2 pd10
HW27 -- You Lot at Fake Terrys
2016--04--06
 ******************************************************/


public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
    	_size=0;
    	_front = _end = null;
	}//end default constructor


    public void enqueue( T enQVal ) 
    {
    	   LLNode<T> temp = new LLNode<T>(enQVal, null);
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
           _size++;
    }


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
        if (this.isEmpty())
        {
            System.out.println("***Cannot dequeue from empty queue***");
            return null;
        }
        sample();
        T retV = _front.getValue();
        _front = _front.getNext();
        _size--;
        return retV;    }//end dequeue()


    public T peekFront() 
    {
    	   T retV = _front.getValue();
           return retV;
           }

    public T get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	LLNode<T> tmp = _front; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getValue();
	return retVal;
    } 
    public int size() {return _size;}

    public T set( int index, T newVal ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode<T> tmp = _front; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	T oldVal = tmp.getValue();
	
	//modify target node's cargo
	tmp.setValue( newVal );
	
	return oldVal;
    } 


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * ...
     * 
    ******************************************/
    public void sample () 
    {
    	LLNode<T> temp = _front;
        while (temp != null)
        {
        	int n = (int)(Math.random() * _size);

        	T r = temp.getValue();
        	temp.setValue(get(n));
        	set(n,r);
            temp = temp.getNext();
        }
    }


    public boolean isEmpty() 
    {
    	return _size==0;
    } //O(?)


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
    }//end toString()



    //main method for testing
    public static void main( String[] args ) {


	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");
	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );


    }//end main

}//end class RQueue
