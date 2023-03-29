.data #0x10010000
	.word 6
	.word 3,5,11,12,21,27
.text # Adds contents of array together
	lui s0, 0x10010
	lw t1, 0(s0) #loads length (remaining) from first position in array)
	and a0, zero, zero 
loopy:	addi t1, t1, -1 #decrement length remaining by 1
	addi s0, s0, 4#increment point forward by 4
	lw t2, 0(s0)#load data from next address to t2
	add a0, a0, t2 #sum loaded data to a0
	bne t1, zero, loopy # loop unless the length remaining has gotten to zero
	ori a7, zero, 1 #Instructions telling the computer to print what's in a0. It automatically looks for instructions in a7
	ecall #understands the instruction at a7 to print contents of memory @ a0 with ecall
	ori a7, zero, 10 #exits the program
	ecall #Does instruction above
	