.data #ARRAYS:
#[ 4  -1   5 ]
#[ 0,  1  -3 ]
#2x2 array

n: 	.word 3 #number of rows
m: 	.word 3 #number of columns
myarr:	.word 4,-1,5,  0,1,-3,  1,2,3

.text #sum all the elements in an array
	la s0, myarr
	lw s1, n
	ori a0, zero, 0
	lw t2, m
	slli t2, t2, 2
	addi t2, t2, 4
ciclo:	lw t0, 0(s0)
	add a0, a0, t0
	add s0, s0, t2
	addi s1, s1, -1
	bne s1, zero, ciclo
	li a7, 1
	ecall
	ori a7, zero, 10
	ecall