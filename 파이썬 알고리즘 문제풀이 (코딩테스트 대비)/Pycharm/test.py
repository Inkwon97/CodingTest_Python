# lt와 rt변수를 지정해줌
# lt를 먼저 더해주고, 해당 값이 tot보다 작다면, rt를 더해주고, rt + 1
import sys
file = open("input.txt", "rt")
num, target = map(int, file.readline().split())
arr = list(map(int, file.readline().split()))

lt = 0;
rt = 1
tot = arr[lt];
cnt = 0

while True:
    # target보다 더 작다면, rt를 더해주고, 1을 증가시킴

    if tot < target:
        if rt < num:
            tot = tot + arr[rt]
            rt += 1
        else:
            break

    elif tot == target:
        cnt += 1
        tot -= arr[lt]
        lt += 1

    else:  # tot > target
        tot = tot - arr[lt]
        lt += 1

print(cnt)