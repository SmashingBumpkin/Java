.data
	tree: .word n01
	 n01:    .word 6, n02, 0
	 n02:    .word -20, nA , n03
	 n03:    .word 12, n05, n04
	 n04:    .word 1, nX, 0
	 n05:    .word 5, 0, n06
	 n06:    .word 8, nC, n07
	 n07:    .word 11, 0, n08
	 n08:    .word -1, 0, 0
	  nA:	 .word -4, 0, nB
	  nB: 	 .word -17, 0, 0
	  nC:	 .word -16, 0, nD
	  nD:	 .word 14, 0, nE
	  nE:	 .word -3, 0, 0
 	  nX:	 .word 100, nY, 0
	  nY:	 .word -20, 0, 0

.text
	lw a1, tree
	addi a0, zero, -2048 #a0 is placeholder for largest number so far
	jal ra, maxSubtree
	li a7, 1
	ecall
	li a7, 10
	ecall
	
	maxSubtree: #Returns the largest subtree of the tree
		bne a1, zero, ric #if the pointer is 0 then there is no child/sibling
		addi t0, zero, 0 #sets sibling/child value to 0
		jalr zero, ra, 0
		
		ric:
			addi sp, sp, -12
			sw ra, 0(sp) #save return address
			sw a1, 8(sp) #saves current address to stack
			lw a1, 4(a1) #loads first child into a1
			jal ra, maxSubtree #Recursion maxSubtree on first child
			lw a1, 8(sp) #reloads pointer to current node
			lw t1, 0(a1) #loads node value to t1
			add t0, t0, t1 #adds current node value to value of children
			sw t0, 4(sp) #saves total value of node to t0
			jal ra, update_max #updates the node value
			lw a1, 8(a1) #loads sibling value
			jal ra, maxSubtree #repeat process for sibling node if it exists
			lw t1, 4(sp) #loads node value to t1
			add t0, t0, t1 #adds current node value to value of sibling
			lw ra, 0(sp) #loads return address
			addi sp, sp, 12 #returns stack pointer
			jalr zero, ra, 0 #exits from function

update_max:
	ble t0, a0, skip
	addi a0, t0, 0
	skip:
	jalr ra
