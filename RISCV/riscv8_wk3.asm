.data
	.word 4 #array length
	.word 1,20,3,4
.text #FIND THE LARGEST ELEMENT IN AN ARRAY
	lui s0, 0x10010
	lw t0, 0(s0) #loads length of array
	ori a0, zero, 0 #sets highest value in array so far
	ori a7, a7, 1 #sets ecall to print
loop:	addi s0, s0, 4
	lw t1, 0(s0) #loads current value to t1
	addi t0, t0, -1 #increments length remaining of array down
	blt a0, t1, newHi #if the next number is higher then branch
	bne t0, zero, loop #if the end of the array is not reached, branch
	ecall
	ori a7, zero, 10
	ecall
	
newHi:	or, a0, t1, zero
	bne t0, zero, loop
	ecall
	ori a7, zero, 10
	ecall	
#t0: array length
#t1: current value from array being assessed
#s0: pointer to memory
#a0: highest number in array