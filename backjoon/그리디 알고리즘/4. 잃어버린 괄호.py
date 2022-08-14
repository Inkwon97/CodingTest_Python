import sys
# sys.stdin = open("./backjoon/input/input4.txt", "rt")

arr = input().split('-')
num = []

for x in arr:
    cnt = sum(list(map(int, x.split('+'))))
    num.append(cnt)

result = num.pop(0)
for x in num:
    result -= x
print(result)