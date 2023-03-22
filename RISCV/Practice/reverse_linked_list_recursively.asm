.data
lista:	.word modo1
modo1:	.word 2, modo2
modo4:	.word 5, 0
modo2:	.word 3, modo3
modo3:	.word 5, modo4

.text
	lw a0, lista
	jal inverti
	li a7, 1
	ecall
	li a7, 10
	ecall
#Inverts a list (ie returning the backwards list)
inverti:	
	bne zero, a0, base2 #checks if the list has length 0
	jalr zero, ra, 0
		
base2:
	lw t0, 4(a0) #checks if the list has length 1
	bne t0, zero, ric
	jalr zero, ra, 0
	
	ric:
		addi sp, sp, -8
		sw ra, 0(sp)
		sw a0, 4(sp)
		lw a0, 4(a0)
		jal ra, inverti
		lw t0, 4(sp)
		lw t1, 4(t0)
		sw t0, 4(t1)
		sw zero, 4(t0)
		lw ra, 0(sp)
		addi sp, sp, 8
		jalr zero, ra, 0