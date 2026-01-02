package dataStructuresAndAlgo.LinearDataStructures;

class TwoStack<T> extends StackArray<T>{//Not happy about the whole implementation,
	//Shall be improved later...
	private int top2;
	public TwoStack(int size) {
		super(size);
		this.top2 = this.size;

	}
	protected void show(int index) {
		if(index== this.top || index == this.top2) {
			System.out.println("\u001B[4m\u001B[42m  \u001B[37m"+this.stackArray[index].data+"  \u001B[0m <--Last In");
		} else if(index==0 || index == this.size-1) {
			System.out.println("\u001B[4m\u001B[41m  "+this.stackArray[index].data+"  \u001B[0m <--First In");
		} else {
			System.out.println("\u001B[4m\u001B[43m  "+this.stackArray[index].data+"  \u001B[0m ");
		}
    	System.out.println("");
	}

	@Override
	public void display() {
		int index = this.top,index2=this.top2;
		if(!isEmpty()) {
			System.out.println("\u001B[4m1st Stack!\u001B[0m\n");
			for(int i= 0;i<1;i++) {
		    while(index>=0 ) {
		    	show(index);
		    	index--;
		    }
		    System.out.println("\u001B[4m2rd Stack!\u001B[0m\n");
		    while(index2<this.size ) {
		    	show(index2);
		    	index2++;
		    }
		 }
		}else {
			throw new IllegalArgumentException("StackDownFlow!");
		    
		}
	}
	@Override
	public boolean isFull()
	{ return (this.top2-this.top == 1); }

	@Override
	public boolean isEmpty() {
		return (this.top == -1 && this.top2 == this.size-1);
	}
	
	public void push(int stackNo,T data) {
		if(!isFull()) {
			switch(stackNo) {
			    case 1:
			    	this.stackArray[++this.top]=new Stack<>(data);
			    	System.out.println("Insertion Complete");
			    	break;
			    case 2 :
			    	this.stackArray[--this.top2]=new Stack<>(data);
			    	System.out.println("Insertion Complete");
			    	break;
                default :
                	
			}
		}else {
			throw new IllegalArgumentException("\u001B[4m\u001B[36mStackOverFlow!\u001B[0m,Cannot insert \u001B[3m" +data+" \u001B[4m\u001B[31mThe Stack is full\u001B[0m");
		    	
			}
	}

	
	public T pop(int stackNo) {
		
		switch(stackNo) {
	    	case 1 :
	    		return  (T) this.stackArray[this.top--].data;
	    	case 2 :
	    		return  (T) this.stackArray[this.top2++].data;
		    default:
			    throw new IllegalArgumentException("\u001B[4m\u001BStackNumberException\u001B[0m, "+stackNo+" is an InvalidStackNumber");
		}
	}


}