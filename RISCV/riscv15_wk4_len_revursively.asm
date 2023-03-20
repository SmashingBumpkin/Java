.data
n01:	.word 7, n02
n04:	.word 8, 0
n02:	.word 11, n03
n03:	.word -2, n04
lista:	.word n01
.text 
	#Counts length of list recursively
	lw a0, lista #loads head into a0
	jal ra, lunghza #loads current instruction address to ra, then jumps to lunghza
	
	#printin result
	li, a7, 1
	ecall
	
	#terminate
	li a7, 10
	ecall
	
	lunghza:
		bne a0, zero, ric #base case, if length is 0 continue
		jalr zero, ra, 0 #
		


	ric:	
		addi sp, sp, -4
		sw ra, 0(sp)
		lw a0, 4(a0)
		jal ra, lunghza
		addi a0, a0, 1
		lw ra, 0(sp)
		addi sp, sp, 4
		jalr zero, ra, 0
