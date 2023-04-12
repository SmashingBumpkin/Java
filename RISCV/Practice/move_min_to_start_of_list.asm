#Build a function that takes an array and arranges it in a way that that the
#first item is the minimum

.data
len:	.word 	6
arr:	.word	1,2,3,4,0,6

.text
	lw a1, len #a1 = length of array
	la a2, arr #address of first number
	ori a3, a3, 0 #address of first number perm
	lw a4, 0(a3) #a4 = min number

loop:	beq a1, zero, endloop
	addi a1, a1, -1
	lw a0, 0(a2)
	ble a0, a4, skip
	ori a4, a0, 0
skip:	addi a2, a2, 4
	bne a1, zero, loop
	
endloop: