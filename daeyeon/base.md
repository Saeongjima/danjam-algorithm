[//]: # (문제 풀이 템플릿)
# Problem 💻

## 문제

지금 민식이가 계획한 여행은 달이 맨 처음 뜨기 시작할 때 부터, 준비했던 여행길이다. 하지만, 매번 달이 차오를 때마다 민식이는 어쩔 수 없는 현실의 벽 앞에서 다짐을 포기하고 말았다.

민식이는 매번 자신의 다짐을 말하려고 노력했지만, 말을 하면 아무도 못 알아들을 것만 같아서, 지레 겁먹고 벙어리가 되어버렸다. 결국 민식이는 모두 잠든 새벽 네시 반쯤 홀로 일어나, 창 밖에 떠있는 달을 보았다.

하루밖에 남지 않았다. 달은 내일이면 다 차오른다. 이번이 마지막기회다. 이걸 놓치면 영영 못간다.

영식이는 민식이가 오늘도 여태것처럼 그냥 잠 들어버려서 못 갈지도 모른다고 생각했다. 하지만 그러기엔 민식이의 눈에는 저기 뜬 달이 너무나 떨렸다.

민식이는 지금 미로 속에 있다. 미로는 직사각형 모양이고, 여행길을 떠나기 위해 미로를 탈출하려고 한다. 미로는 다음과 같이 구성되어져있다.

- 빈 칸: 언제나 이동할 수 있다. ('.')
- 벽: 절대 이동할 수 없다. ('#')
- 열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
- 문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
- 민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
- 출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')

달이 차오르는 기회를 놓치지 않기 위해서, 미로를 탈출하려고 한다. 한 번의 움직임은 현재 위치에서 수평이나 수직으로 한 칸 이동하는 것이다.

민식이가 미로를 탈출하는데 걸리는 이동 횟수의 최솟값을 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 미로의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 50) 둘째 줄부터 N개의 줄에 미로의 모양이 주어진다. 같은 타입의 열쇠가 여러 개 있을 수 있고, 문도 마찬가지이다. 그리고, 문에 대응하는 열쇠가 없을 수도 있다. '0'은 한 개, '1'은 적어도 한 개 있다. 열쇠는 여러 번 사용할 수 있다.

## 출력

첫째 줄에 민식이가 미로를 탈출하는데 드는 이동 횟수의 최솟값을 출력한다. 만약 민식이가 미로를 탈출 할 수 없으면, -1을 출력한다.

## 예제 입력 1

```
1 7
f0.F..1
```

## 예제 출력 1

```
7
```

## 예제 입력 2

```
5 5
....1
#1###
.1.#0
....A
.1.#.
```

## 예제 출력 2

```
-1
```

## 예제 입력 3

```
7 8
a#c#eF.1
.#.#.#..
.#B#D###
0....F.1
C#E#A###
.#.#.#..
d#f#bF.1
```

## 예제 출력 3

```
55
```

## 예제 입력 4

```
3 4
1..0
###.
1...
```

## 예제 출력 4

```
3
```

## 예제 입력 5

```
3 5
..0..
.###.
..1.A
```

## 예제 출력 5

```
6
```

## 예제 입력 6

```
4 5
0....
.#B#A
.#.#.
b#a#1
```

## 예제 출력 6

```
19
```

## 예제 입력 7

```
1 11
c.0.C.C.C.1
```

## 예제 출력 7

```
12
```

## 예제 입력 8

```
3 6
###...
#0A.1a
###...
```

## 예제 출력 8

```
-1
```

---

# Approach 1 ❌

## 헷갈렸던 점

### case 1.

```
a##Bf#
0..A##
###.##
###bF1
```

