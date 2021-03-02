/*
Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.

The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.

Example 1:

Input:
n = 3 k = 2
Output: 3
Explanation: There are 3 persons so 
skipping 1 person i.e 1st person 2nd 
person will be killed. Thus the safe 
position is 3.
*/

class Solution
{
   public int josephus(int n, int k)
    {
        if(n==1){
            return 1;
        }
        
           return (josephus(n - 1, k) + k-1) % n + 1;
    }

}




// second solutiomn

// Java program for Josephus problem
import java.util.*;

// Main class
public class GFG {

    // Recursive function
    public static int josephus(ArrayList<Integer> list,
                               int start, int k)
    {

        // If size of list is one
        // then return its value
        if (list.size() == 1) {
            return list.get(0);
        }

        // Counting kth person and
        // check so that it don't go out of bound
        start = (start + k) % list.size();

        // Removing the kth person
        list.remove(start);

        // Calling recursive function again until only one
        // person left Start is now the position of previous
        // person who is killed Ex. if person at 1-index
        // killed then person at 2-index shifted to 1-index
        // and counting start from here
        return josephus(list, start, k);
    }

    // Main function
    public static void main(String[] args)
    {

        // Number of people to be executed
        int n = 7;

        // Number of person to be skipped
        int k = 3;

        // Initialising an ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Storing value from 1 to n
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // Calling function with starting position at
        // 0-index and k-1 so that kth person will be killed
        // Storing the safe position
        int safePosition = josephus(list, 0, k - 1);

        // Printing the result
        System.out.println("The safe position : "
                           + safePosition);
    }
}
