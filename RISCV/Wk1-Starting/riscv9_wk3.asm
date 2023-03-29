#A program to reverse the order of an array of integers
.data
	.word 6
	.word 1,2,3,4,5,6
.text
	lui s0, 0x10010
	lw t0, 0(s0) #loads length of array
	slli s1, t0, 2 #s1 now points to last position in array
	#move pointer to last point of array
	#save last point in array to new position in memory
	#iterate backwards through array, while iterating forward to new positions in memory
	#Load from new positions in array and print dat shit