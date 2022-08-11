import sys
sys.stdin = open("./backjoon/input/input5.txt", "rt")

n = int(input())
fuel = list(map(int, input().split()))
price = list(map(int, input().split()))

# 3 4 5 2 1 4
# 1. price[curMin] > price[nextMin]라면, cur ~ next전까지 기름을 구매
# 2. i = minIdx로 이동 or 아무것도 안하기

min_price = fuel[0] * price[0]
min_cost = price[0]

for i in range(1, n - 1):
    if min_cost > price[i]:
        min_cost = price[i]
    min_price += min_cost * fuel[i]

print(min_price)