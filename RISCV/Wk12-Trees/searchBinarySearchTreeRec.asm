.data
	x: .word 4
	tree: .word n01
	n01: .word 7, n02, n03
	n02: .word 4, n04, n05
	n03: .word 11, n06, 0
	n04: .word 1, 0, 0
	n05: .word 6, 0, 0
	n06: .word 8, 0, 0 

.text
	lw a0, tree
	lw a1, x
	jal ra, cerca
	li a7, 1
	ecall
	li a7, 10
	ecall
	
	cerca: #Returns true if x in binary search tree
		bne a0, zero, base
		jalr zero, ra, 0
		
	base:
		lw t0, 0(a0)
		bne a1, t0, ric
		li a0, 1
		jalr zero, ra, 0
			
		ric:
			addi sp, sp, -4
			sw ra, 0(sp)
			blt t0, a1, destra
			lw a0, 8(a0)
			jal ra, cerca
			beq zero, zero, fine
		destra:
			lw a0, 8(a0)
			jal ra, cerca
		fine:	lw ra, 0(sp)
			addi sp, sp, 4
			jalr zero, ra, 0