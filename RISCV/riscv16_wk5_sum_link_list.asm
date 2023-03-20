.data
n01:	.word 1, n02
n04:	.word 4, 0
n02:	.word 2, n03
n03:	.word 3, n04
lista:	.word n01
.text #Counts length of list
	lw s0, lista #Loads head of list into s0
	ori a7, zero, 1  #instruction to print
	li a0, 0#loads initial sum of list to a0
	beq s0, zero, fine #if the list has no body branch to end
ciclo:	lw t0, 0(s0) #loads next section of list to t0
	lw s0, 4(s0) #loads next address to s0
	add a0, a0, t0 #adds t0 to sum of list
	bne s0, zero, ciclo #if next address isNT 0, start loop
fine:	ecall
	ori a7, zero, 10
	ecall
