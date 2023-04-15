#Get average from linked list
.data
head:	.word n01
n01:	.word 500, n02
n02:	.word 10000, n03
n05:	.word 10,0
n03:	.word 12, n04
n04:	.word 60, n05

.text
	lw a0, head
	jal ra, average
	
	li a7, 1
	ecall
	
	li a7, 10
	ecall
	
	average:
		addi sp, sp, -4
		sw ra, 0(sp)
		ori a2, zero, 0
		jal ra, average_helper
		lw ra, 0(sp)
		addi sp, sp, 4
		div a0, a0, a2
		jalr zero, ra, 0
				
		average_helper:
			bne zero, a0, ricursion
			jalr zero, ra, 0
			
			ricursion:
				addi sp, sp, -8
				sw ra, 0(sp)
				lw a1, 0(a0)
				sw a1, 4(sp)
				lw a0, 4(a0)
				jal ra, average_helper
				addi a2, a2, 1 #sets a2 to be a counter
				lw a1, 4(sp)
				add a0, a0, a1 #sums total of list
				lw ra, 0(sp) #loads saved pointer into ra
				addi sp, sp, 8 #increments stack pointer back
				jalr zero, ra, 0