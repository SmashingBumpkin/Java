.data #ARRAYS:
#[ 4  -1   5 ]
#[ 0,  1  -3 ]
#2x2 array

n: 	.word 2 #number of rows
m: 	.word 3 #number of columns
myarr:	.word 4, -1, 5, 0, 1, -3

.text #sum all the elements in an array
	la s0, myarr
	ori a0, zero, 0
	lw a2, n
	lw a3, m
	mul a2, a2, a3
loop:	lw a1, 0(s0)
	add a0, a0, a1
	addi s0, s0, 4
	addi a2, a2, -1
	bne zero, a2, loop
	ori a7, zero, 1
	ecall
	ori a7, zero, 10
	ecall