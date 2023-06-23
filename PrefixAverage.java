/**
 * @author Aduragbemi Ogunbunmi
 * Data Structures and Algorithms - CSCI 2302 
 * =====================================
 */

public class PrefixAverage {
/**
* Returns an array a such that, for all j, a[j] equals the average of x[0],
* ..., x[j].
*/
   public static double[] prefixAverage1(double[] x) {
      int n = x.length;
      double[] a = new double[n]; // filled with zeros by default
      for (int j = 0; j < n; j++) {
         double total = 0; // begin computing x[0] + ... + x[j]
         for (int i = 0; i <= j; i++)
            total += x[i];
         a[j] = total / (j + 1); // record the average
      }
      return a;
   }

/**
* Returns an array a such that, for all j, a[j] equals the average of x[0],
* ..., x[j].
*/
   public static double[] prefixAverage2(double[] x) {
      int n = x.length;
      double[] a = new double[n]; // filled with zeros by default
      double total = 0; // compute prefix sum as x[0] + x[1] + ...
      for (int j = 0; j < n; j++) {
         total += x[j]; // update prefix sum to include x[j]
         a[j] = total / (j + 1); // compute average based on current sum
      }
      return a;
   }
   
   //MAIN testing the input data
   public static void main(String args[]) {
      ms(50000);
      ms(100000);
      ms(200000);
      ms(400000);
      ms(800000);
      ms(1600000);
   }
   //creates array with pseudo-random numbers
   public static double[] array(int size) {
      double test[] = new double[size];
   
      for(int i=0; i<size; i++) {
         test[i] = size*Math.random();
      }
      return test;
   }

   public static void ms(int size) {
      double app[] = array(size);            //creates array with 'size' length
      System.out.println("n= " + size);
   //test 1
      double start = System.currentTimeMillis();// java method returns the current time in milliseconds
      prefixAverage1(app);                   //calls pA1
      double stop = System.currentTimeMillis();
      System.out.println("Time for PrefixAverage1 is "+(stop-start)+ " ms");//time it takes to run operation from start to finish
   //test 2
      start = System.currentTimeMillis();
      prefixAverage2(app);                  //calls pA2
      stop = System.currentTimeMillis();
      System.out.println("Time for prefixAverage2 is "+(stop-start)+" ms");
      System.out.println("\n");
   }
}
