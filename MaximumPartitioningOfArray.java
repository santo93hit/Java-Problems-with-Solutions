package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumPartitioningOfArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0) {
        	StringTokenizer tx = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(tx.nextToken());
        	int k = Integer.parseInt(tx.nextToken());
        	String str= br.readLine();
        	int a[]=new int[n];
        	for(int i=0;i<n;i++) {
        		a[i]=Integer.parseInt(str.split(" ")[i]);
        	}
        	
        	/*Map<Integer,Integer> countMap
        	for() {
        		
        	}*/
        }
		
	}
	
	int[] subarray(int a[], int n, int sub[], int r, int i, int j)
	{
	    if(j != r) {
	    	if(i < n){
	            sub[j] = a[i];

	            subarray(a, n, sub, r, i + 1, j + 1); 
	            subarray(a, n, sub, r, i + 1, j);     
	        }
	    }
	    return sub;
	}

}
