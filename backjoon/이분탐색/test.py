import sys
sys.stdin = open("./backjoon/이분탐색/input/input2.txt", "rt")

n = int(input())
card = list(map(int, input().split()))
m = int(input())
arr = list(map(int, input().split()))

card = set(card)
card = list(card)
card.sort()
print(card)
# set도 map이 가능한지
cntNum = {}
# 값들의 개수를 모두 저장
# 값과 개수들을 dictinary에 저장
for x in card:
    cntNum[x] = cntNum.get(x, 0) + 1

print(cntNum)

    