/** This class contains solutions to the static methods for you to write using recursion.
 * When writing a method, it is best to write a JUnit testing procedure for
 * it! Do that regularly, and you will find programming/testing/debugging easier.
 * 
 * If you have trouble with a function, put in annotated println statements
 * to find out what is going wrong.
 *
 */

public class Recursion {

    /** Return the number of times c occurs in s. */
    public static int number(char c, String s) {
        if (s.length() == 0) return 0;
        return (c == s.charAt(0) ? 1 : 0) + number(c, s.substring(1));
    }

    /** Return a copy of s with each character duplicated. */
    public static String dup(String s) {
        if (s.length() == 0) return s;
        return s.charAt(0) + (s.charAt(0) + dup(s.substring(1)));
    }

    /** Return a copy of s with duplicate adjacent chars deleted.
     * Example, for "baaacca$$%", return  "baca$%"*/
    public static String removeAdjacentDups(String s) {
        if (s.length() <= 1) return s;
        if (s.charAt(0) == s.charAt(1))
            return removeAdjacentDups(s.substring(1));
        return s.charAt(0) + removeAdjacentDups(s.substring(1));
    }
    
    /** Return a String of n characters, each being c.
     * Precondition: n >= 0*/
    public static String repeated(char c, int n) {
        /* Hint: This function creates a char array of size n in which
         * each element is the null char '\0'. It then creates a
         * string from the array. Finally, it replaces each of
         * the null chars by c.
         * Each operation takes time O(n). This is more efficient than
         * the typical loop one writes, appending 1 char at a time to a
         * String, which in total O(n*n).
         */
        return new String(new char[n]).replace("\0", "" + c);
    }
    
    /** s is in compressed form: it consists of a sequence of pairs
     * of characters. The first char of a pair is a digit, and the second char
     * can be any char. Return the decompressed form of s, in which each
     * pair is uncompressed ---e.g. "4c" is replaced by "cccc".
     * Example: For "3$2b0d65" return "$$$bb55555"
     */
    public static String decompress(String s) {
        //Hint: Make use of function repeated, just above.
        // Study it!
        if (s.length() == 0) return s;
        // s has at least 2 chars.
        int n= Integer.parseInt(s.substring(0,1));
        return repeated(s.charAt(1), n) + decompress(s.substring(2));
    }
    
    /** Return s but in compressed form --see function decompresss above.
     * Precondition: all sequences of adjacent chars in s are of length < 9.
     * Example. For s = "3333$$$Bx", resutrn the string "434$1B1x"
     */
    public static String compress(String s) {
        // Hint. It's ok to use a loop to find the end of the sequence
        // of = chars at beginning of s
        
        if (s.length() == 0) return s;
        // s has at least 1 char.
        // Set k to the number of adjacent = chars at beginning of s.
        int k= 1;
        while (k < s.length() && s.charAt(0) == s.charAt(k)) {
            k= k+1;
        }
        return k + (s.charAt(0) + compress(s.substring(k)));
    }


   /** Return the reverse of s.
    * Do it by splitting the string into s[0] and s[1..] (i.e. the rest of s)
    */
    public static String reverse1(String s) {
        if (s.length() <= 1) return s;
        return reverse1(s.substring(1)) + s.charAt(0);
    }
    
    /** Return the reverse of s.
     * Letting n be s.length()-1,
     * Do it by splitting the string into s[0] and s[1..n-1] and s[n].
     */
     public static String reverse2(String s) {
         if (s.length() <= 1) return s;
         int n= s.length() - 1;
         return s.charAt(n) + reverse2(s.substring(1,n)) + s.charAt(0);
     }
     
     /** Return the number of decimal digits needed to write n.
      * Precondition: n >= 0.
      * E.g. for n = 0, the answer is 1
      * for n = 5, the answer is 1
      * for n = 3450, the answer is 4 */
     public static int numDigits(int n) {
         if (n < 10) return 1;
         return 1 + numDigits(n/10);
     }
     
     /** Return the sum of the (decimal) digits of n.
      * Example. for n = 384, return 15
      * Precondition: n >= 0.
      */
     public static int sumDigits(int n) {
         if (n == 0) return 0;
         return (n%10) + sumDigits(n/10);
     }
     
     /** Return n with all of its odd digits replaced by 0.
      * Examples. if n is 0, return 0.
      *           if n is 6354, return 6004.
      *           if n is 3250, return 200.
      *           if n is 3050, return 0.
      * Precondition: n >= 0.  */
     public static int ZeroOutOddDigits(int n) {
         // Do NOT use Strings or anything like that. Stick to int
         if (n == 0) return 0;
         int f= n%10;
         return 10 * ZeroOutOddDigits(n/10) + (f%2 == 0 ? f : 0);
     }
     
     /** Keep adding the digits of n together until the result is < 10.
      * Return the result.
      * Precondition:: n >= 0
      * E.g. For n = 457, the result is 7
      * for n = 46, the answer is 1
      */
      public static int addUp(int n) {
          if (n < 10) return n;
          return addUp(n/10 + n%10);
      }
      
      /** Complement n --by replacing each digit k (say) of n by 10-k.
       * Precondition: n > 0 and no digit of n is 0.
       * Example: The complement of 3572 is 7538. */
     public static int complement(int n) {
         if (n < 10) return 10 - n;
         return complement(n/10)*10 + (10 - n%10);
     }
     
     /** Return n with commas placed the way Americans do it (many other
      * countries do not).
      * Example. For n = 5624827, return "5,624,827"
      * Precondition: n >= 0.
      */
     public static String commafy(long n) {
         // Do NOT start by making n into a String and then processing the
         // String. Instead, break n apart.
         if (n < 1000) return "" + n;
         return commafy(n/1000) + "," + prependTo3(n%1000);
     }
     
     /** = n, with 0's prepended if necessary to get at least 3 chars.
      * Precondition: n >= 0 */
     private static String prependTo3(long n) {
         if (n < 10) return "00" + n;
         if (n < 100) return "0" + n;
         return "" + n;
         
     }
     
     
     /** Return the sum of all integer values in obj.
      * Precondition: obj is one of the classes: Integer, Integer[], Integer[][],
      * Integer[][][], etc.
      * Precondition: If obj is an array, none of its elements is null.
      * Examples: Below, an integer like 4 represents an Integer object that
      * contains that integer.
      * For the argument 5, the value 5 is returned.
      * For the array {1, 2, 3}, 6 is returned because 1+2+3 = 6.
      * For the array {{1, 2, 5}, {3, 4}}, 15 is returned because 1+2+5+3+4 = 15.
      * For the array {{{1}, {0, 3}, {}}, {{1,2,3}, {3}}}, 13 is returned
      *     because 1+0+3+0+1+2+3+3 = 13.
      */
     public static int arraySum(Object obj) {
         /** It is an ingenious use of recursion to sum the values of an Integer
          * array, no matter how many dimensions. Here are some hints.
          * (1) If obj is of type Integer, it's easy to get its value. This is a
          *     0-dimensional array.
          * (2) If obj is not of type Integer, it is an array and can be cast to
          *     type Object[]. You can then use the recursive function to get the
          *     sum of each of its elements and add them together */
         if (obj instanceof Integer) {
             return (Integer)obj;
         }
         Object[] b= (Object[]) obj;
         int sum=0;
         for (Object k : b) {
             sum= sum + arraySum(k);
         }
         return sum;
     }
}
