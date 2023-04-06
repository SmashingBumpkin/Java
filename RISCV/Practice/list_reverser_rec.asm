.data
head:	.word n01
n01:	.word 1, n02
n02:	.word 2, n03
n05:	.word 5,0
n03:	.word 3, n04
n04:	.word 4, n05
.text
	jal ra, listPrintorrrr
	lw a0, head
	
	ori a7, zero, 1
	jal ra, reversorr
	
	jal ra, listPrintorrrr
	
	ori a7, zero, 10
	ecall
	
	#PRINT LINKED LIST
listPrintorrrr:
	lw s0, head 
	ori a7, zero 1
notzero:lw a0, 0(s0) #loads number of list to a0
	lw s0, 4(s0) #loads next address to s0
	ecall
	bne zero, s0, notzero
	jalr zero, ra, 0


reversorr:
	ori a1, a0, 0
	lw a0, 4(a0) #pointer to next in list
	sw zero, 4(a1) #overwrites head of list to be 0
	addi sp, sp, -4
	sw ra, 0(sp) #saves return address to stack pointer
	jal ra, reversorrHelper
	la a2, head
	sw a1, 0(a2)
	addi sp, sp, 4
	lw ra, 0(sp)
	jalr zero, ra, 0
	
	reversorrHelper:
		bne a0, zero, recursion
		jalr zero, ra, 0
		
		recursion:
			addi sp, sp, -4
			sw ra, 0(sp) #saves return address to stack pointer
			lw a2, 4(a0)
			sw a1, 4(a0) #points backwards to last address
			ori a1, a0, 0 #sets a1 to be pointer to current element in list
			ori a0, a2, 0
			jal ra, reversorrHelper
			addi sp, sp, 4
			lw ra, 0(sp)
			jalr zero, ra, 0

	
	
	
	
	
	
	
	
