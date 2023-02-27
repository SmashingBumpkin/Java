#.data # By default starts at address 0x10010000
#	.asciz "ACSAI is ok i guess"
#	
#.text
#	lui s0, 0x10010
#	ori a0, s0, 0x00 #stores address of .asciz "zero"
#	addi t0, zero, 0 # sets counter to 0
#loopy:  addi t0, t0, 1 # increments counter by 1
#	lb t1, t0(a0) #loads contents of address a0 to t1
#	bne t0, zero, loopy #assert if t1 is equal to "0", if it's not loop
#	add a0, s0, t0 #moves the pointer forward just past the string
#	sw t0, a0 #save contents of the counter, t0, to memory, a0
#	ecall #print contents of memory @ a0 with ecall
	
.data # By default starts at address 0x10010000
	.asciz "ACSAI is ok i guess"
	
.text
	lui s0, 0x10010
	addi a0, zero, 0 # sets counter to 0
loopy:	lb t0, 0(s0) # loads first byte of string
	beq t0, zero, fine
	addi a0, a0, 1 # increments counter by 1
	addi s0, s0, 1 # increments address by 1
	beq zero, zero, loopy
fine:	ori a7, zero, 1 #moves the pointer forward just past the string
	ecall #print contents of memory @ a0 with ecall
		