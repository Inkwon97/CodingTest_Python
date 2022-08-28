'''
1. isdecimal로 확인 
2. 연산자가 나온다면, pop
'''

import sys
sys.stdin = open("MyCoding/Section5/input/input4.txt", "rt")

def operatoin(a, b, oper):
    if oper == '+': return a + b
    elif oper == '-': return a - b
    elif oper == '*': return a * b
    elif oper == '/': return a / b

arr = input()
stack = []

for x in arr:
    if x.isdecimal():
        stack.append(int(x))
    else:
        b = stack.pop()
        a = stack.pop()
        stack.append(operatoin(a, b, x))
        
print(stack.pop())