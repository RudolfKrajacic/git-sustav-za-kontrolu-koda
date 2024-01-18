package com.krajacic.gskk;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commit {

	@JsonProperty("ID")
	private String ID;
	
	@JsonProperty("Programer")
	private String Programer;
	
	@JsonProperty("Vrijeme")
	private String Vrijeme;
	
	@JsonProperty("Tip")
	private String Tip;
	
	@JsonProperty("Roditelji")
	private String Roditelji;
	
}
