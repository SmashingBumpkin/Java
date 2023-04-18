.data
	.word 0
	.asciz "Zero"
	.asciz "Non-zero"
	
.text
	lui s0, 0x10010
	lw t0, 0(s0)
	beq t0, zero, print
	addi a0, s0, 9
	li a7, 4
	ecall
	li a7, 10
	ecall
print:
	addi a0, s0, 4
	li a7, 4
	ecall
	li a7, 10
	ecall