package com.madpixelgames.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Main extends ApplicationAdapter {
	
	SpriteBatch batch;
	Stars starclass;
	MountainRange mountainclass;
	Texture starimg;
	Texture title;
	ShapeRenderer renderer;
	
	int[][] stars;
	int[][] mountains;
	
	@Override
	public void create () {
	
		batch = new SpriteBatch();
		starclass = new Stars();
		mountainclass = new MountainRange();
		starimg = new Texture("star.png");
		title = new Texture("title.png");
		renderer = new ShapeRenderer();
		
		stars = starclass.getStars();
		mountains = mountainclass.getMountains();
	
	}

	@Override
	public void render () {
	
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		
		for (int i = 0; i < starclass.numStars; i++) {
			
			batch.draw(starimg, stars[i][0], stars[i][1]);
			
		}
		
		batch.end();
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
		
		renderer.begin(ShapeType.Filled);
		
		renderer.setColor(Color.DARK_GRAY);
		renderer.triangle(0, 0, 100, 100, 100, 0);
		
		for (int i = 0; i < mountainclass.numLines; i++) {
			
			if (i == 0) {
				
				renderer.triangle(100, 100, mountains[i][0], mountains[i][1], mountains[i][0], 0);
				renderer.triangle(100, 100, 100, 0, mountains[i][0], 0);
				
			} else {
				
				renderer.triangle(mountains[i - 1][0], mountains[i-1][1], mountains[i][0], mountains[i][1], mountains[i][0], 0);
				renderer.triangle(mountains[i - 1][0], mountains[i-1][1], mountains[i-1][1], 0, mountains[i][0], 0);
				
			}
			
		}
		
		renderer.end();
		
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		batch.begin();
		
		batch.draw(title, 0, 0);
		
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Keys.F5)) {
			
			starclass = new Stars();
			stars = starclass.getStars();
			mountainclass = new MountainRange();
			mountains = mountainclass.getMountains();
			
		}
	
	}

}
