package com.shutterbug.anemu.cpucomponents.opcodes;
import com.shutterbug.anemu.cpucomponents.*;

public class INXD extends Opcode
{

	@Override
	public void execute(I8080CPU i8080)
	{
		// TODO: Implement this method
		char DE = (char)((i8080.registers[REGISTER.D.ordinal()+2])<< 8 | (i8080.registers[REGISTER.E.ordinal()]));
		DE += 1;
		i8080.registers[REGISTER.D.ordinal()] = (char)(DE >> 8);
		i8080.registers[REGISTER.E.ordinal()] = (char)(DE & 0xFF);
		i8080.pc += 2;
	}
	
}
