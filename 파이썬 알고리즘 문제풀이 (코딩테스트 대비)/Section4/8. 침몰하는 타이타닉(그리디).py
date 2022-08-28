# 1. N명의 승객 구명보트는 2명 이하 
# 2. 보트 하나의 총 무게 = M kg 이하
# 3. 필요한 구명보트의 최소 개수

import sys
sys.stdin = open("./MyCoding/Section4/input/input8.txt", "rt")

n, m = map(int, input().split())
arr = list(map(int, input().split()))

# 1. 정렬
# 2. M이 넘어가면 cnt해주면 될듯
# 3. 제일 작은것과 제일 큰 것들을 비교
arr.sort()
cnt = 0
while arr:
    if len(arr) == 1:
        cnt += 1
        break
    # arr[0] + arr[-1] > m이라면, arr.pop, cnt += 1
    if arr[0] + arr[-1] > m:
        arr.pop()
        cnt += 1
    # else
    else:
        cnt += 1
        arr.pop(0)
        arr.pop()
print(cnt)
