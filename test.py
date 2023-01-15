import sys
sys.stdin = open("input.txt", "rt")
input = sys.stdin.readline

word = [0] + list(map(int, input().rstrip()))

dp = [0] * (len(word) + 1)
dp[0] = 1
print(word)
# for i in range(1, len(word) + 1):



