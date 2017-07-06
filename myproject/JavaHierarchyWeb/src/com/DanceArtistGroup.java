package com;

public class DanceArtistGroup {
	public int numberOfGroups = 4;
	public String[] groupName;
	public int[] numberOfDancers;
	public int[] priceBorder;
	public int lowPrice = 15000, highPrice = 25000;
	
	public DanceArtistGroup() {

		groupName = new String[numberOfGroups];
		numberOfDancers = new int[numberOfGroups];
		priceBorder = new int[numberOfGroups];
						 
		groupName[0] = "Plastica";
		groupName[1] = "let's Dance";
		groupName[2] = "Come Together";
		groupName[3] = "MagicDance";
		
		numberOfDancers[0] = 10;
		numberOfDancers[1] = 12;
		numberOfDancers[2] = 9;
		numberOfDancers[3] = 15;
		
		priceBorder[0] = 5;
		priceBorder[1] = 7;
		priceBorder[2] = 4;
		priceBorder[3] = 8;
	}
	
	public boolean enougArtists(int number, int numberOfDancers) {
		if (this.numberOfDancers[number] >= numberOfDancers) {
			return true;
		} else {
			return false;
		}
	}
	
	public int cost(int number, int numberOfDancers) {
		if (numberOfDancers <= this.priceBorder[number]) {
			return lowPrice;
		} else {
			return highPrice;
		}
	}
}
