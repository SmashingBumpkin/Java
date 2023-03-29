.data # By default starts at address 0x10010000

    .word 2 #0x10010000
    .asciz "zero" # 0x10010004 5 bytes, 4 for the characters, 1 for the termination
    .asciz "nom zero" #0x10010009 (prev address + 5) 9 bytes, 8 for the characters, 1 for the termination
    .asciz "ciao" #0x10010012 (prev address + 9), 

.text # By default starts at address 0x00400000
    lui s0, 0x10010 #loads base of the register
    ori a0, s0, 0x04 #stores address of .asciz "zero"
    addi a7, zero, 4 #Puts value of 4 into address a7
    lw t0, 0(s0) # loads 2 into t0
    beq t0, zero, salta #if the data at t0 is "zero", then jump prompt counter forward 8 bytes (2 words, ie skip the next instruction)
    ori a0, s0, 9
salta: ecall