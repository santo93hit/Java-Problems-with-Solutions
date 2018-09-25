package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AllSubArrayOfKLength {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int k = 3;
	    int a[]= {1,2,3,4,5};
	    int sub[]=new int[k];

	    /*for(int i = 0 ; i < n; ++i) {
	    	a[i]=Integer.parseInt(br.readLine());
	    }*/
	    subarray(a, n , sub, k, 0, 0,0);
	}

	static void subarray(int a[], int n, int sub[], int r, int i, int j,int sum)
	{
	    if(j == r) /* current index of sub r, print sub */
	    {
	    	Map<Integer,Integer> countMap=new HashMap<Integer,Integer>();
	    	for(int k=0;k<r;k++) {
	    		if(countMap.containsKey(sub[k])) {
	    			countMap.put(sub[k], countMap.get(sub[k])+1);
	    		}else {
	    			countMap.put(sub[k],1);
	    		}
	    	}
	    	for(Entry<Integer, Integer> map : countMap.entrySet()) {
	    		if(map.getValue()%2!=0) {
	    			
	    		}
	    	}
	        /*int k;

	        System.out.print("( ");

	        for(k = 0; k < r; k++)
	        	System.out.print(sub[k]);

	        System.out.println(")");*/
	    	
	    }
	    else
	    {
	        if(i < n)
	        {
	            sub[j] = a[i];

	            subarray(a, n, sub, r, i + 1, j + 1,sum); /* Include current element */
	            subarray(a, n, sub, r, i + 1, j,sum);     /* Override the current element */
	        }
	    }

	}

}
