package com;

public class SingGroupArtist {
	public int numberOfSingers = 4;
	public String[] groupName;
	public int[] priceOfSongs;
	
	public SingGroupArtist() {
		
		groupName =  new String[numberOfSingers];
		priceOfSongs = new int[numberOfSingers];
		
		groupName[0] = "Cake";
		groupName[1] = "Marco Polo";
		groupName[2] = "Sing4Free";
		groupName[3] = "DDT";
		
		priceOfSongs[0] = 1000;
		priceOfSongs[1] = 1500;
		priceOfSongs[2] = 700;
		priceOfSongs[3] = 3000;
	}
}
