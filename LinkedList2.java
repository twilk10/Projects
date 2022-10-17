package lab7;


//Original code by Tyler Wilkerson
//This code makes a linked list using nodes only and not making another object for the list
public class LinkedList2 {
	//head is the start of the list
	static Node head;
	static Node end;
	
	public static void main(String [] args) {
//      50, 11, 33, 21, 40, 71
        //Test case for an empty linked list
  //      fromTheEnd( 5);
		add(50);
		add(11);
		add(33);
		add(21);
		add(40);
		add(71);

		
		
//		Node tail=head;
////		System.out.println(head.data);
//		while(tail.next!=null) {
//			System.out.print(tail.data);
//			tail=tail.next;
//		}
		//THis prints the first list
		printList(head);
		
		System.out.println();
		//This is the method that deletes the number that is n numbers away from the end
	
        //test cases
        fromTheEnd( 2);

//       fromTheEnd( 5);
//        fromTheEnd( 6);
//        fromTheEnd( 4);
		//Case for number out of range
//      fromTheEnd( 7);
//        fromTheEnd( -5);
//        fromTheEnd( 0);
	}
	//This prints the linked list
	public static void printList(Node begin) {
		Node tail=begin;
//		System.out.println(head.data);
		//as long as tail is not null the node will print 
		while(tail!=null) {
			System.out.print(tail.data+ " ");
			tail=tail.next;
		}
	}
	//This is the class to make a Node which can hold data and can point to the next node
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			Node next = null;
		}
	}
	//This adds parts elements to the array and since there is only one list then head can just ber
	//in the code and we do not have to define which head
	public static void add(int data) {
    	
    	if(head==null) {
    		head= new Node(data);
    		end=head;
    	}else {
    		
    		end.next = new Node(data);
    		end=end.next;
    	}
    	
    	
    }
	
	

	
	//Since the node is already defined we do not need to pass the head of the list 
	//but if there were multiple linked lists then we would have to change it
	public static Node fromTheEnd( int n) {
	    //This says if the case that the number from the end of the list does not exist it can not do the operation
			if(n<=0) {
	    		System.out.println("number out of range");
	    		return null;
	    	}
			//This makes the dummy node which points to the head of the list in which the parameter asks for
	    	Node dummy = new Node(5);
	    	dummy.next=head;
	    	//these declare the fast and slow pointers 
	    	Node slow = dummy;
	    	Node fast = head;
	    	if(fast==null) {
	    		System.out.println("There is nothing in this linked list");
	    		return head;
	    	}
	    	//This puts the fast pointer n from the head so that when it reaches null the element before the element to be deleted will be deleted
	    	for(int i =0; i<n;i++) {
	 	    		if(fast==null) {
	    			System.out.println("Number out of range");
	    			return head;
	    		}   		
	    		fast=fast.next;

	    	}
	    	//if next already equals null then it wants you to delete the first element so head now becomes the second element
	    	if(fast==null) {
	    		head=head.next;
	    		printList(head);
	    		return head;
	    	}
	    	//if the fast pointer does not equal null then both pointers move one over
	    	while(fast!=null) {
	    		slow=slow.next;
	    		fast = fast.next;
	    	}
	    	//These delete the node that needs to be deleted
	    	Node del = slow.next; 
	    	slow.next = del.next;
	    	printList(head);
	    	return head;
	    }
	

}
