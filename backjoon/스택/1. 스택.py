import sys
sys.stdin = open("./backjoon/스택/input/input1.txt", "rt")

n = int(sys.stdin.readline())

# 1. split을 통해서 데이터가 들어왓는지 확인해볼 것
# 2. 데이터 중에서 push가 있다면, data[1]의 값을 push할 것
result = []
for _ in range(n):
    data = list(sys.stdin.readline().split())
    if data[0] in 'push':
        result.append(int(data[1]))
    elif data[0] in 'pop':
        if result:
            print(result.pop())
        else:
            print(-1)
    elif data[0] in 'size':
        print(len(result))
    elif data[0] in 'empty':
        if not result:
            print(1)
        else:
            print(0)
    elif data[0] in 'top':
        if result:
            print(result[-1])
        else:
            print(-1)
