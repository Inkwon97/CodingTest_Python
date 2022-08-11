import sys
sys.stdin = open("./backjoon/input.txt", "rt")

 # 1. N종류, 가치의 합을 K개 -> 이때 필요한 동전 개수의 최솟값을 구하는 프로그램
# 1. N과 K
# 2. N개의 가치가 오름차순으로 주어진다

# 1. while 동전 == 0
# 2. coin % i > 0이라면, coin * (coin % i) 를 빼주고, coin의 개수에 더하기
# 3. 마지막에 arr.pop

n, k = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

# coin의 개수
cnt = 0

# 1. arr[-1]과 비교해서, 
while k != 0:
    
    remain = k // arr[-1]
    if 0 < remain:
        k -= arr[-1] * (remain)
        cnt += remain

    arr.pop()

print(cnt)