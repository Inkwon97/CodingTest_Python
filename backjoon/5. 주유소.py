import sys
sys.stdin = open("./backjoon/input/input5.txt", "rt")

# 1. 아래는 주유 가격
# 2. 위에는 필요한 주유량

# 1. 기름이 있어야 출발이 가능하다 가장 처음에 주유를 하기
# 2. 주유량을 감소시키기
# 3 5 2 1 4
# 1. 현재의 기름값보다 작은 기름값의 위치에 도달할 때까지 주유를 할 것
# 2. 주유량 감소시키기

# price[minIdx] > price[j] 라면, idx = j로 넣어주고,
# fuel을 idx - 1까지 넣어줄 것 
# i가 idx될 때까지 아무것도 하지 않기

n = int(input())
fuel = list(map(int, input().split()))
price = list(map(int, input().split()))

# 다음으로 저렴한 price
minIdx = 0
totalPrice = 0
for i in range(len(price)):
    # 다음 기름값이 저렴한 인덱스 구하기
    for j in range(i+1, len(price)):
        if price[minIdx] > price[j]:
            minIdx = j
            print(minIdx)
            break

    # fuel을 idx - 1까지 넣어주기
    for j in range(i, minIdx):
        print("totalprice : ", totalPrice)
        totalPrice += price[j] * (minIdx-1)
    
print(totalPrice)
