file = open("./input/input7.txt", "rt")
# 가로의 길이
n = int(file.readline())
# 상자
arr = list(map(int, file.readline().split()))
# 정렬 횟수 = M
m = int(file.readline())

arr.sort()
for _ in range(m):

    arr[n-1] -= 1
    arr[0] += 1
    # 1. 정렬
    arr.sort()

print(arr[n-1] - arr[0])