- a 열쇠를 챙겨서 A문을 지나 b 열쇠를 획득해서 B문으로 가고 f 열쇠를 획득하면 F문으로 가는 길이 막히지 않나?
    - f 열쇠를 획득하면 key=’f’인 visited 배열로 전환하기 때문에 상관 없다
        - 정확히는 a 열쇠를 획득했을 때는 1(2) = 1(10) ⇒ visited[][][1]
        - a 열쇠와 b 열쇠를 획득했을 때는 11(2) = 3(10) ⇒ visited[][][3]
        - a, b, f 열쇠를 획득했을 때는 100011(2) = 35(10) ⇒ visited[][][35]

### case 2.

```
.##B.1
0..A##
##.###
##.ab#
```

- a 열쇠를 챙긴 다음에 b 열쇠를 챙겨도 A 문을 열 수 있나?
    - a 열쇠를 챙기면 key 비트 마스킹은 1
    - 추가로 b 열쇠를 챙기면 key 비트 마스킹은 11
    - 즉, 11은 a 열쇠와 b 열쇠를 둘 다 갖고 있는 것이기 때문에 둘 다 확인할 수 있다
        - 만약 a 열쇠 없이 b 열쇠만 갖고 있다면 10
    - 비트 마스킹도 결국 방문 처리이기 때문에 상관 없다

### case 3.

visited 3차원 배열을 사용한다면 왜 visited[][][6]이 아닌 visited[][][64]인가?

- a 열쇠 획득했을 때, b 열쇠 획득했을 때 각각이 아닌
- a 열쇠를 획득했을 때, a 열쇠를 소유한 상태에서 b 열쇠를 획득했을 때
    - 이런 식으로 살펴보기 위해서이다

### 결론

열쇠 비트 마스킹을 활용해 3차원 배열을 사용하면 해결된다

---

# Approach 2 ⭕

> 미로 구성 요소
>
- `.`: 빈 칸
- `#`: 벽
- `a`~`f`: 열쇠
- `A`~`F`: 문
- `0`: 민식이 현재 위치
- `1`: 출구

입력

- 미로의 행 크기, 열 크기를 한 줄에 입력받는다.
- 미로를 입력받는다.

출력

- 민식이가 미로를 탈출하는데 드는 이동 횟수의 최솟값

> 이동하기
>

bfs로 모든 곳을 탐색한다 (상하좌우)

- `빈 칸`이면 이동한다
- `벽`이면 건너뛴다
- `열쇠`면 열쇠 획득 표시를 하고 이동한다
    - 비트마스킹 활용
    - 열쇠 획득 표시: `|` 연산
        - `current.key | 1 << (maze[nextRow][nextCol] - 'a')`
- `문`이면 현재 맞는 열쇠가 있는지 확인한다
    - 맞는 열쇠가 있는지 확인: `&` 연산
        - `current.key & 1 << (maze[nextRow][nextCol] - 'A')`
    - 열쇠가 있으면 이동한다
    - 열쇠가 없으면 일단 건너뛴다
- `출구`면 탐색 종료한다
    - 출구를 찾을 수 없는 경우에는 -1을 출력한다

> Queue<Position>
>

큐에 담을 Position(노드)의 요소들

- row, col 좌표
- 이동 횟수
- 열쇠 정보 (비트 마스킹)

> visited 배열
>

3차원 배열 선언

- `visited[rowSize][colSize][64]`
- 64인 이유: 열쇠가 ‘f’까지 존재하기 때문
    - `1 << 'f’` = 64

ex)

- a 열쇠를 획득했을 때는 1(2) = 1(10) ⇒ visited[][][1]
- a 열쇠와 b 열쇠를 획득했을 때는 11(2) = 3(10) ⇒ visited[][][3]
- a, b, f 열쇠를 획득했을 때는 100011(2) = 35(10) ⇒ visited[][][35]

---

