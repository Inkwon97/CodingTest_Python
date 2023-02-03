- java
    
    lv1 
    
    - 햄버거 만들기
        
        ```python
        import java.io.*;
        import java.util.*;
        
        class Solution {
            public int solution(int[] ingredient) {
                List<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> comp = new ArrayList<>();
        
                comp.add(1);
                comp.add(2);
                comp.add(3);
                comp.add(1);
        
                int answer = 0;
        
                for (int i = 0; i < ingredient.length; i++) {
                    arrayList.add(ingredient[i]);
                    // arraylist의 크기가 4 이상이고, 마지막 원소의 값이 1,2,3,4로 동일할 때
                    if (arrayList.size() >= 4 && (arrayList.subList(arrayList.size() - 4, arrayList.size()).equals(comp))) {
                        arrayList = arrayList.subList(0, arrayList.size() - 4);
                        answer++;
                    }
                }
                
                return answer;
            }
        }
        ```
        
        88점. 시간초과
        
    - 점 찍기
        
        ```python
        // x축과 y축이 직교하는 2차원 좌표평면에 점을 찍기
        // a * k, b * k 만큼 떨어진 위치에 점을 찍는다
        // 원점과 d를 넘는 위치에는 점을 찍지 않는다
        
        // 
        
        class Solution {
            public long solution(int k, int d) {
                long answer = 0;
                
                for (int i = 0; i < d + 1; i += k) {
                    for (int j = 0; j < d + 1; j += k) {
                        if (Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2)) > d)
                            break;
                        answer += 1;
                    }
                }
                    
                
                return answer;
            }
        }
        ```
        
        75점
        
    
    lv2
    
    - 땅 따먹기
        
        ```python
        // 땅 따먹기
        // 1행부터 땅을 밟으면 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다
        // 같은 열을 연속해서 밟을 수 없음
        
        // 정수의 최댓값을 return
        
        class Solution {
            int solution(int[][] land) {
                int answer = 0;
                
                // 1. dp를 0행으로 초기화
                int[][] dp = new int[land.length][land[0].length];
                
                for (int i = 0; i < 4; i++) {
                    dp[0][i] = land[0][i];
                }
                
                // dp를 초기화
                for (int i = 1; i < land.length; i++) {
                    dp[i][0] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][0];
                    dp[i][1] += Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][1];
                    dp[i][2] += Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][2];
                    dp[i][3] += Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][3];
                }
                
                // for (int i = 0; i < land.length; i++) {
                //     for (int x : dp[i]) {
                //         System.out.print(x + " ");
                //     }
                //     System.out.println();
                // }
                
                for (int i = 0; i < 4; i++) {
                    answer = Math.max(dp[land.length - 1][i], answer);
                }
                
                return answer;
            }
        }
        ```