package dataStructuresAndAlgo.LinearDataStructures;
/*
class doubleLinkedNode<T>{
    private SingleLinkedList<T> fstNext;
    private SingleLinkedList<T> scdNext;
	private T data;
    public doubleLinkedNode(T data){
        this.data = data;
    }
    public doubleLinkedNode(){
    }
	public SingleLinkedList<T> getFstNext() {
		return fstNext;
	}
	public void setFstNext(SingleLinkedList<T> fstNext) {
		this.fstNext = fstNext;
	}
	public SingleLinkedList<T> getScdNext() throws NullPointerException{
		return scdNext;
	}
	public void setScdNext(SingleLinkedList<T> scdNext)throws NullPointerException {
		this.scdNext = scdNext;
	}
	
	public void display(){
		SingleLinkedList<T> fstBranchNode = this.fstNext;
		SingleLinkedList<T> scdBranchNode = this.scdNext;
		
		int n = scdBranchNode.size()+fstBranchNode.size(),i,j=n,k=0;
		while(j>0 && scdBranchNode!= null && fstBranchNode!= null  ) {
			
			for(i = 0;i<j;i++)
				System.out.print("  ");	
			if(j==n) {
				System.out.println(""+this.data+" -Root");
			}else {
				System.out.print(fstBranchNode.data);
				fstBranchNode = fstBranchNode.next;
				
				for(k=0;k<n-j;k++)
					System.out.print("    ");
				
				System.out.print(scdBranchNode.data);
				scdBranchNode = scdBranchNode.next;
				System.out.println(" -nodes");
			}
			if(scdBranchNode==null || fstBranchNode==null ) {
				for(i = 0;i<j;i++)
					System.out.print("  ");
				System.out.print("null");
				for(k=0;k<n-j;k++)
					System.out.print("    ");
				System.out.println("null");
			}
			j--;
		}
		
	}
	
}

public class doubleLinkedNodeMain {
    

	@SuppressWarnings("unused")
	public static void main(String[] args) {
            doubleLinkedNode<Integer> head = new doubleLinkedNode<>(0),n1 = new doubleLinkedNode<>(0),n2 = new doubleLinkedNode<>(9),n3 = new doubleLinkedNode<>(10);
            SingleLinkedList<Integer> fstnode2 = new SingleLinkedList<>(),fstnode3 = new SingleLinkedList<>(),fstnode4 = new SingleLinkedList<>(),
            scdnode2 = new SingleLinkedList<>(),scdnode3 = new SingleLinkedList<>(),scdnode4 = new SingleLinkedList<>();
            doubleLinkedNode<String> head2 = new doubleLinkedNode<>("Nobesuthu");
            singleLinkedList<String> node1 = new singleLinkedList<>("Thoyani"),unknown =new singleLinkedList<>("?"),node2 = new singleLinkedList<>("Lukhanyo"),node3 = new singleLinkedList<>("Onele");
            
            head.setFstNext(fstnode2);
            fstnode2.next=fstnode3;
            fstnode3.next=fstnode4;
            head.setScdNext(scdnode2);
            scdnode2.next=scdnode3;
            scdnode3.next=scdnode4;
            head.display();
           
            
            
	}
}
*/