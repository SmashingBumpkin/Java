#Build a function that takes an array and arranges it in a way that that the
#first item is the minimum

.data
len:	.word 	6
arr:	.word	1,2,3,4,0,6

.text
	lw s1, len
	la, s0, arr
ciclo1:	mv a1, s1
	mv a0, s0
	jal ra, min
	addi s0, s0, 4
	addi s1, s1, -1
	bne s1, s2, ciclo1
	
	li a7, 1
	lw a0, arr
	ecall
	la a1, arr
	lw a0, 4(a1)
	ecall
	li a7, 10
	ecall
	
	
min:
	mv t0, a0
	lw a2, 0(a0)
	addi t0, t0, 4
	addi a1, a1, -1
ciclo:	ble a1, zero, fine
	lw t1, 0(t0)
	bge t1, a2, salta
	sw t1, 0(a0)
	sw a2, 0(t0)
	mv a2, t1
salta:	addi t0, t0, 4
	addi a1, a1, -1
	beq zero, zero, ciclo
fine:	jalr, ra, 0