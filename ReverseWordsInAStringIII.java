import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class ReverseWordsInAStringIII {


    /**
     * Reverse the order of characters in each word within a sentence 
     * while still preserving whitespace and initial word order.
     * 
     * 29 / 29 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 39.7 MB
     * 
     * Runtime: O(n) - Space: O(n)
     */
    static public String reverseWords0(String s) {
        
        // **** initialization ****
        char[] arr  = s.toCharArray();
        int len     = s.length();
        int b       = 0;
        int e       = 0;

        // ???? ????
        System.out.println("<<< arr: " + Arrays.toString(arr));

        // **** loop selecting words to reverse - O(n) ****
        while (b < len) {

            // **** look for end of current word ****
            for (e = b; e < len && arr[e] != ' '; e++);

            // ???? ????
            System.out.println("<<< b: " + b + " e: " + e);

            // **** reverse the word ****
            reverse(arr, b, e - 1);

            // ???? ????
            System.out.println("<<< arr: " + Arrays.toString(arr));

            // **** update index ****
            b = e + 1;
        }

        // **** return string associated with the arr ****
        return String.valueOf(arr);
    }


    /**
     * Auxiliary function.
     */
    static public void reverse(char[] arr, int b, int e) {
        while(b < e) {
            char tmp    = arr[b];
            arr[b++]    = arr[e];
            arr[e--]    = tmp;
        }
    }





   /**
     * Reverse the order of characters in each word within a sentence 
     * while still preserving whitespace and initial word order.
     */
    static public String reverseWords(String s) {

        // **** initialization ****
        int from            = 0;
        int len             = s.length();
        StringBuilder sb    = new StringBuilder();
        StringBuilder word  = null;

        // **** loop reversion words ****
        while (from < len) {

            // **** next ' ' ****
            int space = s.indexOf(' ', from);

            // **** ****
            if (space != -1)
                word = new StringBuilder(s.substring(from, space));
            else
                word = new StringBuilder(s.substring(from));
            
            // **** reverse this word ****
            word.reverse();

            // **** append reversed word ****
            sb.append(word);

            // **** append space (if needed) ****
            if (space != -1) sb.append(' ');

            // **** update index ****
            if (space != -1)
                from = space + 1;
            else
                from = len;
        }

        // **** return string with reversed words ****
        return sb.toString();
    }



    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read string `s` ****
        String s = br.readLine().trim();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** call function of interest and display output ****
        System.out.println("main <<< output ==>" + reverseWords(s) + "<==");
    }   

}