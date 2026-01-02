package dataStructuresAndAlgo.LinearDataStructures;

class QueueArray<T>{
	protected int maxSize;
	protected int first;
	protected int last;
	protected int size;
	protected Queue<T>[] queueArray;
	@SuppressWarnings("unchecked")
	public QueueArray(int size) {
		this.maxSize = size;
		this.queueArray=new Queue[this.maxSize];
		this.first = 0;//it is initiated with zero by the JVM ,but for clarity we explicitly initiate it with 0
		this.last = -1;
	    //this.size was not be explicitly initiated intentionally
	}
	public boolean isFull() 
	{ return (this.maxSize==this.size); }
	
	public boolean isEmpty()
	{ return (this.size==0); }
	
	public void insert(T data) {
		Queue<T> object = new Queue<>(data);
		
		if(this.last == this.maxSize-1  && this.first != 0) {
			this.last=-1;
		    this.queueArray[++this.last] = object;//increment after use(post-increment)
		    this.size++;
		    
		}else if(this.first-1 == this.last && this.last!=-1) {//Checking if our wrapped around queue is full or not
			System.out.println("Cannot insert \u001B[3m"+data+" \u001B[4m\u001B[31mThe Queue is full\u001B[0m");
			return;
			
		}else if(!isFull()) {//Checking if our normal queue is full or not
		    this.queueArray[++this.last] = object;//increment before use(pre-increment)
		    this.size++;
		}else {//If full print
			System.out.println("Cannot insert \u001B[3m"+data+" \u001B[4m\u001B[31mThe Queue is full\u001B[0m");
		}
	}
	
	public void show(int index) {
		if(index == this.first) 
			System.out.print("|\u001B[32m"+this.queueArray[index].data+"\u001B[0m|-");
		else if(index == this.last)
			System.out.print("|\u001B[31m"+this.queueArray[index].data+"\u001B[0m|");
		else
			System.out.print("|\u001B[33m"+this.queueArray[index].data+"\u001B[0m|-");

	}
	
	public void display() {
		int index = this.first;//0
		if(this.last>this.first ) {
			while(index <= this.last) {
				show(index);
				index++;		
			}
		}else if(this.first>this.last) {
			
			while(true) {
				show(index);
				index++;
				if(index== this.maxSize)
					index=0;
				else if(index-1 == this.last)
					break;
			}

		}
		System.out.println();
	}
	
	public T remove() {
		if(this.first != this.maxSize-1 ) {
			this.size--;
		    return this.queueArray[this.first++].data ;
		    
		}
		this.size--;
		this.first=0;
		return this.queueArray[this.first++].data ;
	}
	public int size() {
		return this.size;
	}
}