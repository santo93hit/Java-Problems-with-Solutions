package com.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String nm=br.readLine();
//		int n=Integer.parseInt(nm.split(" ")[0]);
//		int m=Integer.parseInt(nm.split(" ")[1]);
//		String a[]=new String[n];
		/*for(int i=0;i<n;i++) {
			a[i]=br.readLine();
		}*/
//		String a[]= {"1010","0100","0010","0011"};
		int n=20,m=10;
		String a[]={"0010101101",
				"0001001101",
				"0010011011",
				"0000000010",
				"1010010110",
				"0110001011",
				"1001010110",
				"0011000101",
				"0010100010",
				"0001101110",
				"0101001101",
				"0010100111",
				"1110000010",
				"0001101110",
				"0001010011",
				"0111010100",
				"0001000000",
				"1100010001",
				"1011101111",
				"1101110000"};
		/*int a[][]=new int[n][m];
		int a[][]= {{1,0,1,0},
					{0,1,0,0},
					{0,0,1,0},
					{0,0,1,1}
				    };
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=Integer.parseInt(br.readLine());
			}
		}*/
		long max=Long.MIN_VALUE;
		int pos=0;
		for(int i=0;i<n;i++) {
			long sum=0;
			int k=m-1;
			for(int j=0;j<m;j++) {
				if(a[i].charAt(j)=='1') {
					sum=sum+(long)Math.pow(2,k);
				}
				k--;
			}
			System.out.println("sum ("+i+")= "+sum);
			if(max<sum) {
				max=sum;
				pos=i+1;
			}
		}
		System.out.println(pos);
	}

}
