
/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
**/

public class SLLQueue<E> implements Queue<E> {
       // inner class for nodes in singly linked lists
	
	private static class SNode<E>{
		private E element; 
		private SNode<E> next; 
		
		
		public SNode(E data)  { 
			this.element = data; 
			next = null; 
		}
		public E getElement() {
			return element;
		}
		public void setElement(E data) {
			this.element = data;
		}
		public SNode<E> getNext() {
			return next;
		}
		public void setNext(SNode<E> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}
	}
	
	    
    private SNode<E> first, last;   // references to first and last node
    private int size; 
    
    public SLLQueue() {           // initializes instance as empty queue
        first = last = null; 
        size = 0; 
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
    	
        return size == 0;
    }
    public E first() {
        if (isEmpty()) return null;
        return first.getElement(); 
    }
    public E dequeue() {
        if (isEmpty())
        	{
        	return null;        
        	}
        SNode<E> ntr = first;
       
        E etr =  ntr.getElement();
        first = first.getNext();
        size--;
        
        ntr.clean();
       
        return etr;
         
    }
    public void enqueue(E e) {
    	SNode<E> nuevo = new SNode<E>(e);
        if (size == 0) {
            first =  nuevo;
        }
        else { 
           last.setNext(nuevo);
           last=nuevo;
        }
        size++; 
    }
}
