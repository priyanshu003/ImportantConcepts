/*Dr. Chef is treating COVID-19 patients. There is a queue of N patients (numbered from patient 1 at the front of the queue to patient N at the back) outside his clinic. You, his assistant, found out that for each valid i, the i-th patient has an illness level Ai.

Chef treats patients based on their health, i.e. a patient with a higher illness level is always treated before any patients with a lower illness level. Chef is also fair, so he treats patients with an equal illness level based on their position in the queue, i.e. a patient ahead in the queue is always treated before a patient with the same illness level that is further behind in the queue.

The first patient to be treated has to wait an hour for Chef to set up his equipment. Treating each patient also takes an hour, and Chef always starts treating the next patient as soon as he is done with the current one.

The patients are a bit impatient. As Chef's assistant, for each patient, find out how long (in hours) this patient needs to wait before Chef starts treating this patient */

// 4
// 5
// 2 3 5 3 4
// 3
// 2 2 2
// 6
// 2 10 3 3 2 10
// 4
// 8 9 8 9

import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc=new FastReader();
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		   
		    int a[]=new int[n];
		    int b[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        b[i]=a[i];    
		    }
		   int ans[]=new int[n];
		   Arrays.sort(b);     // sort the temp array and now search for its index in main array.
		   int c=1;
		   int r=-1;          //element  searched  nver be searched again
		   for(int i=n-1;i>=0;i--){
		       if(b[i]==r){      //element  searched  nver be searched again
		           continue;
		       }
		       for(int j=0;j<n;j++){
		           if(b[i]==a[j]){
		               ans[j]=c;
		               c++;
		           }
		       }
		       r=b[i];
		   }
		   
		    StringBuilder sb=new StringBuilder();
		    for(int i:ans){
		        sb.append(i+" ");
		    }
		    System.out.println(sb);
		}
		
		
	}
		static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}
