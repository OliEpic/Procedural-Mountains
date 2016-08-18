package com.madpixelgames.main;

import java.util.Random;

public class Stars {
	
	Random r;
	
	int numStars = 20;
	int[][] stars = new int[numStars][2];
	
	public Stars() {
		
		r = new Random();
		
		for (int i = 0; i < numStars; i ++) {
			
			int x = r.nextInt(640);
			int y = r.nextInt(480);
			
			stars[i][0] = x;
			stars[i][1] = y;
			
		}
		
	}
	
	public int[][] getStars() {
		
		return stars;
		
	}

}
