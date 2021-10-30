
public class Drill03 {

    // takes a string and two characters as parameters
    // returns a string that is the same as the passed in string
    // except that all occurrences of the first character are replaced
    // with the second
    public static String replaceAll(String s, char from, char to) {
        if (s.length() == 0) {
        	return "";
        }
        else {
        	String string = s.substring(1);
        	char check = s.charAt(0);
        	if (check == from) {
        		return to + replaceAll(string, from, to);
        	}
        	else {
        		return check + replaceAll(string, from, to);
        	}
        }
    }

    // takes an integer as a parameter
    // returns true if the digits are in sorted order ascending, 
    // false otherwise
    public static boolean digitsSorted(int x) {
    	if (x < 0) {
    		x = Math.abs(x);
    	}
    	if (x == 0) {
    		return true;
    	}
    	else {
    		int check = x % 10;
    		int integer = x / 10;
    		if (check >= integer % 10) {
    			return digitsSorted(integer);
    		}
    		else {
    			return false;
    		}
    	}
    }

    /*
     * Write a recursive function which returns the input string
     * but with adjacent duplicate char- acters removed. Do not use
     * any String functions other than .charAt(), .length(), .isEmpty()
     * and .substring(). Do not use any loops. We recommend you use a
     * helper function so we have provided the helper function header
     * below
     */
    public static String removeAdjacentDuplicateChars(String s) {
    	if (s.length() == 0) {
    		return "";
    	}
    	else {
    		int len = s.length();
    		String result = removeHelper(s, len - 1);
    		return result;
    	}
    }
    // Note that the helper function is 'private' since no other code
    // outside of this file needs to call this method.
    private static String removeHelper(String s, int index) {
    	if (index == 0) {
    		return s;
    	}
    	else {
    		char cur = s.charAt(index);
    		char prev = s.charAt(index - 1);
    		String result = s.substring(0, index);
    		if (cur == prev) {
    			return removeHelper(result, index - 1);
    		}
    		else {
    			return removeHelper(result, index - 1) + cur;
    		}
    	}
    }
    
    /*
     * Write a recursive function that returns the number of occurrences
     * of an integer ’n’ inside of an array of integers. You may not use
     * loops or any array functions. You may use array.length to determine
     * the length of the array. We recommend you use a helper similar to the
     * one above. It would be useful if your helper function kept track of
     * which index in the array you are currently checking.
     */
    public static int countOccurrences(int[] arr, int n) {
    	if (arr.length == 0) {
    		return 0;
    	}
    	else {
    		int len = arr.length;
    		int result = countOccurrencesHelper(arr, n, len - 1);
    		return result;
    	}
    }
    
    private static int countOccurrencesHelper(int[] arr, int n, int index) {
    	if (index == -1) {
    		return 0;
    	}
    	else {
    		if (arr[index] == n) {
    			return countOccurrencesHelper(arr, n, index - 1) + 1;
    		}
    		else {
    			return countOccurrencesHelper(arr, n, index - 1);
    		}
    	}
    }
}
