package com.shutterbug.anemu;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.shutterbug.anemu.cpucomponents.*;
import android.os.*;

public class MyGdxGame implements ApplicationListener
{
	BitmapFont font;
	public static String opcode="";
	public static boolean pause = false;
	Texture texture;
	SpriteBatch batch;
	I8080CPU i8080;
	
	@Override
	public void create()
	{
		Looper.prepare();
		texture = new Texture(Gdx.files.internal("android.jpg"));
		batch = new SpriteBatch();
		i8080 = new I8080CPU();
		i8080.createCPU();
		i8080.loadProgram();
		font = new BitmapFont();
		font.setScale(5);
		font.setColor(Color.CYAN);
	}

	@Override
	public void render()
	{        
	i8080.run();
	    Gdx.gl.glClearColor(1,1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
				   font.draw(batch,opcode,100,100);
		batch.end();
		while(pause){
		
		}
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
