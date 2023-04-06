#Write function to calculate factorial recursively
#base case if number is 0, answer 0
.text 
	li a0, 5
	jal ra, fattoriale
	
	#printin result
	li, a7, 1
	ecall
	
	#terminate
	li a7, 10
	ecall
	
	
fattoriale: 
	bne a0, zero, ricursivo #if not 0, branch down 3 lines, else if == 0:
	li a0, 1 #returns 1
	jalr zero, ra, 0 #jumps back to where to line 24
ricursivo: 
	addi sp, sp, -8 #moves stack pointer back 4
	sw ra, 0(sp) #saves new return address to top of stack
	sw a0, 4(sp) #saves n to stack as well, so it's nice n safe
	addi a0, a0, -1 #iterates n down by -1
	jal fattoriale #recurses and loops this far
	lw t0, 4(sp) #loads last number saved
	mul a0, a0, t0 #multiplies n * n-1
	lw ra, 0(sp) #loads new return address
	addi sp, sp, 8 #iterates pointer position
	jalr zero, ra, 0 #jumps back to line 24 (where last return address was, or line 6 if last iteration
