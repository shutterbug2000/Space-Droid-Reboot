package com.shutterbug.anemu.cpucomponents;

public abstract class Dynarec extends CPU
{
	//TODO: Learn more about the working of a dynarec, and what else needs to be implemented.
	public abstract void recompileRun(int opcode);
}
