package assignment2AADS.assignment2;
public class testClassEx2 {

	public static void main(String[] args) {
	
		MyItinerary mi = new MyItinerary();
		
		
		A2Direction[] array;
		array = new A2Direction[10];

		array[0] = A2Direction.LEFT;
		array[1] = A2Direction.DOWN;
		array[2] = A2Direction.RIGHT;
		array[3] = A2Direction.DOWN;
		array[4] = A2Direction.LEFT;
		array[5] = A2Direction.UP;
		array[6] = A2Direction.LEFT;
		array[7] = A2Direction.UP;
		array[8] = A2Direction.RIGHT;
		array[9] = A2Direction.UP;
		
		mi.addDirArr(array);
		//array = mi.rotateRight();
		
		//mi.addDirArr(array);
		//mi.addDir(A2Direction.DOWN);
		
		
		
		int i = 0;
		while (mi.directions[i] != null) {
			
				A2Direction input = mi.directions[i].direction;
				
				switch(input){
				case LEFT:{
					System.out.print("LEFT, ");
					break;
				}case RIGHT:{
					System.out.print("RIGHT, ");
					break;
				}case UP:{
					System.out.print("UP, ");
					break;
				}case DOWN:{
					System.out.print("DOWN, ");
					break;
				}
				}
				i++;
			
		}
		
		System.out.println("the height is :"+ mi.heightOfItinerary());
		System.out.println("the width is :" +mi.widthOfItinerary());
		int [] interSect = mi.getIntersections();
		int j = 0;
		String intersectionString = "The intersections are: ";
		while (interSect[j] != 0) {
			intersectionString += interSect[j]+", ";
			j++;
		}
		System.out.println(intersectionString);
		//System.out.println(interSect[0]);
		//System.out.println(mi.directions[5].hashString());
			
		
		
	}

}
