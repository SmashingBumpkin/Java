.data
n01:	.word 1, n02
n04:	.word 20, 0
n02:	.word 2, n03
n03:	.word 3, n04
lista:	.word n01

.text	#FUNCTION TO FIND MAX VALUE FROM A LIST RECURSIVELY
	lw a0, lista #loads head into a0
	li t1, 0
	jal ra, maxfunc #Jumps to max finder program
	
	ori a0, t2, 0
	li a7, 1
	ecall
	
	li a7, 10
	ecall
	
	maxfunc:
		bne zero, a0, loop #goes to loop if not at end of list 
		jalr zero, ra, 0
	
	loop:
		addi sp, sp -4 #move stack pointer down by 4
		sw ra, 0(sp) #changes current return address to be used for jump
		lw t2, 0(a0)
		bgt t2, t1, maxupdater
returnPosn:	lw a0, 4(a0)
		jal, ra, maxfunc
		lw ra, 0(sp) #loads return address from data at stack pointer
		addi sp, sp, 4 #iterates stack pointer up by 4
		jalr zero, ra, 0
		
	maxupdater:
		ori t1, t2, 0
		b returnPosn