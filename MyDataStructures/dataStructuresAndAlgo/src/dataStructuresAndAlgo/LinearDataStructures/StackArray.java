package dataStructuresAndAlgo.LinearDataStructures;

class StackArray<T>{
	protected int size;
	protected int top;
	@SuppressWarnings("rawtypes")
	protected Stack [] stackArray;
	public StackArray(int size) {
		this.size = size;
		this.stackArray = new Stack[this.size];
		this.top = -1;
	}
	public void push(T data) {
		if(!isFull()) {

		     this.stackArray[++this.top]=new Stack<>(data);
		}else {
			throw new IllegalArgumentException("\u001B[4m\u001B[36mStackOverFlow!\u001B[0m,Cannot insert \u001B[3m" +data+" \u001B[4m\u001B[31mThe Stack is full\u001B[0m");
		}
	}

	@SuppressWarnings("unchecked")
	public T pop()
	{ return (T) this.stackArray[this.top--].data; }

	public void display() {
		int index = this.top;
		if(!isEmpty()) {
		    while(index>=0) {

		    	if(index == this.top) {
					System.out.println("\u001B[42m  \u001B[37m"+this.stackArray[index].data+"  \u001B[0m <--Last In");
				} else if(index == 0) {
					System.out.println("\u001B[41m  "+this.stackArray[index].data+"  \u001B[0m <--First In");
				} else {
					System.out.println("\u001B[43m  "+this.stackArray[index].data+"  \u001B[0m ");
				}
		    	System.out.println("\u001B[9m     \u001B[0m");
		    	index--;
		    }
		}else {
			throw new IllegalArgumentException("StackDownFlow!");
		   
		}


	}
	public boolean find(T data){
		int index = this.top;
		while(index>=0) {
			if(this.stackArray[index--].data == data) {
				return true;
			}
		}
     return false;

	}

	@SuppressWarnings("unchecked")
	public T peek()
	{return (T) this.stackArray[this.top].data;}

	public boolean isEmpty()  // true if stack is empty
    { return (this.top == -1); }

	public boolean isFull() {
		if(this.top==this.size-1) {
			return true;
		}
		return false;
	}

}