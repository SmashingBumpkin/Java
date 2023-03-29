.data
val: 	.word 5
lista:	.word n01
n01: 	.word 8, n02
n02: 	.word 5, n03
n03: 	.word 2, n04
n04: 	.word 4, n05
n05: 	.word -1, n06
n06: 	.word 9, 0

.text
	lw a0, lista #load head to a0
	lw a1, val
	jal ra, listcnt
	
	li a7, 1
	ecall
	
	ori a7, zero, 10
	ecall
	
	listcnt:
		bne a0, zero, ric
		jalr zero, ra, 0
		
		ric:
		#For each element add each value and pointer to the stack
		#change the pointer to be a0
		#recurse
		#if 0 continue from where we were
		#check each value to see if it's equal to the search val
		#recurse backwards
			addi sp, sp, -8
			sw ra, 0(sp) #saves the current return address to the stack
			sw a0, 4(sp) #saves next in list to a0
			lw a0, 4(a0) #loads left side of tree
			jal ra, listcnt #recurses with head pointing to right side
			lw t0, 8(sp) #count of right side of tree
			add a0, a0, t0 #adds count of rh side to counter a0
			addi, a0, a0, 1 #adds current node to counter a0
			lw ra, 0(sp) #loads return address from stack
			addi sp, sp, 12 #iterates stack pointer upwards
			jalr zero, ra, 0 #unrecurses