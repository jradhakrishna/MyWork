public class Distnct {
   public static void main (String[] args) {
      int arr[] = {1, 5, 9, 1, 4, 9, 6, 5, 9, 7};
      int n = arr.length;
      int i, j;
      System.out.print("The array is: ");
      for (i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
      System.out.print("\nThe distinct elements of above array are: ");
      for (i = 0; i < n; i++) {
         for (j = 0; j < i; j++)
         if (arr[i] == arr[j])
            break;
         if (i == j)
         System.out.print( arr[i] + " ");
      }
   }
}


/*

The array is: 1 5 9 1 4 9 6 5 9 7
The distinct elements of above array are: 1 5 9 4 6 7
Now let us understand the above program.

First the original array is displayed. This array may contain duplicate elements. The code snippet that demonstrates this is given as follows -

System.out.print("The array is: ");
for (i = 0; i < n; ++i)
System.out.print(arr[i] + " ");
Now, a nested for loop is used to make sure only distinct elements of the array are displayed. The outer loop runs from 0 to n and the inner loop makes sure that an element is printed only if has not occured before. The code snippet that demonstrates this is given as follows -

System.out.print("\nThe distinct elements of above array are: ");
for (i = 0; i < n; i++) {
   for (j = 0; j < i; j++)
   if (arr[i] == arr[j])
   break;
   if (i == j)
   System.out.print( arr[i] + " ");
}
*/