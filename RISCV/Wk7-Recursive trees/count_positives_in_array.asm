.data
n:	.word 6
x:	.word 5, 8, 6, -2, -1, 8
.text #sum of positive items of x
	lui s0, 0x10010
	ori a0, zero, 0
	lw a1, 0(s0) #length
	beq a1, zero, end
ciclo:	addi s0, s0, 4
 	addi a1, a1, -1
 	lw a2, 0(s0)
 	blt a2, zero, skip
 	addi a0, a0, 1
skip:	bne a1, zero, ciclo
end:	ori a7, zero, 1
	ecall
	ori a7, zero, 10
	ecall