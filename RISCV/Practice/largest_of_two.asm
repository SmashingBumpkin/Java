.data
lista:	.word  11, 6
.text
	lui s0, 0x10010
	lw t0, 0(s0)
	lw t1, 4(s0)
	li a7, 1
	ble t1, t0, prt1
	ori a0, t1, 0
	ecall	
	b end
prt1:	ori a0, t0, 0
	ecall
end:	ori a7, zero, 10
	ecall