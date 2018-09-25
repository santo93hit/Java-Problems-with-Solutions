package com.acron;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoilderAndCamp {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		String str= br.readLine();
		String str = "8 7 9 10 3";//find max no of solider saved
    	List<Integer> list1 = new ArrayList<Integer>();
		for(int i=0;i<str.split(" ").length;i++) {
			list1.add(Integer.parseInt(str.split(" ")[i]));
		}
		int sum=0;
		while(null!= list1 && !list1.isEmpty()) {
			Integer i = Collections.max(list1);
			sum=sum+i;
			if(list1.contains(i-1)) {
				list1.remove((Integer)(i-1));
			}else if(list1.contains(i-1)){
				list1.remove((Integer)(i+1));
			}
			list1.remove(i);
		}
		System.out.println(sum);//(Input : 8 7 9 10 3 , Output : 21)
								//(Input : 8 12 7 3 , Output : 23)
	}

}
