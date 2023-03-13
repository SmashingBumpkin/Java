#Function that can print a new line
.text
	#STUFF
	jal ra acapo
	
acapo:	li a0, 10 #save "10" (for print new line) into a0
	li a7, 11 #loads instruction to print char to a7 (where ecall lives)
	ecall
	jalr zero, ra, 0
	#return to address saved in ra