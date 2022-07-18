package com.example.mdbspringboot.model;

public class GroceryLabel {

	private String label;
	private String colour;

	public GroceryLabel(String label, String colour) {
		this.label = label;
		this.colour = colour;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
	
}
