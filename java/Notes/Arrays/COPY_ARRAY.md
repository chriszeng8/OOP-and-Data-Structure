

####COPYING ARRAY
*By Chris Z. Zeng Feb 10, 2015*\

Lesson learnt:\
Assigning an object to another object is NOT equivalent as making a copy of the object.

If both e1 and e2 are objects, ```e2=e1``` may give you the illustration that e2 is a copy of e1 ... initially. but as you change the attributes of e1, you will realised that e2 is changed as well. Why is that the case?\
ACTUALLY, when you do ```e2 = e1``` you're copying object ***references*** ([read more](http://en.wikipedia.org/wiki/Reference_(computer_science)))- you're not making a copy of the object - and so the variables e1 and e2 will both point to the same object.

Note that arrays are OBJECTS in java\
The proper way to copy an array is to loop through each row, and copy each individual element within the row. (assigning primitive type to primitive type will make a copy the result)

```
public class Rec3 {
     public static void main(String[] args) {

		int[][] matrix = {
				{2, 4, 6, 5},
				{4, 7, 2, 0},
				{1, 3, 9, 1},
				{6, 0, 3, 1}
		};  

     public static int[][] DeplicateMatrix(int[][] matrix) {
		int[][] DupicateMatrix = new int[4][4];

		/* make duplicate of the original matrix*/
		for (int row =0; row< matrix.length;row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				DupicateMatrix [row][col]=matrix[row][col];   
			}
		}
     return DuplicateMatrix;
     }
}
```


#####Question: 
How do we make copy of a complete object?
```
class DummyBean {
  private String dummy;

  public DummyBean(DummyBean another) {
    this.dummy = another.dummy; // you can access  
  }
}
```
[Sources](http://stackoverflow.com/questions/869033/how-do-i-copy-an-object-in-java)

####References
Pointers and References are variables that contain the "address" in memory of a piece of data, rather than the actual data.\
[Pointers and References](http://www.cs.utah.edu/~germain/PPS/Topics/pointers_and_references.html)\
[Pointers vs References](http://www.embedded.com/electronics-blogs/programming-pointers/4023307/References-vs-Pointers)



