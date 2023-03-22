.data
lista:	.word modo1
modo1:	.word 2, modo2
modo4:	.word 5, 0
modo2:	.word 3, modo3
modo3:	.word 5, modo4

.text
	lw a0, lista
	jal sommalista
	li a7, 1
	ecall
	li a7, 10
	ecall

sommalista:	
	bne zero, a0, ricurzione
	jalr zero, ra, 0
		
	ricurzione:
		addi sp, sp, -8
		sw ra, 0(sp)
		sw a0, 4(sp)
		lw a0, 4(a0)
		jal sommalista
		lw t0, 4(sp)
		lw t1, 0(t0)
		add a0, a0, t1
		lw ra, 0(sp)
		addi sp, sp, 8
		jalr zero, ra, 0