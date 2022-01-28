#  5 3 4 0 2 1 1 0 -> 4 8 6 2 5 1 3 7

# 1. 1 ~ n까지의 수. 자신보다 큰 수들의 개수를 표현 = 역수열
# 2. 자신의 위치보다 큰 값들의 개수를 1 ~ 7 순서대로 표현
# ==============역수열==============

# 3. 원래 수열을 표현

import sys
sys.stdin = open("./MyCoding/Section4/input/input10.txt", "rt")

# cnt = [10] * n + 1
# 1. cnt를 n개 만큼 설정
# 2. 해당 위치에 값들을 차례로 대입
# 3. 해당 위치의 cnt가 1이라면, 그 다음 위치 확인
# 4. 대입

n = int(input())

# arr = 역수열
arr = list(map(int, input().split()))

# cnt = 총 데이터의 결과
cnt = [0] * (n + 1)

for i in range(len(arr)):
    # idx = 순서대로 넣을 값
    idx = i+1
    # 값이 없다면, 
    if cnt[arr[i]] == 0:
        cnt[arr[i]] = i+1
    # 해당 위치에 값이 있다면
    else:
        index = arr[i] + 1
        while cnt[index] != 0:
            index += 1
        cnt[index] = idx
print(cnt)
