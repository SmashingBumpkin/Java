.data
head:	.word n01
n01:	.word 500, n02
n02:	.word 10, n03
n05:	.word 10,0
n03:	.word 12, n04
n04:	.word 60, n05
.text
	lw a0, head
	ori a7, zero, 1
	jal ra, maximus
	
	ecall
	
	ori a7, zero, 10
	ecall
	
maximus:
	bne a0, zero, ric
	jalr zero, ra, 0
	
	ric:
		addi sp, sp, -8
		sw ra, 0(sp)
		lw a1, 0(a0)
		sw a1, 4(sp)
		lw a0, 4(a0)
		jal ra, maximus
		addi sp, sp, 8
		lw ra, 0(sp)
		lw a1, 4(sp)
		bgt a0, a1, skip
		ori a0, a1, 0
	skip:	jalr zero, ra, 0
		
