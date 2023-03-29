.data
x:	.word  6
y: 	.word 11
.text
	lw t0, x #loads x to a0
	lw t1, y #loads y to t1
	blt t1, t0, end #if y is less than x, end the loop
loop:	ori a0, t0, 0
	li a7, 1  #loads 1 to a7 for printing
	ecall #print a0
	jal ra, acapo #jump to new line program
	addi t0, t0, 1 #add 1 to a0
	blt t0, t1, loop # if a0 is still less than t1 repeat the loop
end:	ori a7, zero, 10 #instruction to close
	ecall #end
	
acapo:	li a0, 10 #save "10" (for print new line) into a0
	li a7, 11 #loads instruction to print char to a7 (where ecall lives)
	ecall
	jalr zero, ra, 0