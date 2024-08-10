{
 "cells": [
  {
   "cell_type": "markdown",
   "id": "03b53c38",
   "metadata": {},
   "source": [
    "### 202111151 유다인"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "78a6f4af",
   "metadata": {},
   "source": [
    "# #과제12-1)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 52,
   "id": "6e47aba3",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "계산할 식을 입력하세요: 5 3 4 2 * 1 3 - 2 * / + \n",
      "error\n"
     ]
    }
   ],
   "source": [
    "def evalPostFix(expression):\n",
    "    # 스택 선언 \n",
    "    stack = []\n",
    "\n",
    "    # 공백을 제거한 후에 문자 하나씩 처리하기\n",
    "    for char in expression.replace(\" \", \"\"):\n",
    "        #문자가 숫자인 경우엔\n",
    "        if char.isdigit():\n",
    "            #스택에 추가\n",
    "            stack.append(int(char))\n",
    "        #그게 아니라면 연산자인 경우\n",
    "        else:\n",
    "            #스택에 2개 이상의 원소가 있을 때만 꺼내서 연산 수행\n",
    "            if len(stack) > 1 :\n",
    "                #스택에서 하나씩 꺼냄(숫자임)\n",
    "                b = stack.pop()\n",
    "                a = stack.pop()\n",
    "                #연산자 +/*/ 계산 후 다시 그 값을 연산\n",
    "                if char == '+':\n",
    "                    stack.append(a + b)\n",
    "                elif char == '-':\n",
    "                    stack.append(a - b)\n",
    "                elif char == '*':\n",
    "                    stack.append(a * b)\n",
    "                elif char == '/':\n",
    "                    stack.append(int(a / b))\n",
    "            else:\n",
    "                return \"error\"\n",
    "            \n",
    "    #스택에 하나의 값이 있어야 올바른 결과임 -> 결과값 return\n",
    "    if len(stack) == 1:\n",
    "        return stack[0]\n",
    "    else:\n",
    "        return \"error\"\n",
    "\n",
    "def infixToPostfix(expression):\n",
    "    #연산자 우선순위 \n",
    "    precedence = {'+': 1, '-': 1, '*': 2, '/': 2}\n",
    "    #스택과 출력 리스트 선언\n",
    "    stack = []\n",
    "    output = []\n",
    "\n",
    "    #공백 제거 후 문자 하나씩 처리\n",
    "    for char in expression.replace(\" \", \"\"):\n",
    "        #숫자인 경우 출력 리스트에 추가\n",
    "        if char.isdigit():\n",
    "            output.append(char)\n",
    "            #여는 괄호는 스택에 추가\n",
    "        elif char == '(':\n",
    "            stack.append(char)\n",
    "            #닫는 괄호가 나오면 \n",
    "        elif char == ')':\n",
    "            #여는 괄호가 나올 때까지 스택에서 꺼내 출력 리스트에 추가\n",
    "            while stack and stack[-1] != '(':\n",
    "                output.append(stack.pop())\n",
    "            stack.pop() #여는 괄호 제거\n",
    "        else:\n",
    "            #연산자는 스택의 연산자와 우선순위 비교하여 처리\n",
    "            while stack and precedence.get(stack[-1], 0) >= precedence[char]:\n",
    "                output.append(stack.pop())\n",
    "            stack.append(char)\n",
    "\n",
    "    #스택에 남아 있는 모든 연산자를 출력 리스트에 추가\n",
    "    while stack:\n",
    "        output.append(stack.pop())\n",
    "\n",
    "    return ''.join(output)\n",
    "\n",
    "def isInfix(expression):\n",
    "    #스택 선언\n",
    "    stack = []\n",
    "    #연산자 set\n",
    "    operators = set(\"+-*/\")\n",
    "    last = None\n",
    "    \n",
    "    #공백 제거 후 문자 하나씩 처리\n",
    "    for char in expression.replace(\" \", \"\"):\n",
    "        #숫자가 연속이면 잘못된 식\n",
    "        if char.isdigit():\n",
    "            if last == True:\n",
    "                return False\n",
    "            last = True\n",
    "        #연산자가 연속으로 오거나 처음에 오면 잘못된 식\n",
    "        elif char in operators:\n",
    "            if last != True:\n",
    "                return False\n",
    "            last = False\n",
    "        #여는 괄호는 스택에 추가\n",
    "        elif char == '(':\n",
    "            stack.append(char)\n",
    "            last = None\n",
    "        #닫는 괄호가 나올 때 스택이 비어 있거나 마지막 값이 숫자가 아니면 잘못된 식\n",
    "        elif char == ')':\n",
    "            if not stack or last == None:\n",
    "                return False\n",
    "            stack.pop()\n",
    "            last = True\n",
    "        #그 외의 문자는 잘못된 식\n",
    "        else:\n",
    "            return False\n",
    "\n",
    "    #스택이 비어 있고 마지막 값이 숫자면 올바른 중위 표기법\n",
    "    return not stack and last == True\n",
    "    \n",
    "input_exp = input(\"계산할 식을 입력하세요: \")\n",
    "if isInfix(input_exp):\n",
    "    postfix = infixToPostfix(input_exp)\n",
    "    print(evalPostFix(postfix))\n",
    "else:\n",
    "    print(evalPostFix(input_exp))"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "c9576dca",
   "metadata": {},
   "source": [
    "# #과제12-2)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 66,
   "id": "498fcdc9",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "hit: 0, miss: 12\n"
     ]
    }
   ],
   "source": [
    "from collections import deque #고정 크기의 deque를 사용!\n",
    "\n",
    "#cache_size와 page_list 입력 ㅂ다음 \n",
    "def LRU(cache_size, page_list):\n",
    "    #캐시 크기가 0이면모든 참조는 미스 \n",
    "    if cache_size == 0:\n",
    "        return 0, len(page_list)\n",
    "\n",
    "    cache = deque(maxlen=cache_size)  # 고정 크기의 deque 사용\n",
    "    hits = 0\n",
    "    miss = 0\n",
    "\n",
    "    #page_list만큼 반복\n",
    "    for page in page_list:\n",
    "        #페이지가 캐시에 속할때\n",
    "        if page in cache:\n",
    "            # 캐시 히트 발생: 해당 페이지를 제거하고 다시 삽입하여 최신으로 만듦 -> 최근 사용 위치로 업뎃\n",
    "            cache.remove(page)\n",
    "            cache.append(page)\n",
    "            hits += 1\n",
    "        else:\n",
    "            # 캐시 미스: 캐시에 페이지 추가 (가장 마지막 위치에 삽입)\n",
    "            cache.append(page)\n",
    "            miss += 1\n",
    "\n",
    "    #출력\n",
    "    return print(f\"hit: {hits}, miss: {miss}\")\n",
    "\n",
    "LRU(3, [1,2,3,4,5,6,3,7,8,1,4,7])"
   ]
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3 (ipykernel)",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.9.12"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
