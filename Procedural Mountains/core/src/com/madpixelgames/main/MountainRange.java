package com.madpixelgames.main;

import java.util.Random;

public class MountainRange {
	
	Random r;
	
	int numLines = 20;
	int[][] lastpos = new int[2][2];
	int[][] mountains = new int[numLines][2];
	
	public MountainRange() {
		
		r = new Random();
		
		lastpos[0][0] = 0;
		lastpos[0][1] = 0;
		lastpos[1][0] = 100;
		lastpos[1][1] = 100;
		
		for (int i = 0; i < numLines; i++) {
			
			boolean positive = r.nextBoolean();
			
			int endpointX = 0, endpointY = 0;
			
			if (positive) {
				
				endpointX = lastpos[1][0] + r.nextInt(100);
				endpointY = lastpos[1][1] + r.nextInt(100);
				
			} else {
				
				endpointX = lastpos[1][0] + r.nextInt(100);
				
				while (endpointY < 100) {
				
					endpointY = lastpos[1][1] - r.nextInt(100);
				
				}
				
			}
			
			lastpos[0][0] = lastpos[1][0];
			lastpos[0][1] = lastpos[1][1];
			lastpos[1][0] = endpointX;
			lastpos[1][1] = endpointY;
			
			mountains[i][0] = endpointX;
			mountains[i][1] = endpointY;
			
		}
		
	}
	
	public int[][] getMountains() {
		
		return mountains;
	
	}

}
