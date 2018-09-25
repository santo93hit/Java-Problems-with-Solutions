package com.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OldAndCold {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
//		String array[]=str.split(" ");
		int a[]=new int[n];
		Map<Integer,Integer> oddCountMap=new HashMap<Integer,Integer>(n);
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(str.split(" ")[i]);
//			System.out.println(a[i]);
		}
		
		int q=Integer.parseInt(br.readLine());
		while(q-->0) {
			String lr=br.readLine();
			int l=Integer.parseInt(lr.split(" ")[0]);
			int r=Integer.parseInt(lr.split(" ")[1]);
			for(int i=l;i<r;i++) {
				int oddCount=0;
				if(a[i]%2==0) {
					oddCount=a[i]/2;
				}else {
					oddCount=(a[i]/2)+1;
				}
				if(a[i]%oddCount==0) {
					oddCountMap.put(i, 1);
				}else {
					oddCountMap.put(i, 0);
				}
			}
		}
		
		

	}

}
