file = open("./MyCoding/Section3/input/input9.txt", "rt")
# file = open("./input/input9.txt", "rt")
n = int(file.readline())
arr = [list(map(int, file.readline().split())) for _ in range(n)]

# 명령 개수
number = int(file.readline())
for i in range(number):
    cmd = list(map(int, file.readline().split()))
    # cmd[] --> 0 = 행의 위치 ,1 = 왼쪽 or 오른쪽 ,2 = 회전 개수
    # cmd[1] = 0인 경우
    if cmd[1] == 0:
        cnt = 0
        for j in range(cmd[2]):
            # n-1번 회전을 통해서, k부터 k+1까지 회전가능
            tmp = arr[cmd[0]-1][0]
            for k in range(n-1):
                arr[cmd[0]-1][k] = arr[cmd[0]-1][k+1]
            # 마지막에 tmp넣어주기
            arr[cmd[0]-1][n-1] = tmp 

    # cmd[1] == 1인 경우
    if cmd[1] == 1:
        cnt = 0
        for j in range(cmd[2]):
            tmp = arr[cmd[0]-1][n-1]
            for k in range(n-1):
                arr[cmd[0]-1][n-1-k] = arr[cmd[0]-1][n-2-k]
            arr[cmd[0]-1][0] = tmp

for x in range(n):
    print(arr[x])
