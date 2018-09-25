package com.fragma;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class QueryController {

	public static final String MATCH_CSV_FILE_PATH = "E://OxegenWorkSpace/IPL_Data_set/matches.csv";
	public static final String DELIVERY_CSV_FILE_PATH = "E://OxegenWorkSpace/IPL_Data_set/deliveries.csv";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<Integer,List<Delivery>> deliveriesMap = readDeliverysFromCSV(DELIVERY_CSV_FILE_PATH);
		List<Match> matches = readMatchsFromCSV(MATCH_CSV_FILE_PATH,deliveriesMap);
		boolean flag=true;
		while(flag) {
			int query=sc.nextInt();
			switch(query) {
				case 1:	Map<Integer,String[]> teamElectedBatFirstIn2016 = getTopFourTeamWhoElectedBatFirstByYear(4,"field",2016,matches);
						Map<Integer,String[]> teamElectedBatFirstIn2017 = getTopFourTeamWhoElectedBatFirstByYear(4,"field",2017,matches);
						List<String[]> resultList = new ArrayList<String[]>();
						resultList.addAll(getTeam(teamElectedBatFirstIn2016));
						resultList.addAll(getTeam(teamElectedBatFirstIn2017));
						System.out.println("YEAR TEAM COUNT");
						for(String [] str : resultList) {
//							System.out.println(str[0]+", "+str[1]+","+str[2]);
							 System.out.println(String.format("%4s  %11s %s ", str[0], str[1], str[2]));
						}
						break;
				case 2:break;
				case 3:break;
				case 4:break;
				case 5:break;
				case 6: flag=false;
					break;
			}
		}

	}

	private static List<String[]> getTeam(Map<Integer, String[]> teamElectedBatFirstIn2016) {
		List<String[]> resultList = new ArrayList<String[]>();
		for(Entry<Integer,String[]> map : teamElectedBatFirstIn2016.entrySet()) {
			resultList.add(map.getValue());
		}
		return resultList;
	}

	private static Map<Integer,String[]> getTopFourTeamWhoElectedBatFirstByYear(int noOfTeam, String tossDecision, int year,List<Match> matches) {
		int count=1;
		Map<Integer,String[]> mapArray = new HashMap<Integer,String[]>();
		for(Match match : matches) {
			if(match.getSeason()==year && match.getTossDecision().equals(tossDecision) && count<=noOfTeam) {
				String str[] =new String[3];
				str[0]=String.valueOf(match.getSeason());
				str[1]=match.getTossWinner();
				str[2]=String.valueOf(count);
				mapArray.put(count, str);
				if(count==noOfTeam) {
					break;
				}
				count++;
			}
		}
		return mapArray;
	}

	private static List<Match> readMatchsFromCSV(String fileName,Map<Integer,List<Delivery>> deliveriesMap) { 
		List<Match> matchs = new ArrayList<Match>();
		Path pathToFile = Paths.get(fileName); 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null){ 
				String[] attributes = line.split(",");
				Match match = createMatch(attributes,deliveriesMap); 
				matchs.add(match);
//				line = br.readLine(); 
			} 
		} catch (IOException ioe) { 
			ioe.printStackTrace();
		} 
		return matchs; 
	} 

	private static Map<Integer,List<Delivery>> readDeliverysFromCSV(String fileName) { 
		List<Delivery> deliveries = new ArrayList<Delivery>();
		Path pathToFile = Paths.get(fileName); 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			String line = "";
			br.readLine();
			while ((line = br.readLine()) != null){ 
				String[] attributes = line.split(",");
				Delivery delivery = createDelivery(attributes);
				deliveries.add(delivery);	
//				line = br.readLine(); 
			} 
		} catch (IOException ioe) { 
			ioe.printStackTrace();
		} 
		
		Map<Integer,List<Delivery>> mapList = new LinkedHashMap<Integer,List<Delivery>>();
		List<Delivery> delList = null;
		for(Delivery delivery : deliveries) {
			if(mapList.containsKey(delivery.getMatchId())) {
				delList=mapList.get(delivery.getMatchId());
				delList.add(delivery);
			}else {
				delList = new ArrayList<Delivery>();
				delList.add(delivery);
				mapList.put(delivery.getMatchId(), delList);
			}
		}
		return mapList; 
	} 

	private static Delivery createDelivery(String[] attributes) {
		Delivery delivery = new Delivery();
		delivery.setMatchId(Integer.parseInt(attributes[0]));
		delivery.setInning(Integer.parseInt(attributes[1]));
		delivery.setBattingTeam(attributes[2]);
		delivery.setBowlingTeam(attributes[3]);
		delivery.setOver(Integer.parseInt(attributes[4]));
		delivery.setBall(Integer.parseInt(attributes[5]));
		delivery.setBatsman(attributes[6]);
		delivery.setBowler(attributes[7]);
		delivery.setWideRuns(Integer.parseInt(attributes[8]));
		delivery.setByeRuns(Integer.parseInt(attributes[9]));
		delivery.setLegByRuns(Integer.parseInt(attributes[10]));
		delivery.setNoBallRuns(Integer.parseInt(attributes[11]));
		delivery.setPenaltyRuns(Integer.parseInt(attributes[12]));
		delivery.setBatsManRuns(Integer.parseInt(attributes[13]));
		delivery.setExtraRuns(Integer.parseInt(attributes[14]));
		delivery.setTotalRuns(Integer.parseInt(attributes[15]));
		return delivery;
	}


	private static Match createMatch(String[] attributes,Map<Integer,List<Delivery>> deliveriesMap) {
		Match match = new Match();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		match.setMatchId(Integer.parseInt(attributes[0]));
		match.setSeason(Integer.parseInt(attributes[1]));
		match.setCity(attributes[2]);
		try {
			match.setDate(formatter.parse(attributes[3]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		match.setTeam1(attributes[4]);
		match.setTeam2(attributes[5]);
		match.setTossWinner(attributes[6]);
		match.setTossDecision(attributes[7]);
		match.setResult(attributes[8]);
		if(!attributes[8].equals("no result")) {
			System.out.println(attributes[0]);
			match.setWinner(attributes[9]);
		}
//		match.setWinner((attributes.length==10 && null != attributes[9])?attributes[9]:"");
		match.setDeliveries(deliveriesMap.get(Integer.parseInt(attributes[0])));
		return match;
	}

}
