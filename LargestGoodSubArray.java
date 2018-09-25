package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LargestGoodSubArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0) {
        	int n = Integer.parseInt(br.readLine());
        	String str=br.readLine();
        	List<IndexVal> list = new ArrayList<IndexVal>();
        	for(int i=0;i<n;i++) {
        		list.add(new IndexVal(Long.parseLong(str.split(" ")[i]),Long.parseLong(String.valueOf(i))));
        	}
        	Collections.sort(list, new IndexVal());
        	Long curMaxIdx = list.get(0).getLastElement();
        	Long finalAnswer = -1L;
    		for(int i = 1; i < list.size(); i++){
    			IndexVal p = list.get(i);
    			if(curMaxIdx > p.getLastElement()){
    				p.setLongestFromCurrElement(curMaxIdx - p.getLastElement() + 1L);
    			}
    			else{
    				curMaxIdx = p.getLastElement();
    			}
    			finalAnswer = finalAnswer < p.getLongestFromCurrElement() ? 
    								p.getLongestFromCurrElement(): finalAnswer;
    		}
    		
    		System.out.println(finalAnswer);
        	
        }
	}

}

class IndexVal implements Comparator<IndexVal>{
	 
	private Long firstElement;
	private Long lastElement;
	private Long longestFromCurrElement;
 
	IndexVal(){
		this.firstElement = 0L;
		this.lastElement = 0L;
		this.longestFromCurrElement = 1L;
	}
 
	IndexVal(Long firstElement, Long lastElement){
		this.firstElement = firstElement;
		this.lastElement = lastElement;
		this.longestFromCurrElement = 1L;
	}
 
	public int compare(IndexVal a, IndexVal b){
		if(a.firstElement == b.firstElement){
			return (int) (b.lastElement - a.lastElement);
		}
		return (int) (a.firstElement - b.firstElement);
	}

	public Long getFirstElement() {
		return firstElement;
	}

	public Long getLastElement() {
		return lastElement;
	}

	public Long getLongestFromCurrElement() {
		return longestFromCurrElement;
	}

	public void setLongestFromCurrElement(Long longestFromCurrElement) {
		this.longestFromCurrElement = longestFromCurrElement;
	}
 
}

