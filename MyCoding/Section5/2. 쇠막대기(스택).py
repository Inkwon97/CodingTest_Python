# 1. 맨 아래가 제일 긴 막대. 위 막대들은 아래막대의 길이에 포함이 됨 끝점은 겹치지 않음
# 2. 막대기 당 레이저가 적어도 하나 존재
# 3. 레이저는 쇠막대기의 양 끝점과 겹치지 않음
# 4. 모든 ()는 레이저로 표현
# 5. 왼쪽 끝은 ( 오른쪽 끝은 )
# 6. 잘려진 쇠막대기의 총 개수

'''
1. stack에 계속 쌓아나감 만약 )가 나온다면, pop후 len(stack)만큼 길이를 증가
2. last로 저장 후, 또 )가 나온다면, pop
3. stack에 계속 쌓아나감
'''

# import sys
# sys.stdin = open("MyCoding/Section5/input/input2.txt", "rt")

arr = input()
last = ''
stack = []
cnt = 0
for x in arr:

    # 1. 만약 )가 나온다면, pop후 len(stack)만큼 길이를 증가
    if x == ')' and last == '(':
        stack.pop()
        cnt += len(stack)
    # 2. last로 저장 후, 또 )가 나온다면, pop
    elif x == ')' and last == ')':
        stack.pop()
        cnt += 1
    # 3. stack에 계속 쌓아나감
    else:
        stack.append(x)
    last = x

print(cnt)