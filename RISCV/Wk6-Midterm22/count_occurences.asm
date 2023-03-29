.data 
n:	.word 9
v:	.word 5,8,-3,0,1,1,7,2,80
x:	.word 10
y:	.word 80

.text #count the number of items of v that are equal to x or y
	lui s0, 0x10010
	ori a0, a0, 0 #a0 = # of y or x
	lw a1, 0(s0) #a1 = n
	lw a2, x #a2 = x
	lw a3, y #a3 = y
	la s0, v #loads current address to a5
loop:	lw a4, 0(s0) #loads current item to a4
	bne a4, a2, noteqx
	addi a0, a0, 1
noteqx:	bne a4, a3, noteqy
	addi a0, a0, 1
noteqy:	addi a1, a1, -1 #iterates the pointer and length counter
	addi s0, s0, 4
	bne a1, zero, loop
	ori a7, zero, 1
	ecall
	ori a7, zero, 10
	ecall
	