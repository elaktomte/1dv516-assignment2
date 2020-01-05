package assignment2AADS.assignment2;
public class MyHashTable<T> implements A2HashTable<T>{
	double load;
	int size = 0;
	double loadLimit;
	HashNode[] array;
	
	
	public MyHashTable(int length, double loadLimit) {
		this.loadLimit = loadLimit;
		this.array = new HashNode[length];
		
	}

	@Override
	public void insert(T element) {
		if(isOverloaded()) {
			rehash();
		}
		if (!contains(element)){

			int pos = getHash(element);
			int ost = insertProbe(0, pos);
			HashNode<T> node = new HashNode<T>(element);
			array[ost] = node;
			++size;
			if(size == array.length){
				rehash();
			}
			
		}
		
	}

	public boolean isOverloaded() {
		this.load = ((double)size/(double) array.length);
		return load >= loadLimit;
	}
	@Override
	public void delete(T element) {
		deleteProbe(0, getHash(element), element );
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return containsProbe(0, getHash(element), element);
	}
	public void rehash() {
		HashNode[] temp = array;
		size = 0;
		array = new HashNode[array.length*2+1];
		
		for (int i = 0; i<temp.length; i++) {
			if (temp[i] != null && temp[i].isActive == true) {
				insert((T) temp[i].element);
			}
		}
		this.load = size / array.length;
		
	}
	
	public int insertProbe(int attempts, double hashCode ){
		int position = 0;
		if (attempts > 10) {
			System.out.println("DOing rehash");
			rehash();
		}
		 if (array[(int) hashCode] != null) {
			position = insertProbe(attempts+1, ((int)Math.pow(hashCode,2)+1)%array.length);
		}
		else if (array[(int) hashCode] == null ) {
			position = (int) hashCode;
		}
			return position;
	}
	
	public boolean containsProbe(int attempts, double hashCode , T element){
		boolean answer = false;
		if (attempts > 10) {
			System.out.println("Element was not found after 10 attempts");
			answer = false;
		}
		else if (array[(int) hashCode] != null) {
			if (array[(int) hashCode].element.equals(element) && array[(int) hashCode].isActive == true) {
				answer = true;
			}
			else {
			answer = containsProbe(attempts+1, (Math.pow(hashCode,2)+1)%array.length, element);
			}
		}
		else if (array[(int) hashCode] == null ) {
			answer = false;
		}
		
		return answer; // unreachable
	}
	
	public void deleteProbe(int attempts, double hashCode , T element){
		if (attempts > 10) {
			System.out.println("Element not found after 10 attempts");
		}
		else if (array[(int) hashCode] != null) {
			if (array[(int) hashCode].element.equals(element) && array[(int) hashCode].isActive == true ) {
				array[(int) hashCode].isActive = false;
				System.out.println("element deleted");
				
			}
			else {
			containsProbe(attempts+1, (Math.pow(hashCode,2)+1)%array.length, element);
			}
		}
		else if (array[(int) hashCode] == null ) {
			System.out.println("Element not found");
		}
	}
	
	public void printTable() {
		for (int i = 0; i< array.length; i++) {
			if (array[i] == null) {
				System.out.println("["+i+"] = null");
			}
			else if (array[i].isActive == false){
				System.out.println("["+i+"] = DELETED");
			}
			else {
			System.out.println("["+i+"] = "+array[i].element.toString());
			}
		}
	}
	
	public int getHash(T element){
		int hc = element.hashCode();
		if (hc < 0){
			hc = -hc;
		}
		return (hc % array.length);
	}
	
	
	

}
class HashNode <T>{
	T element;
	boolean isActive = true;
	public HashNode (T element) {
		this.element = element;
	}
}
