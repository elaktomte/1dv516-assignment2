# 1dv516-assignment2
Second assignment in the "Algorithms and Advanced Data Structure" course
Instructions provided:
Assignment 2
Sorting, Priority Queues, Hashing
 
Exercise 1
Implement a generic HashTable (MyHashTable) with operations insert(AnyType element), delete(AnyType element) and contains(AnyType element). The table must implement the quadratic probing and the internal rehash() function should be called when either the load factor is higher than a limit passed as an argument in the constructor of MyHashTable or when an insertion fails (this is, when an insertion does not find an empty cell).

Hint: Your concrete classes for AnyType should override the hashCode() and equals(Object o) methods. 

Exercise 2
Given an array of elements of class Direction (UP, DOWN, LEFT, RIGHT) that represents an itinerary (for instance, an itinerary in a map), implement a class MyItinerary with operations: widthOfItinerary(), heightOfItinerary(), rotateRight(), and getIntersections(). 

For instance, given the array [LEFT, DOWN, DOWN, RIGHT, UP, LEFT] (whose visual representation is in the next figure),

Itinerary example

the

widthOfItinearry() should return 1, 
heightOfItinerary() should return 2,
rotateRight() should return [UP, LEFT, LEFT, DOWN, RIGHT, UP] (grahical representation is in the next figure)
Previous itinerary rotated to the right

getIntersections() should return [5] (because the LEFT in array[5] is the only element that reaches a point that had been already visited, by the DOWN in array[1]).  Operation getIntersections() returns an array with all the positions of the itinerary array that reach a location that has been previously visited. 
Example 2: for the array [LEFT, DOWN, RIGHT, DOWN, LEFT, UP, LEFT, UP, RIGHT, UP] (see graphical representation in next figure), the width is 2, the height is 3, and the intersection points are [5,8], which correspond to the positions in the array of the first UP and last RIGHT. 
Itinerary example 2

Implement all operations as fast as you can, and attach a pdf document where you explain your solution and you analyze the time complexity of getIntersections() operation. The grade of the exercise will consider the quality of the implementation and the correctness of the analysis. Hint: you can use the Hash Table implemented in the previous exercise. 

Exercise 3
Given 2 arrays of integer positive values (array1 and array2) implement a Class MyMeasure that includes:

A method called isSameCollection(int[] array1, int[] array2) that returns true if array1 contains the same values as array2. For instance: isSameCollection([10,1,7,10], [1, 10, 7,10]) must return true, isSameCollection([10,1,7,9], [1, 10, 7,10]) must return false, and isSameCollection([1,7,10], [1, 10, 7, 7]) must return false. 
A method called minDifferences(int[] array1, int[] array2) that receives two arrays of the same size and 
Computes the differences between pairs of elements <x1,x2> where x1 belongs to array1 and x2 belongs to array2. The pairs are generated in the following way: 1) the minimum element of array1 is paired with the minimum element of array2; 2) the minimum element of array1 without considering the already chosen in step 1 is paired with the minimum element of array2 without considering already chosen in step 1; ... N) the maximum element of array 1 is paired with the maximum element in array2. 
Returns the squared sum of the differences: ∑(x2-x1)2
Example: array1=[2,5,3,9] and array2=[15,12,1,3]. 
Pairs are: <2,1>, <3,3>, <5,12>, <9,15> and the method returns: 86, which comes from (1-2)2+(3-3)+(12-5)2+(15-9)2= 86
A method called getPercentileRange(int[] arr, int lower, int upper) that receives an array and two percentile values (2 numbers between 0 and 100) called lower and upper, with lower ≤ upper. The method returns an array with the values in arr that are among the upper% lowest but not lower% lowest.
Example: Given the array arr=[20, 16, 2, 4, 10, 6, 12, 8, 14, 18].
getPercentileRange(arr, 0, 10)= [2]
getPercentileRange(arr, 10, 20)= [4]
getPercentileRange(arr, 10, 50)= [4,6,8,10] // It does not need to be ordered, [6, 10, 8, 4] would be also valid 
getPercentileRange(arr, 60, 70)= [14] 
getPercentileRange(arr, 0, 100)= [2,4,6,8,10,12,14,16,18,20] // any permutation of the values in arr would be valid
Implement all operations as fast as you can, and attach a pdf document where you explain your solution and you analyze their time complexity. The grade of the exercise will consider the quality of the implementation and the correctness of the analysis. Hint: you can use (with some modifications) the Hash Table implemented in exercise 1.

Important: You must implement the ADTs from scratch without reusing data structures from libraries (none among java sets, multisets, hash, provided sorting methods, etc.). This applies to all exercises in this assignment.
