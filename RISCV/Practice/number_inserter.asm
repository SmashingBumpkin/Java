# take an array. Add a number, x, to it, and rearrange so that [arr < x, x, arr >= x] 
.data
len:	.word	5
arr:	.word 4,1,2,3,6
val:	.word 3 #oputput should be eg 1,2,3,3,4,6

.text
	lw a2, val
	jal ra, func
	
func:	
	mv t0, a0
	mv t1, a1
	slli t1, t1, 2
	add t0, t0, t1
ciclo:	lw t2, 0(a4)
	bge t2, a2, salta
	addi a0, a0, 4
	beq zero, zero,  fine
salta:	addi t0, t0, -4
	lw t3, 0(t0) 
	sw t3, 0(a0)
	sw t2, 0(t0)
fine:	bne a0, t0, ciclo
	jalr zero, ra, 0