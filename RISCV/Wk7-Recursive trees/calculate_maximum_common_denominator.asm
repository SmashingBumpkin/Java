.data
x:	.word 54
y:	.word 36

#COmpute the MCDz nutz 
#Maximum common divisor
.text
	lw a0, x
	lw a1, y
	beq a1, zero, end
ciclo:	or a2, a1, zero	
	sub a1, a0, a1
	ori a0, a2, 0
	bne a1, zero, ciclo
end:	ori a7, zero, 1
	ecall
	ori a7, zero, 10
	ecall