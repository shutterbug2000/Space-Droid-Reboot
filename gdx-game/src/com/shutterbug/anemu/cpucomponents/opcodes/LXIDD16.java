package com.shutterbug.anemu.cpucomponents.opcodes;
import com.shutterbug.anemu.cpucomponents.*;

public class LXIDD16 extends Opcode
{

	@Override
	public void execute(I8080CPU i8080)
	{
		// TODO: Implement this method
		i8080.registers[REGISTER.D.ordinal()] = i8080.memory[i8080.pc+2];
		i8080.registers[REGISTER.E.ordinal()] = i8080.memory[i8080.pc+1];
		i8080.pc+=3;
	}
	
}
