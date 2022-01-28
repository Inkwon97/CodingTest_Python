'''
만약 5276823 이 주어지고 3개의 자릿수를 제거한다면
7823이 가장 큰 숫자가 됩니다. 
'''
# 1. 숫자가 주어진다.
# 2. m개의 숫자를 제거하여 가장 큰 수를 만듬

# 입력
# 숫자와 제거해야 할 개수
# 5276823 3

# 출력 
# 7823

# import sys
# sys.stdin = open("./MyCoding/Section5/input/input1.txt", "rt")

num, remove = input().split()
remove = int(remove)

'''
1. 스택에 값 대입
2. if stack < arr[i]를 검사. 
3. while문을 통해, cnt개수가 남아있고, 앞의 숫자를 계속 비교. 크다면, arr.pop()
    while cnt > 0 and len(stack):
        if stack[-1] < num:

        stack.pop()
4. 스택값과 새로 넣으려는 값이 동일하거나 같은 경우 while문 break
5. 마지막 cnt값이 남은 경우, 남은 값만큼 pop()
'''
cnt = remove
stack = []
for x in num:
    # 맨 처음 값 대입
    if len(stack) == 0:
        stack.append(int(x))
    else:
        while cnt > 0 and len(stack):
            if stack[-1] < int(x):
                stack.pop()
                cnt -= 1
            # 스택값과 새로 넣으려는 값이 동일하거나 같은 경우
            else:
                break
        stack.append(int(x))

# 남은 값만큼 pop()
for _ in range(cnt):
    stack.pop()

# 출력
for x in stack:
    print(x, end = '')