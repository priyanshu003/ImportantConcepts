/*given a string s print its all subsequence using bit manupulation*/


package Bit;
import java.util.*;
public class Sequence {

	public static void main(String[] args) {
	
		String s = "abc";
		printSequece(s,s.length());

	}

	private static void printSequece(String s, int length) {
		for(int i = 0;i<(1<<length);i++) {
			prints(s,i);
		}
		
	}

	private static void prints(String s, int i) {
		
		int pos = 0 ;
		while(i>0) {
			if((i&1) == 1)
			System.out.print(s.charAt(pos));
			pos++;
			i>>=1;
		}
		System.out.println();
		
	}

}
