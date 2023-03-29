.data #0x10010
	.word 5	#i, number to be factorialized
.text # Implement a function that calculates the factorial of a number
	lui s0, 0x10010 #gets start of memory into s0
	lw a0, 0(s0) #loads number at word to a0 (ready for printing)
	or t1, zero, a0 # loads a0 into t1 (which will be what we multiple the running total by)
	ori t2, t2, 1 #loads 1 (the last number) to t2
loop:	addi t1, t1, -1 #iterates t1 downwards
	mul a0, a0, t1 # multiplies running total by t1
	bne t1, t2, loop # loop unless t1 == 1
	ori a7, zero, 1 #loads instruction to print
	ecall #follows instruction and data