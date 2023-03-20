#function to add a and b
.text
	#BLAH BLAH
	li a0, 2
	li a1, 2
	jal ra, somma

somma:	
	add a0, `a0, a1
	jalr zero, ra, 0