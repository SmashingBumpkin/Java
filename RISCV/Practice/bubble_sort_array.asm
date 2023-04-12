#Bubble sort algorithm

.data
len:	.word 8
arr:	.word 1,76,3,2,7,2,-5,80

.text
	jal ra, bubbasort
	la s0, arr
	li a7, 1
	
	lw a1, len
lop:	lw a0, 0(s0)
	ecall
	addi s0, s0, 4
	addi a1, a1, -1
	bne a1, zero, lop
	
	li a7, 10
	ecall
	
	
	
bubbasort:
	lw a1, len #a1 = len
	addi a1, a1, -1
	beq a1, zero, end #if array is length one, terminate
otrlop:	or a0, a1, zero #store length
	la s0, arr
inrlop:	lw a2, 0(s0)
	lw a3, 4(s0)
	bgt a3, a2, skip
	sw a2, 4(s0) #swap
	sw a3, 0(s0) #values
skip:	addi s0, s0, 4
	addi a0, a0, -1
	bne a0, zero, inrlop
	addi a1, a1, -1
	bne a1, zero, otrlop
	
end:	jalr zero, ra, 0