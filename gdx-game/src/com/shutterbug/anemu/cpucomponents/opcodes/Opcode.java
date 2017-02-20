package com.shutterbug.anemu.cpucomponents.opcodes;
import com.shutterbug.anemu.cpucomponents.*;

public abstract class Opcode
{
	public abstract void execute(I8080CPU i8080);
}
