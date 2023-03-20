.data
n01:	.word 1, n02
n04:	.word 20, 0
n02:	.word 2, n03
n03:	.word 3, n04
lista:	.word n01

.text 
	#Counts length of list recursively
	lw a0, lista #loads head into a0
	ori t2, zero, 0
	li, a7, 1
	jal ra, somma #loads current instruction address to ra, then jumps to somma
	
	#printin result
	or a0, zero, t2
	ecall
	
	#terminate
	li a7, 10
	ecall
	
	somma:
		bne a0, zero, ric #base case, if the next address isn't 0, jump forward
		#if it is zero, then continue
		jalr zero, ra, 0 #returns to old position (just after jal ra, somma)

	ric:	
		addi sp, sp, -4 #moves stack pointer down by 8 since we are recursing
		sw ra, 0(sp) #saves current return address to stack pointer
		lw t0, 0(a0) #loads the integer from the list
		add t2, t0, t2 #adds to running total
		lw a0, 4(a0) #loads the next address from the list
		jal ra, somma #Jumps back to somma and updates return address
		lw ra, 0(sp) #loads return address from data at stack pointer
		addi sp, sp, 4 #iterates stack pointer up by 8
		jalr zero, ra, 0 #jumps back to where it was (either under jal ra, somma, or back up to line 13