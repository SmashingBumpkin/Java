.data
	head: .word n01
	n01: .word 1, n02
	n02: .word 2, n03
	n03: .word 3, n04
	n04: .word 4, n05
	n05: .word 5, 0

.text 
	lw a0, head
	jal ra, odd_adder
	
	li a7, 1
	ecall

	li a7, 10
	ecall	
	
	odd_adder:
		bne a0, zero, ricursion
		jalr zero, ra, 0
		
		ricursion:
			sw ra, 0(sp)
			lw a1, 0(a0)
			sw a1, -4(sp)
			addi sp, sp, -8
			lw a0, 4(a0)
			jal ra, odd_adder
			addi sp, sp, 8
			lw a1, -4(sp)
			add a0, a0, a1
			lw ra, 0(sp)
			jalr zero, ra, 0
			