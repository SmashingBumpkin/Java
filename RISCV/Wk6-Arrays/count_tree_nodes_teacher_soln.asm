.data #Tree:
#      n01 
#     /   \
#   n02    n03
#  /   \     \
#n04   n05    n06

#2x2 array
albero:	.word n01
n01: 	.word 8, n02, n03 #node1
n02: 	.word 5, n04, n05 #node 2
n03: 	.word 2, 0, n06 #node 3
n04: 	.word 4, 0, 0 #node 4
n05: 	.word -1, 0, 0 #node 5
n06: 	.word 9, 0, 0 #node 6

.text #	
	lw a0, albero #load head to a0
	jal ra, nodecnt
	
	li a7, 1
	ecall
	
	ori a7, zero, 10
	ecall
	
	nodecnt:
		bne a0, zero, ric
		jalr zero, ra, 0
		
		ric:
			addi sp, sp, -12 #moves stack pointer
			sw ra, 0(sp) #saves the current return address to the stack
			sw a0, 4(sp) #saves the left child to the stack pointer
			lw a0, 4(a0) #loads left side of tree
			jal ra, nodecnt #recurses with head pointing to right side
			sw a0, 8(sp) #saves the right child to a0
			lw a0, 4(sp) #loads
			lw a0, 8(a0) #loads left side of tree
			jal ra, nodecnt #recurses with head pointing to right side
			lw t0, 8(sp) #count of right side of tree
			add a0, a0, t0 #adds count of rh side to counter a0
			addi, a0, a0, 1 #adds current node to counter a0
			lw ra, 0(sp) #loads return address from stack
			addi sp, sp, 12 #iterates stack pointer upwards
			jalr zero, ra, 0 #unrecurses