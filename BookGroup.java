package com.acron;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BookGroup {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		String str= br.readLine();
		int n=7;
		String str="2 4 2 4 3 2 3";// form max size group having each no in a group
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Map<Integer,Integer> valMap = new HashMap<Integer,Integer>();
    	for(int i=0;i<n;i++) {
    		int val=Integer.parseInt(str.split(" ")[i]);
    		if(map.containsKey(val)) {
    			map.put(val,map.get(val)+1);
    		}else {
    			map.put(val,1);
    		}
    	}
    	for(Integer val : map.values()) {
    		if(valMap.containsKey(val)) {
    			valMap.put(val,valMap.get(val)+1);
    		}else {
    			valMap.put(val,1);
    		}
    	}
    	Integer max = Collections.max(valMap.values());
    	for(Entry<Integer,Integer> val : valMap.entrySet()) {
    		if(val.getValue()==max) {
    			System.out.println(val.getKey());//(Input : 2 4 2 4 3 2 3 , Output : 2)
												 //(Input : 1 2 , Output : 1)
    		}
    	}
	}

}
