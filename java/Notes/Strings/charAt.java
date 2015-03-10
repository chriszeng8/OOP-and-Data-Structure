/** Note the difference between
return charAt(0)+string
return (charAt(0)+string)
return ""+charAt(0)+string

Takeaway: always 
*/

public class PrintChar {

    /** Return a copy of s with each character duplicated. */
    public static String dup(String s) {
        if (s.length()==0) return "";
        return ""+s.charAt(0)+s.charAt(0)+dup(s.substring(1));
    }

    /** Return a copy of s with each character duplicated. */
    public static String dup1(String s) {
        if (s.length()==0) return "";
        return s.charAt(0)+(s.charAt(0)+dup(s.substring(1)));
    }

    /** Return a copy of s with each character duplicated. */
    public static String dup2(String s) {
        if (s.length()==0) return "";
        return s.charAt(0)+s.charAt(0)+dup(s.substring(1));
    }

    public static void main (String args[]) {
        System.out.println(PrintChar.dup("abc"));
        System.out.println(PrintChar.dup1("abc"));
        System.out.println(PrintChar.dup2("abc"));
    }

}


