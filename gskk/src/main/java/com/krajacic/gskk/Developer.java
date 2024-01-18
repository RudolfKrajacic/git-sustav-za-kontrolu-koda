package com.krajacic.gskk;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Developer {

	String Ime;
	List<Commit> commitList = new ArrayList<Commit>();
	Integer waitTime = 0;
	
	public Developer(String ime) {
		this.Ime = ime;
	}
	
	public void addCommits(Commit commit) {
		commitList.add(commit);
	}
	
	
}
