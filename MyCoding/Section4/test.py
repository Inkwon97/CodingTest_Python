import sys
sys.stdin = open("./MyCoding/Section4/input/input3.txt", "rt")
# file = open("./MyCoding/Section4/input/input3.txt", "rt")

# n은 개수  m은 몇개로 묶을 수 있는지
n, m = map(int, input().split())
arr = list(map(int, input().split()))
maxx = max(arr)
# n,m = map(int, file.readline().split())
# arr = list(map(int, file.readline().split()))
lt = 1
rt = sum(arr)

sum = 0
while lt <= rt:
    mid = int((lt + rt) / 2)
    sum = 0
    cnt = 1
    for i in range(n):
        # sum += arr[i]
        # sum + arr[i]가 mid가 된 경우
        if sum + arr[i] > mid:
            cnt += 1
            sum = arr[i]
        else :
            sum += arr[i]
    
    # 만약 cnt가 m개를 넘어선다면,
    if cnt <= m:
        res = mid
        rt = mid-1
    else:
        lt = mid+1
print(res)