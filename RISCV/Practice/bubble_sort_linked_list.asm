#Bubble sort linked list
.data
head:	.word n1
n1:	.word 5, n2
n2:	.word 3, n3
n3:	.word 1, n4
n4:	.word 16, 0

.text
	jal ra, sorter
	jal ra, printer
	li a7, 10
	ecall
	
	sorter:
	otrlop:	li a4, 1
		lw a0, head
		beq a0, zero, end #END IF LIST ENDS
	loop:	lw a2, 0(a0) #current list position
		lw a1, 4(a0) #next list position
		beq a1, zero, end  #END IF LIST ENDS
		lw a3, 0(a1)
		ble a2, a3, skip
		li a4, 0
		sw a3, 0(a0)
		sw a2, 0(a1)
	skip:	ori a0, a1, 0
		beq zero, zero, loop
	end:	beq a4, zero, otrlop
		jalr zero, ra, 0
		
	
	printer:
		lw s0, head #Does the same thing as the above two lines, but is easier
		ori a7, zero 1
	notzero:lw a0, 0(s0) #loads number of list to a0
		lw s0, 4(s0) #loads next address to s0
		ecall
		bne zero, s0, notzero
		jalr zero, ra, 0