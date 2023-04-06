.data
head:	.word n01
n01:	.word 5, n02
n02:	.word 10, n03
n05:	.word 50,0
n03:	.word 12, n04
n04:	.word 10, n05
.text
	lw a0, head
	jal ra, somma
	
	ori a7, zero, 1
	ecall
	
	ori a7, zero, 10
	ecall

somma:
	bne a0, zero, ricursion
	jalr zero, ra, 0
	
	ricursion:
		addi sp, sp, -8
		sw ra, 0(sp)
		lw a1, 0(a0)
		sw a1, 4(sp)
		lw a0, 4(a0)
		jal ra, somma
		lw a1, 4(sp)
		lw ra, 0(sp)
		add a0, a0, a1
		addi sp, sp, 8
		jalr zero, ra, 0