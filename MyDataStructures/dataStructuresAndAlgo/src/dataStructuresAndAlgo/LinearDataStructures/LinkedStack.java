package dataStructuresAndAlgo.LinearDataStructures;

public class LinkedStack <T> extends SingleLinkedList<T> {
	
	public T pop() 
	   {  return delete(size()); }
	
	@Override
	public void display() {
		if(!isEmpty()) {
			 SingleLinked<T>current = this.first;
		    while(current != null) {
		    	if(current.equals(this.last)) {
					System.out.println("\u001B[42m  \u001B[37m"+current.data+"  \u001B[0m <--Last In");
				} else if(current.equals(this.first)) {
					System.out.println("\u001B[41m  "+current.data+"  \u001B[0m <--First In");
				} else {
					System.out.println("\u001B[43m  "+current.data+"  \u001B[0m ");
				}
		    	System.out.println("\u001B[9m     \u001B[0m");
		    	current= current.next;
		    }
		}else {
			throw new IllegalArgumentException("Cannot display a null stack!");

		}
	}
	public boolean isEmpty() {
		return this.first==null;
	}
}
