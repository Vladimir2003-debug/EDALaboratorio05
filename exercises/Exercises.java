package exercises;

public class Exercises {
    /**
     * Given a string of brackets,
     * it determines whether each sequence of brackets is balanced.
     * If a string is balanced, return YES. Otherwise, return NO.
     *
     * Examples
     *  case 1: '{[()]}'     returns YES
     *  case 2: '[(])'       returns NO
     *  case 3: '[[(())]]'  returns YES
     *
     * @param a the string of brackets
     * @return YES if the brackets are balanced
     *         NO if the brackets are not balanced
     */
    public static String isBalanced(String a) {
        String begin = "([{";
        String end = ")]}";
        boolean balance;
        int i = 0;
        while(i < a.length()/2) {
            balance = begin.indexOf(a.charAt(i)) != end.indexOf(a.charAt(a.length()- 1 - i));
            if (balance) {
                return "NO";
            }
            i++;
        }
        return "YES";
    }
}
