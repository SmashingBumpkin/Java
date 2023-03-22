.data
x:	.word 6
n:	.word 5
y:	.word 1,2,3,4,5

.text	#Print 1 if x is in y, else 0
	lw t0, x
	lw t1, n
	li a7, 1
	la s0, y
	beq t1, zero, end
loop:	lw a0, 0(s0)
	beq a0, t0, win
	addi s0, s0, 4
	addi t1, t1, -1
	bne t1, zero, loop
	li a0, 0
end:	ecall#prints 1, branches to end
	li a7, 10
	ecall#ends the program

win:	li a0, 1
	b end