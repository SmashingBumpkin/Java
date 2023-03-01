.data #0x10010
	.word 3 #i
	.word 6 # array length
	.word 3, 5, 11, 12, 21, 27 #array X
.text	#Print contents of ith element of the array x
	lui s0, 0x10010
	lw t0, 0(s0) #loads i
	ori s0, s0, 8 #moves pointer to start of array
	slli t0, t0, 2 #increment pointer forward by i * 2^2 words
	add s0, s0, t0 #positions pointer to 4th position
	lw a0, 0(s0) #lw at pointer to a0
	ori a7, zero, 1  #instructions for ecall
	ecall # print a0