/*
Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 */
 
 import java.io.*;
import java.lang.*;
  
public class GFG {
    static ArrayList<String> res=new ArrayList<>();
    public static void getPermutation(String str) 
    { 
        char ch[]=str.toCharArray();
        res=new ArrayList<>();
        permute(ch,0,str.length()-1);
        Collections.sort(res);
        for(String s:res)
        System.out.print(s+" ");
        // return res;
    } 
    public static void permute(char ch[],int l,int r){
        if(l==r)
        res.add(String.valueOf(ch));
        else{
            char temp;
            for(int i=l;i<=r;i++){
                temp=ch[l];
                ch[l]=ch[i];
                ch[i]=temp;
                permute(ch,l+1,r);
                temp=ch[l];
                ch[l]=ch[i];
                ch[i]=temp;
            }
        }
    }
  
    // Driver code 
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String str = sc.next(); 
            getPermutation(str); 
            System.out.println();
        }
    }
}
