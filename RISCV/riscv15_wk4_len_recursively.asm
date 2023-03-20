.data
n01:	.word 7, n02
n04:	.word 8, n05
n02:	.word 11, n03
n03:	.word -2, n04
n05:	.word 8, 0
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
		jalr zero, ra, 0 #returns to old position

	ric:	
		addi sp, sp, -4 #moves stack pointer down by 4 since we are recursing
		sw ra, 0(sp) #saves current return address to stack pointer
		lw a0, 4(a0) #loads data from underneath stack pointer (the next item from the list)
		jal ra, lunghza #Jumps back to lunghezza and updates return address
		addi a0, a0, 1 #adds 1 to length counter
		lw ra, 0(sp) #loads return address from data at stack pointer
		addi sp, sp, 4 #iterates stack pointer up by 4
		jalr zero, ra, 0 #returns to current return address
