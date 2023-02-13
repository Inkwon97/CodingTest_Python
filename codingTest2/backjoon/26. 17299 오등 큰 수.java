{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": [
    "import java.util.*;\n",
    "import java.io.*;\n",
    "\n",
    "/*\n",
    " * 크기가 N인 수열\n",
    " * NGF\n",
    " * 수열 A에서 등장한 횟수를 F(A)\n",
    " * 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(A)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미\n",
    " * 그러한 수가 없는 경우 오등큰수는 -1\n",
    " *\n",
    " * ex) A = [1, 1, 2, 3, 4, 2, 1\n",
    " * */\n",
    "class Node {\n",
    "    int idx;\n",
    "    int data;\n",
    "\n",
    "    public Node(int idx, int data) {\n",
    "        this.idx = idx;\n",
    "        this.data = data;\n",
    "    }\n",
    "}\n",
    "class Main {\n",
    "    static int n;\n",
    "\n",
    "    // 1. HashMap으로 데이터들의 개수 파악\n",
    "    // 2. stack에 데이터를 넣어서 더 큰 hash값이 나올 때까지\n",
    "    public static void main(String[] args) throws IOException{\n",
    "        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n",
    "        int n = Integer.parseInt(br.readLine());\n",
    "        StringTokenizer st = new StringTokenizer(br.readLine());\n",
    "\n",
    "        HashMap<Integer, Integer> hashMap = new HashMap<>();\n",
    "        ArrayList<Integer> list = new ArrayList<>();\n",
    "        // 들어온 데이터들을 hash값으로 매핑\n",
    "        for (int i = 0; i < n; i++) {\n",
    "            int num = Integer.parseInt(st.nextToken());\n",
    "            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);\n",
    "            list.add(num);\n",
    "        }\n",
    "\n",
    "        Stack<Node> stack = new Stack<>();\n",
    "        stack.push(new Node(0, list.get(0)));\n",
    "        int[] result = new int[n];\n",
    "        Arrays.fill(result, -1);\n",
    "\n",
    "        // stack의 마지막 값과 list[i]의 해시값을 서로 비교\n",
    "        // stack에 있는 값이 더 작다면, 해당 stack을 꺼내서 result[idx] 위치에 list[i] 대입\n",
    "        for (int i = 1; i < n; i++) {\n",
    "            while (!stack.isEmpty() && (hashMap.get(stack.get(stack.size() - 1).data) < hashMap.get(list.get(i)))) {\n",
    "                Node node = stack.pop();\n",
    "                result[node.idx] = list.get(i);\n",
    "            }\n",
    "            stack.push(new Node(i, list.get(i)));\n",
    "        }\n",
    "\n",
    "        StringBuffer bf = new StringBuffer();\n",
    "        for (int x : result) {\n",
    "            bf.append(x).append(\" \");\n",
    "        }\n",
    "        System.out.println(bf);\n",
    "\n",
    "    }\n",
    "}"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "name": "python",
   "version": "3.8.6"
  },
  "orig_nbformat": 4,
  "vscode": {
   "interpreter": {
    "hash": "2ba6819d172d60e93b2f90e5d47af36d4f36070393882cfcbe0fef625705f185"
   }
  }
 },
 "nbformat": 4,
 "nbformat_minor": 2
}
