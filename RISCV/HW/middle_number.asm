.text 
	lui x1, 0x10010
	lw x2, 0(x1) #a
	lw x3, 4(x1) #b
	lw x4, 8(x1) #c
	ori x5, zero, 0 #ab
	ori x6, zero, 0 #ac
	ori x7, zero, 0 #bc
	ori a7, zero, 1
	blt x2, x3, aLTb
	addi x5, x5, 1
aLTb: 	blt x2, x4, aLTc
	addi x6, x6, 1
aLTc: 	beq x5, x6, nota
	or a0, zero, x2
	beq zero, zero, fine
nota: 	blt x3, x4, bLTc
	addi x7, x7, 1
bLTc: 	beq x5, x7, notc
	or a0, zero, x4
	beq zero, zero, fine
notc: 	or a0, zero, x3
fine: 	ecall
	ori a7, zero, 10
	ecall