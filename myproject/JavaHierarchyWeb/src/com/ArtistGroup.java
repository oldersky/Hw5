package com;

public class ArtistGroup {
	public final static int numberOfGroups = 4;
	public String[] groupName = new String[numberOfGroups];
	public int[] numberOfFans;
	public int[] numberOfPoi; 
	public int[] numberOfStaff;
	public int[] numberOfRope;
	public int[] priceOfMinute;
	
	public ArtistGroup() {
		final int numberOfGroups = 4;
		numberOfFans = new int[numberOfGroups];
		numberOfPoi = new int[numberOfGroups]; 
		numberOfStaff = new int[numberOfGroups];
		numberOfRope = new int[numberOfGroups];
		priceOfMinute = new int[numberOfGroups];
		
		groupName[0] = "Wind Theater";
		groupName[1] = "Prana";
		groupName[2] = "Fire";
		groupName[3] = "Magic 8";
		
		numberOfFans[0] = 1;
		numberOfFans[1] = 3;
		numberOfFans[2] = 0;
		numberOfFans[3] = 2;
		
		numberOfPoi[0] = 0;
		numberOfPoi[1] = 2;
		numberOfPoi[2] = 2;
		numberOfPoi[3] = 3;
		
		numberOfStaff[0] = 2;
		numberOfStaff[1] = 1;
		numberOfStaff[2] = 2;
		numberOfStaff[3] = 0;
		
		numberOfRope[0] = 0;
		numberOfRope[1] = 1;
		numberOfRope[2] = 0;
		numberOfRope[3] = 1;
		
		for (int i = 0; i < numberOfGroups; i++) {
			priceOfMinute[i] = numberOfFans[i] * 200 + numberOfPoi[i] * 100 +
					numberOfStaff[i] * 250 + numberOfRope[i] * 300;
			
		}
	}
	
	public boolean enoughArtists(int number,  int fansNum, int poiNum, 
			int staffNum, int ropeNum) {
		if ((this.numberOfFans[number] >= fansNum) && (this.numberOfPoi[number] >= poiNum) &&
				(this.numberOfStaff[number] >= staffNum) && (this.numberOfRope[number] >= ropeNum)) {
			return true;
		} else {
			return false;
		}
	}
}
