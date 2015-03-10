/** This class contains static methods for you to write using recursion.
 * We will post our solutions on the Piazza at some point.
 * When writing a method, it is best to write a JUnit testing procedure for
 * it! Do that regularly, and you will find programming/testing/debugging easier.
 * 
 * If you have trouble with a function, put in annotated println statements
 * to find out what is going wrong.
 *
 * If you want to write "elper" functions, go ahead.
 * We give you one already, to get a string with a particular character
 * repeated a number of times. take a look at it!
 * 
 * For those who are fluent with Java and want a challenge, look at the 
 * very last function.
 */

public class RecursionSkeleton {

    /** Return the number of times c occurs in s. */
    public static int number(char c, String s) {
        return 0;
    }

    /** Return a copy of s with each character duplicated. */
    public static String dup(String s) {
        return "";
    }

    /** Return a copy of s with duplicate adjacent chars deleted.
     * Example, for "baaacca$$%", return  "baca$%"*/
    public static String removeAdjacentDups(String s) {
        return "";
    }

    /** Return a String of n characters, each being c.
     * Precondition: n >= 0*/
    public static String repeated(char c, int n) {
        /* Hint: This function creates a char array of size n in which
         * each element is the null char '\0'. It then creates a
         * string from the array. Finally, it replaces each of
         * the null chars by c.
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
        return "";
    }

    /** Return s but in compressed form --see function decompresss above.
     * Precondition: all sequences of adjacent chars in s are of length < 9.
     * Example. For s = "3333$$$Bx", resutrn the string "434$1B1x"
     */
    public static String compress(String s) {
        // Hint. It's ok to use a loop to find the end of the sequence
        // of = chars at beginning of s
        return "";
    }


    /** Return the reverse of s.
     * Note: This is inefficient, and we will explain why.
     * Do it by splitting the string into s[0] and s[1..] (i.e. the rest of s)
     */
    public static String reverse1(String s) {
        return "";
    }

    /** Return the reverse of s.
     * Note: This is inefficient, and we will explain why.
     * Letting n be s.length()-1,
     * Do it by splitting the string into s[0] and s[1..n-1] and s[n].
     */
    public static String reverse2(String s) {
        return "";
    }

    /** Return the number of decimal digits needed to write n.
     * Precondition: n >= 0.
     * E.g. for n = 0, the answer is 1
     * for n = 5, the answer is 1
     * for n = 3450, the answer is 4 */
    public static int numDigits(int n) {
        return 0;
    }

    /** Return the sum of the (decimal) digits of n.
     * Example. for n = 384, return 15
     * Precondition: n >= 0.
     */
    public static int sumDigits(int n) {
        return 0;
    }

    /** Return n with all of its odd digits replaced by 0.
     * Examples. if n is 0, return 0.
     *           if n is 6354, return 6004.
     *           if n is 3250, return 200.
     *           if n is 3050, return 0.
     * Precondition: n >= 0.  */
    public static int ZeroOutOddDigits(int n) {
        // Do NOT use Strings or anything like that. Stick to int
        return 0;
    }

    /** Keep adding the digits of n together until the result is < 10.
     * Return the result.
     * Precondition:: n >= 0
     * E.g. For n = 457, the result is 7
     * for n = 46, the answer is 1
     */
    public static int addUp(int n) {
        return 0;
    }

    /** Complement n --by replacing each digit k (say) of n by 10-k.
     * Precondition: n > 0 and no digit of n is 0.
     * Example: The complement of 3572 is 7538. */
    public static int complement(int n) {
        return 0;
    }

    /** Return n with commas placed the way Americans do it (many other
     * countries do not).
     * Example. For n = 5624827, return "5,624,827"
     * Precondition: n >= 0.
     */
    public static String commafy(long n) {
        // Do NOT start by making n into a String and then processing the
        // String. Instead, break n apart.
        return "";
    }

    /** = n, with 0's prepended if necessary to get at least 3 chars.
     * Precondition: n >= 0 */
    private static String prependTo3(long n) {
        return "";

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
        return 0;
    }
}
