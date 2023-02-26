#Instructions add, sub, or, addi, ori, lui, lw, and sw. Rars Risc-V Assembler and Runtime Simulator.

#Exercise 1: Write the code to load from memory two integers, sum them up, and store the result into the memory.
.data # By default starts at address 0x10010000

    .word 17
    .word 25
   
.text # By default starts at address 0x00400000

    lui x5, 0x10010
    lw x3, 0(x5)
    lw x4, 4(x5)
    add x6, x3, x4
    sw x6, 8(x5)
    ori x17, x0, 10
    ecall