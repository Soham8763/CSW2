//Lab2
//Sum and average of N 16 bit number
MOV SI,5000H
MOV CL,[SI] MOV BL,CL
MOV BH,00H
MOV DX,0000;
MOV AX,0000H
MOV DL,00H
L2: INC SI
INC SI ADD AX,[SI]
JNC L1
INC DL
L1: DEC CL
JNZ L2
DIV BX
INC SI
INC SI
MOV [SI],AX
INC SI
INC SI
MOV [SI],DX
HLT

//counting no of 0s using direct addressing mode
MOV BX,
MOV AL,[ 2000H]
MOV CL,08H
MOV BL,00H
L2: SHR AL,1H
JC L1
INC BL
L1: DEC CL
JNZ L2
INC BX
MOV [2001],BL HLT

// Move a block of 16-bit data from one location to another.
MOV AX,2000H
MOV DS,AX ; DS=2000H
MOV SI, 3000H
MOV DI, 5000H
MOV CL,05H
L1: MOV BX,[SI]
MOV [DI],BX
INC SI
INC SI
INC DI
INC DI
DEC CL
JNZ L1
HLT

//Multiplication of two 16-bit numbers without using MUL instruction using direct addressing mode
MOV BX, [1000H]
MOV CX, [1002H]
MOV DX,0000H
MOV AX, 0000H
L2: ADD AX,BX
JNC L1
INC DX
L1: DEC CX
JNZ L2
MOV [1004H], AX
MOV [1006H], DX
HLT

//Lab3
//Find the largest number in a given array of size N.
.data
count db 04h
value db 09h, 10h,05h,03h
res db ?
.code
MAIN PROC
mov ax, data
mov ds, ax
mov cl, count
dec cl
LEA SI, value
mov al, [SI]
up: inc si
cmp al, [si]
jnc nxt
nxt: dec cl
jnz up
LEA DI, res
mov [DI], al
END MAIN

//Arrange the elements of an given array of size N in ascending order.
.DATA
count DB 06
value DB 09H,0FH,14H,45H,24H,3FH
.CODE
MAIN PROC
MOV AX,DATA
MOV DS,AX
LEA DI, count
MOV CH,[DI]
DEC CH
UP2: MOV CL,CH
LEA SI, value
UP1: MOV AL,[SI]
CMP AL, [si+1]
JC DOWN
MOV DL,[SI+1]
XCHG [SI],DL
MOV [SI+1],DL
DOWN: INC SI
DEC CL
JNZ UP1
DEC CH
JNZ UP2
END MAIN

//Lab4
//Perform Addition and Subtraction of two 32-bit numbers using data processing addressing mode (with 8-bit immediate data).
.global _start
_start:
mov r0, #0x40
mov r1, #0x50
adds r2,r0,#0x50
subs r3,r0,#0x50
mul r4,r0,r1
my_exit: b my_exit

//Perform Addition and Subtraction of two 32-bit numbers using data processing addressing mode (with 32-bit immediate data).
.global _start
_start:
LDR R0,=0xAB000002
LDR R1,=0x1200000c
adds R2,R0,R1
subs R3,R0,R1
mul R4,R0,R1
my_exit: b my_exit

//Perform Addition, Subtraction, and Multiplication of two 32-bit numbers using load/store addressing mode.

.global _start
_start:
LDR R0,=0X10100000
LDR R1,[R0],#4
LDR R2,[R0],#4
ADDS R3,R1,R2
STR R3,[R0],#4
SUBS R4,R1,R2
STR R4,[R0],#4
MUL R5,R1,R2
STR R5,[R0]
my_exit: b my_exit

// Perform the logical operations (AND, OR, XOR, and NOT) on two 32-bit numbers using load/store addressing mode
Program
.global _start
_start:
LDR R0,=0X10100000
LDR R1,[R0],#4
LDR R2,[R0],#4
ANDS R3,R2,R1
STR R3,[R0],#4
ORR R4,R2,R1
STR R4,[R0],#4
EOR R5,R2,R1
STR R5,[R0],#4
MVN R6, R1
STR R6,[R0]
my_exit: b my_exit

//Lab1
//addition, subtraction, mul, division
MOV AX,5225H
MOV CX,AX
ADD AX,4324H
MOV [5000H],AX
MOV AX,CX
SUB AX,4324H
MOV [5002H],AX
MOV AX,CX
MOV BX,4324H
MUL BX
MOV [5004H],AX
MOV [5006H],DX
MOV DX, 0000H
MOV AX,CX
DIV BX
MOV [5008H],AX
MOV [500AH],DX
HLT

