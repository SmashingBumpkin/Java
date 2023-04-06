.data
albero:	.word n01
n01:	.word 6, n02, 0
n02:	.word	-2, 0, n03
n03:	.word	1, n05, n04
n04:	.word 1, 0, 0
n05:	.word 5, 0, n06
n06:	.word 8, 0, n07
n07:	.word 11, 0, n08
n08:	.word -1, 0, 0
.text
	la a0, albero
	jal a0, counter
	
	li a7, 1
	ecall
	
	li a7, 10
	ecall

counter:
	bne a0, zero, ricursion
	jalr zero, ra, 0
	
ricursion:
	addi sp, sp, -12 #moves counter down by 12 since there are up to 3 pieces of data to save
	sw ra, 0(sp)
	sw a0, 4(sp)
	lw a0, 4(a0)
	jalr ra, counter
	sw a0, 8(sp)
	lw a0, 4(sp)
	lw a0, 8(a0) #loads rest of siblings
	jalr ra, counter
	lw t0, 8(sp)
	add a0, a0, t0
	addi a0, a0, 1
	ra 0(sp)
	addi sp, sp, 12
	jalr zero, ra,0 