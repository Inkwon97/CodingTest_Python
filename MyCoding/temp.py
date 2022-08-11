# 18 = 1 더하기 8 = 9
# 18은 9로 나누어 떨어짐
def solution(n, m):
    answer = []

    answer.append(GCD(n, m))
    answer.append(LCM(n, m))

    return answer

def GCD(x, y):
    while(y):
        x, y = y, x % y
    return x

def LCM(x, y):
    result = (x*y) / GCD(x, y)
    return int(result)

print(solution(3, 12))