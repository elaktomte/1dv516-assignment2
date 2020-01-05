package assignment2AADS.assignment2;

public class MyItinerary implements A2Itinerary<A2Direction> {
	public int currentX = 0;
	public int currentY = 0;
	public int minX = 0;
	public int maxX = 0;
	public int minY = 0;
	public int maxY = 0;
	public DirectionNode[] directions = new DirectionNode[25];
	public int currentIndex = 0;
	public MyHashTable hash = new MyHashTable(25, 0.5);
	public int[] intersections = new int[25];
	public int intersectionCounter = 0;

	
	public MyItinerary() {
		hash.insert("["+0+", "+0+"]"); // inserting to make sure we capture the intersection with Origo.
	}


	@Override
	public A2Direction[] rotateRight() {
		A2Direction[] a2Directions = new A2Direction[directions.length];
		for(int i = 0; i < directions.length; ++i){
			if(directions[i] != null){
				A2Direction input = directions[i].direction;

				switch(input){
				case LEFT:{
					a2Directions[i] = A2Direction.UP;
					break;
				}case RIGHT:{
					a2Directions[i] = A2Direction.DOWN;
					break;

				}case UP:{
					a2Directions[i] = A2Direction.RIGHT;
					break;

				}case DOWN:{
					a2Directions[i] = A2Direction.LEFT;
					break;

				}
				}
			}

		}
		return a2Directions;
	}

	@Override
	public int widthOfItinerary() {
		// TODO Auto-generated method stub
		return (-minX) + maxX;
	}

	@Override
	public int heightOfItinerary() {
		// TODO Auto-generated method stub
		return (-minY) + maxY;
	}

	@Override
	public int[] getIntersections() {
		
		return intersections.clone();
	}

	public void addDirArr(A2Direction[] a2directions){			// method for adding entire arrays of directions.


		for(int i = 0; i < a2directions.length; ++i){
			if (a2directions[i] != null) {
				A2Direction input = a2directions[i];

				switch(input) {
				case LEFT: {
					DirectionNode node = new DirectionNode(input ,currentX, currentY); 
					currentX--;
					node.endX = currentX;
					node.endY = currentY;
					directions[currentIndex++] = node;
					
					if (hash.contains(node.hashString())) {
						intersections[intersectionCounter] = currentIndex-1;
						intersectionCounter++;
					}
					else {
						hash.insert(node.hashString());
					}
					if (currentX < minX) {
						minX = currentX;
					}
				}
				break;
				case RIGHT: {
					DirectionNode node = new DirectionNode(input ,currentX, currentY); 
					
					currentX++;
					node.endX = currentX;
					node.endY = currentY;
					directions[currentIndex++] = node;
					// if hashtable.contains(x,y){

					if (hash.contains(node.hashString())) {
						intersections[intersectionCounter] = currentIndex-1;
						intersectionCounter++;
					}
					else {
						hash.insert(node.hashString());
					}
					
					if (currentX > maxX) {
						maxX = currentX;
					}
				}
				break;
				case UP:	{
					DirectionNode node = new DirectionNode(input ,currentX, currentY); 
					currentY++;
					node.endX = currentX;
					node.endY = currentY;
					directions[currentIndex++] = node;
					// if hashtable.contains(x,y){

					if (hash.contains(node.hashString())) {
						intersections[intersectionCounter] = currentIndex-1;
						intersectionCounter++;
					}
					else {
						hash.insert(node.hashString());
					}
					
					
					if (currentY > maxY) {
						maxY = currentY;
					}
				}
				break;
				case DOWN:	{
					DirectionNode node = new DirectionNode(input ,currentX, currentY); 
					currentY--;
					node.endX = currentX;
					node.endY = currentY;
					directions[currentIndex++] = node;
					
					if (hash.contains(node.hashString())) {
						intersections[intersectionCounter] = currentIndex-1;
						intersectionCounter++;
					}
					else {
						hash.insert(node.hashString());
					}
					
					if (currentY < minY) {
						minY = currentY;
					}
				}
				break;
				}
			}

		}
	}

	public void addDir(A2Direction value) {		// adding a single direction
		A2Direction input = value;

		switch(input) {
		case LEFT: {
			DirectionNode node = new DirectionNode(input ,currentX, currentY); 
			currentX--;
			node.endX = currentX;
			node.endY = currentY;
			directions[currentIndex++] = node;
			
			if (hash.contains(node.hashString())) {
				intersections[intersectionCounter] = currentIndex-1;
				intersectionCounter++;
			}
			else {
				hash.insert(node.hashString());
			}
			if (currentX < minX) {
				minX = currentX;
			}

		}
		break;
		case RIGHT: {
			DirectionNode node = new DirectionNode(input ,currentX, currentY); 
			currentX++;
			node.endX = currentX;
			node.endY = currentY;
			directions[currentIndex++] = node;
			
			if (hash.contains(node.hashString())) {
				intersections[intersectionCounter] = currentIndex-1;
				intersectionCounter++;
			}
			else {
				hash.insert(node.hashString());
			}
			if (currentX < minX) {
				minX = currentX;
			}
		}
		break;
		case UP:	{
			DirectionNode node = new DirectionNode(input ,currentX, currentY); 
			currentY++;
			node.endX = currentX;
			node.endY = currentY;
			directions[currentIndex++] = node;
			
			if (hash.contains(node.hashString())) {
				intersections[intersectionCounter] = currentIndex-1;
				intersectionCounter++;
			}
			else {
				hash.insert(node.hashString());
			}
			if (currentX < minX) {
				minX = currentX;
			}
		}
		break;
		case DOWN:	{
			DirectionNode node = new DirectionNode(input ,currentX, currentY); 
			currentY--;
			node.endX = currentX;
			node.endY = currentY;
			directions[currentIndex++] = node;
			
			if (hash.contains(node.hashString())) {
				intersections[intersectionCounter] = currentIndex-1;
				intersectionCounter++;
			}
			else {
				hash.insert(node.hashString());
			}
			if (currentX < minX) {
				minX = currentX;
			}
		}
		break;
		}
	}

	//Add your code here

}
class DirectionNode {
	A2Direction direction;
	public int startX;
	public int startY;
	public int endX;
	public int endY;


	public DirectionNode(A2Direction dir, int x, int y) {
		this.direction = dir;
		startX = x;
		startY = y;
	}
	public String hashString() {
		return "["+endX+", "+endY+"]";
	}

}
