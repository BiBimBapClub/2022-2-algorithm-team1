# 브루트포스

> [https://hcr3066.tistory.com/26](https://hcr3066.tistory.com/26)
> 

> [https://foreverhappiness.tistory.com/104](https://foreverhappiness.tistory.com/104)
> 

# 정의

brute : 무식한 , force : 힘의 합성어로 완전탐색으로 가능한 모든 경우의 수를 탬색하면서 요구조건에 충족되는 결과를 색출한다.

일반적 방법으로 문제를 해결하기 위해서는 모든 자료를 탐색해야하기 때문에 특정한 구조를 전체적으로 탐색할 수 있는 방법을 사용해야한다.

브루트 포스 알고리즘을 설계할 떄는 해가 하나 이상 존재한다는 가정을 세우고 모든 범위를 탐색하기 때문에 무조건 정답을 찾을 수 있다.

# 사용 시점

입력의 크기가 작아서 컴퓨터가 처리하기에는 쉽지만, 손으로 직접 풀기에는 경우의 수가 너무 많은 경우에 브루트포스를 통해 푼다.

# 기법

선형 구조를 전체적으로 탐색하는 순차탐색, 비선형 구조를 전체적으로 탐색하는 깊이 우선 탐색과 너비 우선 탐색이 가장 기본적인 도구이다. 

- [ ]  순차 탐색
- 순차탐색 설명
    1. 문제에서 주어진 자료를 선형 구조로 구조화한다. (구조화)
    2. 구조화된 자료들을 구조에 맞는 방법으로 해를 구할 때까지 탐색한다. (탐색)
    3. 탐색한 해를 주어진 문제의 출력 형식에 맞게 정리한다. (정리)
- [ ]  백트래킹
- 백트래킹 설명
    
    백트래킹이란 DFS를 통해 사건 탐색도중 해당 트리가 잘못되었음을 인지하면 중단점으로 돌아가 다시 탐색하는 기법이다.
    

- [ ]  DFS
- [ ]  BFS

# 장점

알고리즘을 설계하고 구현하기 매우 쉽다.

복잡한 알고리즘 없이 빠르게  구현할 수 있다.

# 단점

알고리즘의 실행 시간이 매우 오래 걸린다.

메모리 효율면에서 매우 비효율적이다.

# 예제

## BOJ 2798 : 블랙잭

카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

## 입력

첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

## 출력

첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

## 풀이

### 선형탐색

```jsx
FOR i
	FOR j
		FOR k
			if ls[i] + ls[j] + ls[k] > max AND ls[i] + ls[j] + ls[k] <= M
				max = ls[i] + ls[j] + ls[k]
```

### 백트래킹

```jsx
DEF Recursive(i,j,k)
	static max 
	if ls[i] + ls[j]+ls[k] > M AND k == len(ls)-1
		return 0
	if ls[i] + ls[j] + ls[k] <= M AND k == len(ls)-1
		return 1
	
	FOR nj = i+1
		if Recursive (i , nj, len(k)-1)
			if max < ls[i]+ ls[j] +ls[k] 
				max = ls[i] + ls[j] + ls[k]
			if M == .i.nj.len(k)-1   //lucky case
				return M

		
		else  
			FOR nk = nj+1
				if max< .i.nj.nk AND .i.nj.nk <=M
					max = .i.nj.nk
				else if .i.nj.nk>M
					continue

FOR i 
	temp = Recursive(i,0,0)
	if max< temp
		max = temp

return max
```

			
	

# 추천 문제(난이도 순)

1. [https://www.acmicpc.net/problem/2231](https://www.acmicpc.net/problem/2231)
2. [https://www.acmicpc.net/problem/2309](https://www.acmicpc.net/problem/2309)
3. [https://www.acmicpc.net/problem/10448](https://www.acmicpc.net/problem/10448)
4. [https://www.acmicpc.net/problem/1051](https://www.acmicpc.net/problem/1051)
5. [https://www.acmicpc.net/problem/14717](https://www.acmicpc.net/problem/14717)
6. [https://www.acmicpc.net/problem/1018](https://www.acmicpc.net/problem/1018)
7. [https://www.acmicpc.net/problem/3085](https://www.acmicpc.net/problem/3085)
8. [https://www.acmicpc.net/problem/2503](https://www.acmicpc.net/problem/2503)
9. [https://www.acmicpc.net/problem/1182](https://www.acmicpc.net/problem/1182)
