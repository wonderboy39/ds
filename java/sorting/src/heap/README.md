# 우선순위 큐 (배열 기반 힙)  
  
## 구현하고자 하는 것들
1. 힙 트리 테스트 프로그램  
2. 힙 정렬  
3. 최소 힙을 이용한 허프만 코드 

## 우선순위 큐를 구현하는 방법들
### 우선순위 큐를 구현하는 방법은 대표적으로 세 가지 방법이 있다.
1. 배열을 이용한 방법
2. 연결리스트를 이용한 방법
3. 힙(heap)을 이용한 방법
  
이 중에서 힙(heap)을 이용한 방식을 정리해보고자 한다. 그 이유는, 특정 우선순위의 노드를 탐색하고자 할때 배열, 연결리스트를 이용한 방식은 O(n)의 시간복잡도가 발생한다. 하지만 힙(heap)은 완전이진트리기반이기 때문에 O(nlogn)의 방식이므로 탐색의 속도가 더 빠르다. 따라서 힙을 이용한 방식을 정리해보고자 한다. 미구현된 사항(연결리스트, 배열 방식)에 대한 내용은 차차 정리해보고자 한다.  
  
## 힙트리의 특징
힙 트리의 구조는 구조상으로 이진탐색트리와 유사한 점이 많다. 하지만 힙 트리의 경우 중복된 값을 허용한다. 이진 탐색 트리에서는 중복된 값을 허용하지 않았다.  
  
**힙트리의 종류**  
**최대힙(max heap)**  
부모노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리  
 - key (부모노드) >= key (자식노드)  
  
**최소힙(min heap)**  
부모노드의 키 값이 자식노드의 키 값보다 작거나 같은 완전 이진 트리  
  
## 구현 목표  
### 가능한 방법들 
**힙트리는 연결리스트기반의 이진 탐색트리로 구현할 수도 있고, 배열기반으로 구현할 수도 있다.**  
  
여기서는 ArrayList 기반의 인덱스를 가진 연결리스트를 사용해 2의 멱승 기반으로 요소를 찾아나가는 방식을 사용해보고자 한다. 연결리스트 기반의 힙 트리구현은 조금 나중으로 미뤄보고자 한다.  
  
## 배열 기반 힙의 구현
#### 배열기반의 힙에서 각 요소의 인덱스 번호  
그림으로 트리 내의 각 요소의 번호를 설명해야 하는데, 여건상 지금 당장에 업로드하기는 어려우므로 그림 설명을 업로드하는 것은 나중으로 패스하고 필요한 부분들만을 텍스트로 정리해보고자 한다.  
 - 왼쪽 자식의 인덱스 = (부모의 인덱스)*2  
 - 오른쪽 자식의 인덱스 = (부모의 인덱스)*2+1  
 - 부모의 인덱스 = (자기자신의 인덱스)/2 또는 (자식의 인덱스)/2  
  
#### 배열 기반 히프트리에서의 삽입알고리즘 (자연어버전)
**insertNode(A, key)**   
 1. 히프의 끝에 새로운 노드를 삽입힌다.  
 2. 삽입된 노드와 그 부모노드의 키 값을 비교한다. 삽입된 노드의 키 값이 부모노드의 키 값보다 크면 두 노드의 위치를 바꾼다.  
 3. 삽입된 노드의 키 값이 자신의 부모노드 키 값보다 작아질 때까지 단계2를 반복한다.  
   
 1. 히프 크기를 하나 증가시킨다.
 2. **증가된 히프 크기위치에 새로운 노드를 삽입한다.**
 3. i가 루트노드가 아니고 i번째 노드가 i의 부모노드보다 크면
 4. i번째 노드와 부모노드와 교환
 5. 한 레벨 위로 올라간다 
 
 
 
 
 
 
 
 
 