package dataStructuresAndAlgo.LinearDataStructures;

public class  circularLinkedList<T> extends singleLinkedStructures<T> {
	
	public SingleLinked<T> first,last;
	private int size;
	
	@Override
	public void put(T data){
		SingleLinked <T> node = new SingleLinked<>(data);
    	if(this.first == null) {
    	     this.first = node;
    	     this.last = node;
    	     this.last.next = this.first;
    	     this.size++;
    	}else {
    		SingleLinked <T> current = this.first;
    		while(!current.next.equals(this.first))
    			 current=current.next;
    		this.last = node;
    		current.next = this.last;
    		this.last.next  = this.first;
    		this.size++;

    	}
    }
	
    @Override
    public void reverse(){
	   SingleLinkedList<T> head = new SingleLinkedList<>();
	   this.last.next = null;//Breaking the link(between 'last' and 'first' nodes), so that it can behave as a 'SingleLinkedList'
	   head.first = this.first;
	   head.reverse();
	   this.first = head.first;
	   this.last = head.last;//{...last--->null} still
	   this.last.next=this.first;//Re-linking('last' and 'first' nodes) ,so that it can behave as a 'circularLinkedList'  
	}
   
    @Override
    public void display() {
	   SingleLinkedList<T> head = new SingleLinkedList<>();
	   this.last.next = null;//Breaking the link{...last--->first... => ...last--->null}, so that it can behave as a 'SingleLinkedList'
	   head.first = this.first;
	   head.display();
	   this.last.next = this.first;//Re-linking{...last--->null => ...last--->first...},so that it can behave as a 'circularLinkedList'  
    }
    
    @Override
	public void insert(T data,int position) {
    	SingleLinked<T> head = this.first,node = new SingleLinked<>(data);
    	if(position > size()+1){
    		System.out.println("\nInsertion at position - "+position+" Failed(positionNotFound!)."); //$NON-NLS-1$ //$NON-NLS-2$
    		return;
    	}
    	if(position == 1){
    		
    		this.last.next = node;
    		node.next = head;
	    	this.first = node;
	    	this.size++;
	    	    
       	}else if(position == size()+1){
       		
       		this.last.next = node ;
       		node.next = this.first;
       		this.last = node;
       		this.size++;
       			
       	}else{
       		
       	    int count = 1;
    		while(count < position-1) {
    			head=head.next;
    			count++;
    	    }
    			SingleLinked<T> nextNode = head.next;
    			head.next = node;
    			node.next = nextNode;
    			this.size++;
    		}
    }
    
    @Override
	public int size(){
   		return this.size;
    }
    
    @Override
	public T delete(int position){
    	SingleLinked<T> head = this.first,node;
    	if(position > size() ){
    		throw new IllegalArgumentException("\nDeletion at position - "+position+" Failed(positionNotFound!)."); //$NON-NLS-1$ //$NON-NLS-2$
    		
    	}if(position == 1){
    		node = first;
    		this.first = this.first.next;
    		this.last.next = this.first;
    		this.size--;
    		return node.data;
    	
    	}
		int count = 1;
		while(count < position-1) {
			head=head.next;
			count++;
		}node = head.next;
		if(position == size()) {
			head.next = head.next.next;
			this.last=head;
		}else {
			head.next = head.next.next;
		}
  	this.size--;
  	return node.data;
    }
}
