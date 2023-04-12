.data
head:	.word n1
n1:	.word 5, n2
n2:	.word 3, n3
n3:	.word 1, n4
n4:	.word 16, 0

.text
	lw a0, head
	li a7, 1
	jal ra, printer
	
	li a7, 10
	ecall
	
	printer:
		bne a0, zero, ricursion
		jalr zero, ra, 0
		
		ricursion:
			addi sp, sp, -8
			sw ra, 0(sp)
			lw a1, 0(a0)
			sw a1, 4(sp)
			lw a0, 4(a0)
			jal ra, printer
			lw a0, 4(sp)
			ecall
			lw ra, 0(sp)
			addi sp, sp, 8
			jalr zero, ra, 0