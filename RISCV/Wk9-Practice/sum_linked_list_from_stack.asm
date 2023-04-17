.data
	head: .word n1
	n1: .word 5, n2
	n2: .word 3, n3
	n3: .word 4, 0
	
.text
	lw a0, head
	jal ra, adder
	
	li a7, 1
	ecall
	
	li a7, 10
	ecall
	
	adder:
		bne a0, zero, ric
		jalr zero, ra,0
		ric:
			addi sp, sp, -8
			sw ra, 0(sp)
			lw a1, 0(a0)
			sw a1, 4(sp)
			lw a0, 4(a0)
			jal ra, adder
			lw a1, 4(sp)
			add a0, a0, a1
			lw ra, 0(sp)
			addi sp, sp, 8
			jalr zero, ra, 0