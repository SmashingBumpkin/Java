.data
head:	.word n01
n01:	.word 5, n02
n02:	.word 10, n03
n05:	.word 0,0
n03:	.word 12, n04
n04:	.word 10, n05

.text
	lw a0, head
	jal ra, counter
	
	ori a7, zero, 1
	ecall
	
	ori a7, zero, 10
	ecall	
	
counter:
	bne a0, zero, ricursion
	jalr zero, ra, 0
	
ricursion:
	addi sp, sp, -4 #moves stack pointer down by 4
	sw ra, 0(sp) #saves current return address to the stack
	lw a0, 4(a0) #loads next address to a0
	jal ra, counter
	addi a0, a0, 1
	lw ra, 0(sp)
	addi sp, sp, 4
	jalr zero, ra, 0
	