//Swapping of nibble of data1 and Swapping of nibble of data1 and Y= (data1 and data2) or (data1 xor data2)
;swapping of nibble
mov si, 1000h
mov al,[si] ;1st data stores in al
mov cl,al
inc si
mov bl,[si] ;2nd data stores in bl
mov dl,al
shr al,04
shl dl,04
or al,dl
inc si
mov [si],al
;Computation of Y
mov al,cl
and al,bl
mov dl,al
xor cl,bl
or al,cl
inc si
mov [si],al
hlt

//Find the Gray code of an 8-bit binary number.
mov al, [1000h]
mov bl,al
shr al,01
xor al,bl
mov [1001h],al
hlt

//Find the 2’s complement of an 8 -bit number.
mov al, [1000h]
not al
add al,01h
mov [1001h],al
hlt

//Lab5
//Find the Largest number from a given array of size N using ARM assembly Language
AREA PROG1, CODE,READONLY
ENTRY
START
back
;Largest number from a given array
ldr r0,=count
ldr r1,[r0] ; r1= array size
ldr r2,=array
ldr r3, [r2],#4
subs r1,r1,#01
beq fwd
ldr r4,[r2],#4
cmp r3,r4
bgt back
mov r3,r4
b back
fwd
ldr r5,=RESULT
str r3,[r5]
exit b exit
count DCD 0x07
array
DCD 0x15 ; DCD= Define Constant Double-words(32-bit)
DCD 0x35 ; DCD directive allocates one or more words of memory, aligned
; on 4-byte boundaries
DCD 0x32
DCD 0x45
DCD 0x10
DCD 0x4f
DCD 0x34
AREA DATA2,DATA,READWRITE ; TO STORE RESULT IN GIVEN ADDRESS
lARGEST DCD 0X0
END

//Separate Even numbers and odds numbers in an array of size N using ARM Assembly language.
AREA prog2, CODE, READONLY
ENTRY ;Mark first instruction to execute
START
ldr r0,=count
ldr r1,[r0]
ldr r3,=array ; r3 = base address of array=array[0]
ldr r4,=even ; r4=base address of even data locations as constant = even[0]
ldr r5,=odd ; r5=base address of odd data locations as constant = odd[0]
; = 0x40000000
; = 0x4000001c
back
ldr r6, [r3],#4
ands r7,r6,#1
beq fwd
str r6,[r5],#4
b fwd1
fwd
str r6,[r4],#4
fwd1
subs r1,r1,#01
bne back
exit b exit
; Array declaration
count DCD 0x07
array
DCD 0x15
DCD 0x35
DCD 0x32
DCD 0x45
DCD 0x10
DCD 0x4f
DCD 0x34
AREA DATA2,DATA,READWRITE ; TO STORE RESULT IN GIVEN ADDRESS
even
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
odd
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
DCD 0X0
END

//Lab6
//Find the factorial of a given 8-bit number.
AREA FACTORIAL, CODE, READONLY
ENTRY
START
MOV R0, #5 ;n
MOV R1, #1 ;result
fact_loop
CMP R0, #0
BEQ end_loop MUL R2, R1, R0
MOV R1, R2 SUBS R0, R0, #1 B fact_loop end_loop
LDR R2, =RESULT STR R1, [R2]
EXT B EXT
; R1 = R1 * R0
; R0 = R0 - 1
; Repeat the loop
AREA RES, DATA, READWRITE
RESULT DCD 0X0
END

//Find the Fibonacci Series up to n digits.
AREA fibnacci, CODE, READONLY
ENTRY
START
MOV R1, #01
MOV R2, #00
MOV R3, #00
LDR R0, =COUNT
LDR R6, =FIB_SERIES
LDRB R5, [R0]
CMP R5, #1
BLE STOP1
STRB R2, [R6], #01
SUBS R5, R5, #01
STRB R1,[R6],#01
BACK
SUBS R5,R5,#01
BEQ STOP
ADD R3,R1,R2
STRB R3,[R6],#01
MOV R2,R1
MOV R1,R3
B BACK
STOP1 STRB R3,[R6]
STOP B STOP
COUNT DCB 0X0A ; N =10
AREA DATA1, DATA, READWRITE
FIB_SERIES DCB 0X0,0X0,0X0,0X0,0X0,0X0,0X0,0X0,0X0,0X0
END