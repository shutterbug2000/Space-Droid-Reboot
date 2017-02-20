package com.shutterbug.anemu.cpucomponents.opcodes;
import com.shutterbug.anemu.cpucomponents.*;

public class NOP extends Opcode
{

	@Override
	public void execute(I8080CPU i8080)
	{
		// TODO: Implement this method
		i8080.pc += 1;
	}
	
}
