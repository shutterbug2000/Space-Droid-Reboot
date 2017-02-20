package com.shutterbug.anemu.cpucomponents;
import java.io.*;
import android.widget.*;
import android.app.*;
import android.util.*;
import com.shutterbug.anemu.*;
import com.shutterbug.anemu.cpucomponents.opcodes.*;

public class I8080CPU extends CPU
{

	byte[] memory = new byte[0x4000];
	public char pc;
	//char 
	
	@Override
	public void createCPU()
	{
		// TODO: Implement this method
		// For space invaders:
		pc = 0;
	}

	@Override
	public void run()
	{
		// TODO: Fully implement this method
		char opcode = (char)memory[pc];
		switch(opcode){
			case 0x00:{
				//NOP
				NOP nop = new NOP();
				nop.execute(this);
				break;
			}
			default:{
				//Log.d("unknown opcode",Byte.toString(opcode));
				MyGdxGame.opcode = Integer.toHexString(opcode);
				MyGdxGame.pause = true;
				//System.exit(1);
			}
		}
	}

	@Override
	public void loadProgram()
	{
		try
		{
			FileInputStream e = new FileInputStream("/sdcard/inv.h");
			FileInputStream f = new FileInputStream("/sdcard/inv.g");
			FileInputStream g = new FileInputStream("/sdcard/inv.f");
			FileInputStream h = new FileInputStream("/sdcard/inv.e");
			try
			{
				e.read(memory, 0, 0x7ff);
				f.read(memory, 0x800,0x7ff);
				g.read(memory, 0x1000,0x7ff);
				h.read(memory, 0x1800,0x7ff);
			}
			catch (IOException err)
			{
				//Toast t = new Toast(gdxToast.context); //TODO: Make this work... somehow?
				Toast.makeText(gdxToast.context, err.toString(), Toast.LENGTH_SHORT).show(); 
				err.printStackTrace();
				System.exit(1);
			}
		}
		catch (FileNotFoundException err)
		{
			err.printStackTrace();
			Toast.makeText(gdxToast.context, err.toString(), Toast.LENGTH_SHORT).show();
			System.exit(1);
		}
	}
	
	
}
