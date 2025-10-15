public class LL{

	public static void main(String[] args){
	
		MyLinkedList list = new MyLinkedList();

		list.insertFirst(3);
		list.insertFirst(7);
		list.insertFirst(9);
		list.insertFirst(43);
		list.insertFirst(13);


		list.display();

		System.out.println(list.deleteAt(1)+" is the deleted element");
		
		list.display();

		System.out.println(list.find(23));
		
		System.out.println(list.find(3));

		
		


	} 


}