# Solution 💡

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    
    static final int[] deltaRow = {-1, 1, 0, 0};
    static final int[] deltaCol = {0, 0, -1, 1};
    static final int MAX_KEY = 1 << 'f'; // 열쇠 비트 마스킹 최댓값
    
    static int rowSize; // 미로의 행 크기
    static int colSize; // 미로의 열 크기
    static char[][] maze; // 미로 배열
    static boolean[][][] visited; // 방문 처리 배열
    
    static class Position {
    	int row, col, moveCount, key;
    	
    	Position (int row, int col, int moveCount, int key) {
    		this.row = row; // 현재 위치
    		this.col = col;
    		this.moveCount = moveCount; // 현재 위치까지의 이동 횟수
    		this.key = key; // 현재 위치까지 획득한 열쇠 정보
    	}
    }
    
    static int escapeMaze(Position start) {
    	Queue<Position> queue = new ArrayDeque<>();
    	queue.offer(start);
    	
    	while (!queue.isEmpty()) {
    		Position current = queue.poll();
    		
    		for (int direction = 0; direction < deltaRow.length; direction++) {
    			int nextRow = current.row + deltaRow[direction];
    			int nextCol = current.col + deltaCol[direction];
    			
    			// 범위를 벗어나면 탐색하지 않는다
    			if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
    				continue;
    			}
    			
    			// 벽이면 이동할 수 없다
    			if (maze[nextRow][nextCol] == '#') {
    				continue;
    			}
    			
    			// 현재 가지고 있는 열쇠를 들고 이미 지나간 곳이면 또 갈 필요 없다
    			if (visited[nextRow][nextCol][current.key]) {
    				continue;
    			}
    			
    			// 출구면 탈출한다
    			if (maze[nextRow][nextCol] == '1') {
    				// 시작 위치부터 출구까지의 이동 횟수를 반환한다
    				return current.moveCount + 1;
    			}
    			
    			// 열쇠면 열쇠 획득 표시를 하고 이동한다
    			if (maze[nextRow][nextCol] >= 'a' && maze[nextRow][nextCol] <= 'f') {
    				// 획득한 열쇠를 표시하고 이동 횟수를 1 증가시켜 queue에 담는다
    				int nextKey = current.key | 1 << (maze[nextRow][nextCol] - 'a');
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, nextKey));
    				visited[nextRow][nextCol][nextKey] = true;
    			}
    			
    			// 문이면 현재 맞는 열쇠가 있는지 확인한다
    			else if (maze[nextRow][nextCol] >= 'A' && maze[nextRow][nextCol] <= 'F') {
    				// 현재 문에 맞는 열쇠가 있는지 확인한다
    				int hasKey = current.key & 1 << (maze[nextRow][nextCol] - 'A');
    				// 현재 문제 맞는 열쇠가 없다면 일단 건너뛴다
    				if (hasKey == 0) {
    					continue;
    				}
    				// 현재 문에 맞는 열쇠가 있다면 이동한다
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, current.key));
    				visited[nextRow][nextCol][current.key] = true;
    			}
    			
    			// 빈 칸이면 이동한다 (혹은 민식이의 처음 위치)
    			else {
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, current.key));
    				visited[nextRow][nextCol][current.key] = true;
    			}
    		}
    	}
    	
    	// 출구를 찾지 못했다면 -1을 반환한다
    	return -1;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        maze = new char[rowSize][colSize];
        visited = new boolean[rowSize][colSize][MAX_KEY];
        Position start = null;
        
        for (int row = 0; row < rowSize; row++) {
        	String line = br.readLine().trim();
        	for (int col = 0; col < colSize; col++) {
        		maze[row][col] = line.charAt(col);
        		
        		// 민식이의 처음 위치를 찾는다
        		if (maze[row][col] == '0') {
        			start = new Position(row, col, 0, 0);
        		}
        	}
        }
        
        int minMoveCount = escapeMaze(start);
        System.out.println(minMoveCount);
    }    
}
```

---

# Reference 📄

- [열쇠 소유 여부 체크](https://moonsbeen.tistory.com/358)
- [열쇠 비트 연산 설명](https://gaybee.tistory.com/37)
- [visited 배열 2차원이 안되는 이유](https://yamyam-spaghetti.tistory.com/45)
- [로직 설명](https://evecomcom.tistory.com/32)