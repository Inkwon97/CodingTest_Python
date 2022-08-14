# 총 기다리는 사람들의 시간의 최소값

import sys
sys.stdin = open("./backjoon/input/input3.txt", "rt")

n = int(input())
arr = list(map(int,input().split()))

arr.sort()
totalTime = 0

# 1. arr을 정렬하기
# 2. 총 걸리는 시간들을 더해서 append
# 3. append된 결과들을 result = sum()

totalResult = []
for x in arr:
    totalTime += x
    totalResult.append(totalTime)
print(sum(totalResult))