#load a number x from memory, create an array at address y with x//2, x and x*2 

.data
x:	.word 9
addy:	.word 0x10010010

.text
	lw a0, x
	lw s0, addy
	srli a1, a0, 1
	slli a2, a0, 1
	sw a1, 0(s0)
	sw a0, 4(s0)
	sw a2, 8(s0)
	
	li a7, 1
	lw a0, 0(s0)
	ecall
	lw a0, 4(s0)
	ecall
	lw a0, 8(s0)
	ecall