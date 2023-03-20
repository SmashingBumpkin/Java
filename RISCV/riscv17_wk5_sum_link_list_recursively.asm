.data
n01:	.word 1, n02
n04:	.word 20, 0
n02:	.word 2, n03
n03:	.word 3, n04
lista:	.word n01
.text 
	#Sums list recursively
	lw a0, lista #loads head into a0
	jal ra, somma #loads current instruction address to ra, then jumps to somma
	
	#printin result
	li, a7, 1
	ecall
	
	#terminate
	li a7, 10
	ecall
	
	somma:		