package assignment2AADS.assignment2;

public class TestClass {

	public static void main(String[] args) {
		Integer a = 10;
		MyHashTable ht = new MyHashTable(10, 0.5);
		int b = 10;
		ht.insert("ost");
		ht.insert("ost");
		ht.insert("ost");
		ht.insert("ost");
		ht.insert("ost");
		ht.insert("ost");
		ht.insert(a);
		ht.insert(10);
		ht.insert(b);
		ht.delete(b);
		ht.insert(a);
		ht.insert(10);
		ht.insert(b);
		ht.insert(11);
		System.out.println(ht.loadLimit);
		System.out.println(ht.load);
		ht.insert(12);
		ht.insert(13);
		ht.insert(new Integer(12));
		/*ht.insert(14);
		ht.insert(15);
		ht.insert(16);
		ht.insert(17);
		*/
		ht.insert(18);
		
		System.out.println(ht.contains(10));

		
		
		System.out.println(ht.size);
		System.out.println(ht.array.length);
		ht.printTable();
	}

}
