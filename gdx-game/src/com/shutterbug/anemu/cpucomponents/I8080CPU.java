package com.shutterbug.anemu.cpucomponents;
import java.io.*;
import android.widget.*;
import android.app.*;
import android.util.*;
import com.shutterbug.anemu.*;
import com.shutterbug.anemu.cpucomponents.opcodes.*;
import java.lang.reflect.*;

public class I8080CPU extends CPU
{

	public char[] memory = new char[0x4000];
	public char pc;
	public char[] registers = new char[7];
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
		char opcode = memory[pc];
		switch(memory[pc]){
			case 0x00:{
				//NOP
				NOP nop = new NOP();
				nop.execute(this);
				break;
			}
			case 0x06:{

			
				MVIBD8 mvibd8 = new MVIBD8();
				mvibd8.execute(this);
			
			break;
			}
			case 0xC3:{
				//JMP adr
				JMP jmp = new JMP();
				jmp.execute(this);
			
			break;
			}
			default:{
				Log.d("unknown opcode",Integer.toHexString((int)opcode)); //umm ok
				MyGdxGame.opcode = Integer.toHexString(opcode);
				MyGdxGame.pause = true;
				//System.exit(1);
			}
		}
	}

	
	@Override
	public void loadProgram(){

	DataInputStream input = null;
	int i;
	try {
		input = new DataInputStream(new FileInputStream(new File("/sdcard/inv.h")));

		int offset = 0;
		for(i = 0; i < 0x7ff; i++){
			memory[i] = (char)(input.readByte() & 0xFF);
			offset++;
		}

	} catch (IOException e) {
		e.printStackTrace();
		System.exit(0);
	} finally {
		if(input != null) {
			try { input.close(); } catch (IOException ex) {}
		}
	}

	try {
		input = new DataInputStream(new FileInputStream(new File("/sdcard/inv.g")));

		int offset = 0;
		for(i = 0x7FF; i < (0x7ff * 2); i++){
			memory[i] = (char)(input.readByte() & 0xFF);
			offset++;
		}

	} catch (IOException e) {
		e.printStackTrace();
		System.exit(0);
	} finally {
		if(input != null) {
			try { input.close(); } catch (IOException ex) {}
		}
	}

	try {
		input = new DataInputStream(new FileInputStream(new File("/sdcard/inv.f")));

		int offset = 0;
		for(i = (0x7ff * 2); i < (0x7ff * 3); i++){
			memory[i] = (char)(input.readByte() & 0xFF);
			offset++;
		}

	} catch (IOException e) {
		e.printStackTrace();
		System.exit(0);
	} finally {
		if(input != null) {
			try { input.close(); } catch (IOException ex) {}
		}
	}

	try {
		input = new DataInputStream(new FileInputStream(new File("/sdcard/inv.e")));

		int offset = 0;
		for(i = (0x7ff * 3); i < (0x7ff * 4); i++){
			memory[i] = (char)(input.readByte() & 0xFF);
			offset++;
		}

	} catch (IOException e) {
		e.printStackTrace();
		System.exit(0);
	} finally {
		if(input != null) {
			try { input.close(); } catch (IOException ex) {}
		}
	}
	}
	
	/*@Override
	public void loadProgram2()
	{
		try
		{
			FileInputStream e = new FileInputStream("/sdcard/inv.h");
			FileInputStream f = new FileInputStream("/sdcard/inv.g");
			FileInputStream g = new FileInputStream("/sdcard/inv.f");
			FileInputStream h = new FileInputStream("/sdcard/inv.e");
			try
			{
				//e.read(memory, 0, 0x7f;
				for(int i = 0; i < 0x7ff; i++){
					memory[i] = (char)(e.readByte() & 0xFF);
					offset++;
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
	}*/
	
	
}
