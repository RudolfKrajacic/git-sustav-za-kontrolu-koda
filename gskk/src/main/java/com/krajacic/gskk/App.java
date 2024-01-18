package com.krajacic.gskk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args )
    {
    	List<Commit> commitList = new ArrayList<>();
    	List<String> developers = new ArrayList<>();
    	List<Integer> totalWaitingTime = new ArrayList<>();
    	List<Developer> developerCommitList = new ArrayList<>();
    	List<Commit> MCList = new ArrayList<>();
    	
    	//Učitavanje JSON datoteke
        ClassLoader classLoader = App.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("zadatak.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            commitList.addAll(objectMapper.readValue(inputStream, new TypeReference<List<Commit>>() {}));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Kreiranje liste programera i liste commit-eva
        for (Commit commit : commitList.subList(1, commitList.size())) {
			if (!developers.contains(commit.getProgramer())) {
				developers.add(commit.getProgramer());
				developerCommitList.add(new Developer(commit.getProgramer()));
			}
		}
        
        //Spajanje programera i njihovih commit-eva
        for (Developer developer : developerCommitList) {
			for (Commit commit : commitList.subList(1, commitList.size())) {
				if (!commit.getTip().equals("FC")) {
					if (developer.getIme().equals(commit.getProgramer())) {
						developer.addCommits(commit);
					}					
				}
			}
		}
        
      //Izračunavanje vremena kojeg je programer proveo čekajući
        for (Developer developer : developerCommitList) {
        	Integer sumMC = 0;
        	Integer sumBC = 0;
        	for (int i = 1; i < developer.getCommitList().size()-1; i++) {
				if (developer.getCommitList().get(i).getTip().equals("BC")) {
					sumBC += Integer.parseInt(developer.getCommitList().get(i).getVrijeme());
				}
				else {
					sumMC += Integer.parseInt(developer.getCommitList().get(i).getVrijeme());
				}
			}
        	totalWaitingTime.add(sumBC - sumMC);
		}
        
        System.out.println("Ukupno vrijeme čekanja:");
        for (int i = 0; i < totalWaitingTime.size(); i++) {
        	System.out.println("Programer " + developers.get(i) + " je ukupno čekao: " + totalWaitingTime.get(i));
		}
    }
}
