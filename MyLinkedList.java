public class MyLinkedList{

	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList(){
		
		this.size =0;
	}

	public void insertFirst(int val){

		Node node  = new Node(val);
		node.next = head;
		head = node;


		if(tail == null){
	
		tail = head;

		}
		
		size++;	

	}

	public void insertLast(int val){

		if(tail == null){
			insertFirst(val);
			return;
		}
		
		Node node = new Node(val);
		
		tail.next = node;
		tail = node;
		
		size++;
		
		

	}


	public void insertAt(int idx , int val){

		if(idx ==0 ) {
		
			insertFirst(val);
			return;
		
		}
		
		if(idx == size) {

			insertLast(val);
			return;

		}


		Node node  = new Node(val);
		Node curr = head ;
		
		for(int i = 1; i< idx ; i++){
		
			curr = curr.next;		
		}

		node.next = curr.next;
		curr.next = node;
		size++;

	}

	public int deleteFirst(){
		
		int val = head.val;

		head = head.next;

		return val;

	}



	public int deleteLast(){

		if(size <= 1){

		return deleteFirst();
			
		}

		Node curr = get(size-2); // it will point to the before last value
		
		tail = curr;
		int val = tail.val;
		tail.next = null;
		
		return val;


	}

	public int deleteAt(int idx){
		
		if(idx == 0){

		 	return deleteFirst();
			

		}

		if(idx == size-1){

			return deleteLast();
		}

		Node prev = get(idx-1);
	
		int val = prev.next.val;
	
		prev.next  = prev.next.next;
		return val; 

	}

	public Node find(int val){

		Node curr = head;		

		while(curr!=null){

			if(curr.val == val){

				return curr;		
	
			}
			curr = curr.next;

		}
		
		return null;





	}

	public Node get(int index){

		Node curr = head;

		for(int i=0 ; i<index ; i++){

			curr = curr.next;
	
		}
		
		return curr;
		

	}


	public void display(){

		Node curr = head;
		while(curr != null){
		
			System.out.print(curr.val + " -> ");	
			curr = curr.next;		
		}
		System.out.println(" End");

	}


	class Node{

		private int val;
		private Node next;


		public Node(int val){
		
			this.val = val;

		} 

		public Node(int val , Node next){

			this.val = val;
			this.next = null; 

		}



	}


}