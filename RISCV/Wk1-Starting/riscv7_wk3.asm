.data #0x10010
	.word 4	#n, number of fib numbers
.text # PRINT THE FIRST N FIBONACCI NUMBERS USING THE WORST POSSIBLE METHOD	0 1 1 2 3 5 8
	lui s0, 0x10010
	lw t2, 0(s0) #loads n
	ori a7, zero, 1 #loads ecall instruction to print
	ori t0, zero, 0 #sets first fib number to 0
	ori t1, zero, 1 # sets second fib number to 1
	or a0, zero, zero
	ecall #prints zero
	beq t1, t2, terminate
	addi t2, t2, -1 #iterates the counter forwards
	add a0, t0, t1 #loads next fib number into print slot
	ecall #prints next fib number
	addi t2, t2, -1
	addi t3, zero, 1
	beq t3, t2, terminate
loop:	add a0, t0, t1 #loads next fib number into print slot
	ecall #prints next fib number
	or t0, zero, t1 #sets old fib
	or t1, zero, a0 #sets newer fib
	addi t2, t2, -1 #iterates counter downwards
	bne t2, zero, loop
terminate: #ends program