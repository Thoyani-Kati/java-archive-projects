package dataStructuresAndAlgo.LinearDataStructures;

class PriorityQueue<T extends Comparable<T>> extends QueueArray<T>{//ascending-priority queue implemented as a circular queue.
  //Note 'T extends Comparable<T>' is not the same as PriorityQueue<...> extends QueueArray<T>.So don't be intimidated that there is multiple inheritance
	//The main reason for 'T extends Comparable<T>' is the need for comparing generic types,You may suggest the use of equality operands(<,>,==).The problem is
	//Java does not allow that, as some generic type may support(those that are primitive types) those operands while some may not

	public PriorityQueue(int size) {
		super(size);
	}
	
	public void insertInOrder(T data) {
		int i;
		if(this.last==-1) {
			this.queueArray[++this.last] = new Queue<T>(data);
			this.size++;
		}else {
			i=this.last;
			while(true) {
				if(i == this.first-1 && this.first != this.last) {;break;}
				if(this.queueArray[i].data.compareTo(data) > 0)
					if(i==this.maxSize-1)
					   this.queueArray[this.maxSize-i-1] = this.queueArray[i];
				   else
					   this.queueArray[i+1] = this.queueArray[i];
				else
					break;
				if(i == 0 && (this.first != this.maxSize-1 && this.first != 0))
					   i = this.maxSize;//it should be this.maxSize-1,but because of Line 124
				                        //we have to set it to maxSize as it will decremented before use.
				
			i--;
			}
			
		 this.queueArray[i+1] =  new Queue<T>(data);
		 this.last++;
		 this.size++;
		 }
		
	}
	
	@Override
	public void insert(T data) {
		
		if(this.last == this.maxSize-1  && this.first != 0) {
			this.last=-1;
			insertInOrder(data);
		    
		}else if(this.first-1 == this.last && this.last!=-1) {//Checking if our wrapped around queue is full or not
			System.out.println("Cannot insert \u001B[3m"+data+" \u001B[4m\u001B[31mThe Queue is full\u001B[0m");
			return;
			
		}else if(!isFull()) {//Checking if our  queue is full or not
			insertInOrder(data);
		}else {//If full print
			System.out.println("Cannot insert \u001B[3m"+data+" \u001B[4m\u001B[31mThe Queue is full\u001B[0m");
		}
	}

}