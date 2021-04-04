	public static boolean Check(String ch) {
		int n = ch.length();
		for(int i = 0; 2 * i < n; i++) {
			if(ch.charAt(i) != ch.charAt(n-i-1)) return false; // false meaning non palindrome 
		}
		return true;
	}
 
	public static int SumDigit(int n) {
		int ans = 0;
		while(n != 0){
			ans += n % 10;
			n /= 10;
		}
		return ans;
	}
 
	static boolean[] prime;
 
	public static void sieveOfEratosthenes(int n) {
        	prime = new boolean[n+1];
	        for(int i=0;i<n;i++)
	            prime[i] = true;
	          
	        for(int p = 2; p*p <=n; p++) {
 
	            if(prime[p] == true) {
 
	                for(int i = p*p; i <= n; i += p)
	                    prime[i] = false;
	            }
	        }
    	}
 
	public static long binpow(long n, long m, long mod) {
	        long res = 1;
	        while (m > 0) {
	            if (m % 2 == 1) {
	                res *= n;
	                res %= mod;
	                m--;
	            }
	            n *= n;
	            n %= mod;
	            m /= 2;
	        }
	        return res;
    	}
 
	public static int LowerBound(int a[], int x) { // x is the target value or key
 
		  int l = -1,r = a.length;
 
		  while(l + 1 < r) {
 
		    int m = (l + r) >>> 1;
		    if(a[m] >= x) r = m;
		    else l = m;
 
		  }
		  return r;
	}
 
	public static int UpperBound(long a[], long x) {// x is the key or target value
 
		    int l = -1,r = a.length;
 
		    while(l + 1 < r) {
 
		       int m = (l + r) >>> 1;
		       if(a[m] <= x) l = m;
		       else r = m;
 
		    }
		    return l + 1;
	}
 
	public static int Check(long arr[], int l, int r, long x, int n) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (mid == 0 || mid == n - 1 || (arr[mid] <= x && arr[mid + 1] > x) )
				return mid;
			if (arr[mid] > x)
				return Check(arr, l, mid - 1, x, n);
			return Check(arr, mid + 1, r, x, n);
		}
		return -1;
	}
 
    	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}
     
	public static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
	public static HashMap<Integer, Integer> CountFrequencies(int[] arr) {
     
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			if (map.containsKey(i)) map.put(i, map.get(i) + 1);
			else map.put(i, 1);
		}
		return map;
	}
     
	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
 
	    List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
	    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
 
		public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) { 
 
		    return (o1.getValue()).compareTo(o2.getValue()); 
		} 
	    });
 
	    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
 
	    for (Map.Entry<Integer, Integer> aa : list) { 
			temp.put(aa.getKey(), aa.getValue()); 
	    } 
	    return temp; 
	} 
 
	public static void sort(int[] arr) {
		Random rand = new Random();
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			swap(arr, i, rand.nextInt(n));
		}
		Arrays.sort(arr);
	}
 
	public static void swap(int[] arr, int i, int j) {
		if(i!=j) {
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];
		}
	}
     
	public static void sortbyColumn(int[][] arr, int col) {
 
		Arrays.sort(arr, new Comparator<int[]>() {
 
			public int compare(final int[] entry1, final int[] entry2) {
 
				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		});
	}
 
     
	public static void ArraySort2D(int[][] arr, int xy) {
		// xy == 0, for sorting wrt X-Axis
		// xy == 1, for sorting wrt Y-Axis
		Arrays.sort(arr, Comparator.comparingDouble(o -> o[xy]));
	}
	
	public static int binarySearch(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);
			return binarySearch(arr, mid + 1, r, x);
		}
		return -1;
	}
     
