.data
lista:	.word modo1
modo1:	.word 2, modo2
modo4:	.word 5, 0
modo2:	.word 3, modo3
modo3:	.word 5, modo4

.text
	lw s0, lista
	li a0, 0
	beq s0, zero, end
loop:	lw t0, 0(s0)
	add a0, a0, t0
	lw s0, 4(s0)
	bne s0, zero, loop
end:	li a7, 1
	ecall
	li a7, 10
	ecall