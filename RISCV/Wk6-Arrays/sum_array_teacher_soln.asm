.data #ARRAYS:
#[ 4  -1   5 ]
#[ 0,  1  -3 ]
#2x2 array

n: 	.word 3 #number of rows
m: 	.word 3 #number of columns
myarr:	.word 4,-1,5,  0,1,-3,  1,2,3

.text #sum all the elements in an array
	la s0, myarr
	ori a0, zero, 0
	lw s1, n
	add s3, s1, zero
ciclo1:	lw s2, m
	bne s2, s3, end
ciclo2:	lw t0, 0(s0)
	bne s2, s1, skip
	add a0, a0, t0
skip:	addi s0, s0, 4
	addi s2, s2, -1
	bne zero, s2, ciclo2
	addi s1, s1, -1
	bne s1, zero, ciclo1
	li a7, 1
	ecall
end:	ori a7, zero, 10
	ecall