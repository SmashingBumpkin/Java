#Reverse a linked list
.data
	head: .word n1
	n1: .word 5, n2
	n2: .word 2, n3
	n3: .word 2, 0

.text
	lw a0, head
	li a7, 1
	jal ra, printer
	jal ra, reversorr
	jal ra, printer
	
	li a7, 10
	ecall
	
	reversorr:
		bne a0, zero, skip
		jalr zero, ra, 0
		skip:	
		lw a1 4(a0)
		bne a1, zero, rec
		jalr zero, ra, 0
		rec:	addi sp, sp, -8
			sw ra, 0(sp)
			sw a0, 4(sp)
			lw a0, 4(a0)
			jal ra, reversorr
			lw t0, 4(sp)
			lw t1, 4(t0)
			sw t0, 4(t1)
			sw zero, 4(t0)
			lw ra, 0(sp)
			addi sp, sp, 8
			jalr zero, ra, 0
			
	printer:
		bne a0, zero, ricursion
		jalr zero, ra, 0
		
		ricursion:
			addi sp, sp, -8
			sw ra, 0(sp)
			lw a1, 0(a0)
			sw a1, 4(sp)
			lw a0, 4(a0)
			jal ra, printer
			lw a0, 4(sp)
			ecall
			lw ra, 0(sp)
			addi sp, sp, 8
			jalr zero, ra, 0
