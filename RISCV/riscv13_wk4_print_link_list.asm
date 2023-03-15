.data
n01:	.word 7, n02
n04:	.word 8, 0
n02:	.word 11, n03
n03:	.word -2, n04
lista:	.word n01
.text #Prints all numbers in the list
	#lui s0, 0x10010
	#lw s0, 0x20 (s0) #loads lista (pointer to start of list) into s1
	lw s0, lista #Does the same thing as the above two lines, but is easier
	ori a7, zero 1
notzero:lw a0, 0(s0) #loads number of list to a0
	lw s0, 4(s0) #loads next address to s0
	ecall
	bne zero, s0, notzero
	ori a7, zero, 10
	ecall