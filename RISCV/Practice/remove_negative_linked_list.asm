.data
lista:	.word n01
n01:	.word 5, n02
n02:	.word 5, n03
n03:	.word 5, n04
n04:	.word 5, n05
n05:	.word 5, 0

.text
	lw a0, lista
	jal ra, denegger
	
	li a7, 1
	ecall
	
	li a7, 10
	ecall
	
	denegger:
		lw a1, 4(a0)
		bne zero, a1, ricursion
		jalr zero, ra, 0
		
		ricursion:
			addi sp, sp, -8
			sw ra, 0(sp)
			sw a1, -4(sp)
			lw a0, 4(a0)
			jal ra, denegger
			addi sp, sp, 8
			lw ra, 0(sp)
			jalr zero, ra, 0