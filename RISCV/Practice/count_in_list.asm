.data
x:	.word 4
n:	.word 5
y:	.word 1,4,4,4,5

.text	#Print 1 if x is in y, else 0
	lw t0, x
	lw t1, n
	la s0, y #loads address of first element to y
	li a0, 0 #sets counter to 0
	beq t1, zero, end  #if the list is empty, end
loop:	lw t2, 0(s0) #loads next in array
	bne t2, t0, cont #if the number isn't found, skip the add
	addi a0, a0, 1
cont:	addi s0, s0, 4 #move address along
	addi t1, t1, -1 #move length counter down
	bne t1, zero, loop #loop if not at end of list
end:	li a7, 1
	ecall #prints result
	li a7, 10 #
	ecall#ends the program