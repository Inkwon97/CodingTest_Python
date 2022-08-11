import sys
sys.stdin = open("./backjoon/이분탐색/input/input1.txt", "rt")

# 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
# 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
# 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
# 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

n = int(input())
A = list(map(int, input().split()))
M = int(input())
arr = list(map(int, input().split()))

A.sort()
for x in arr:
    lt = 0
    rt = n - 1

    search = 0
    # x < mid => rt = mid - 1
    # x > mid => lt = mid + 1
    while lt <= rt:
        mid = (lt + rt) // 2
        if x == A[mid]:
            print(1)
            search = 1
            break
        if x < A[mid]:
            rt = mid - 1
        else: 
            lt = mid + 1
    
    if not search:
        print(0)
