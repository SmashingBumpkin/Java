.data #Tree:
#      n01 
#     /   \
#   n02    n03
#  /   \     \
#n04   n05    n06

#2x2 array

n01: 	.word 8, n02, n03 #node1
n02: 	.word 5, n04, n05 #node 2
n03: 	.word 2, 0, n06 #node 3
n04: 	.word 4, 0, 0 #node 4
n05: 	.word -1, 0, 0 #node 5
n06: 	.word 9, 0, 0 #node 6

.text #	
	li a7, 1
	ecall
	ori a7, zero, 10
	ecall