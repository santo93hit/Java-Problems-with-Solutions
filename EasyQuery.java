package com.apostek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EasyQuery {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int q = Integer.parseInt(tk.nextToken());
        String str= br.readLine();
    	int a[] = new int[n];
    	for(int i=0;i<n;i++) {
    		a[i]=Integer.parseInt(str.split(" ")[i]);
    	}
    	while(q-->0) {
    		StringTokenizer tkType = new StringTokenizer(br.readLine());
    		int type = Integer.parseInt(tkType.nextToken());
            int index = Integer.parseInt(tkType.nextToken());
    		if(type==0) {
    			int lIndex=index-1;
    			int rIndex=index+1;
    			while(lIndex>=0) {
    				if(a[lIndex]==1) {
    					break;
    				}
    				lIndex--;
    			}
    			while(rIndex<n) {
    				if(a[rIndex]==1) {
    					break;
    				}
    				rIndex++;
    			}
    			if(rIndex==n) {
    				rIndex=-1;
    			}
    			System.out.println(lIndex+" "+rIndex);
    		}else {
    			if(a[index]==0) {
    				a[index]=1;
    			}
    		}
    	}
	}

}
