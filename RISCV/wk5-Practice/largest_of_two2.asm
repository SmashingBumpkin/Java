.data
x:	.word  6
y: 	.word 11
.text
	lw a0, x
	lw a1, y
	li a7, 1
	bgt a0, a1, prnt
	ori a0, a1, 0
prnt:	ecall
	ori a7, zero, 10
	ecall