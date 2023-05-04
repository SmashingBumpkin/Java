.data
	x: .word 1
	tree: .word n01
	n01: .word 7, n02, n03
	n02: .word 4, n04, n05
	n03: .word 11, n06, 0
	n04: .word 1, 0, 0
	n05: .word 6, 0, 0
	n06: .word 8, 0, 0 

.text
	lw s0, tree
	lw a0, x
	li a7, 1
	cerca: #Returns true if x in
		beq s0, zero, returnFalse 
		lw a1, 0(s0)
		beq a0, a1, returnTrue
		bgt  a1, a0, rightRoute
		lw s0, 4(s0)
		b cerca
	rightRoute:
		lw s0, 8(s0)
		b cerca
		
	returnTrue:
		li a0, 1
		ecall
		li a7 10
		ecall
		#prints 1
	returnFalse:
		li a0, 0
		ecall
		li a7 10
		ecall