Quick Sort (퀵 정렬)
===

##Quick 정렬은 ...
>1. 피봇보다 작은 요소들의 집합, 피봇보다 큰 요소들의 집합으로 분류하는 작업을 계속해나가면서 정렬된 전체 배열을 얻어내는 정렬기법이다.
>
2. 퀵정렬을 작성할 때, 제일 먼저 파티션(paratition)함수(분할 함수)를 작성한 후에 이를 재귀함수를 사용하는 quick_sort()함수를 통해 수행한다
>
3. 더 이상 쪼개지 못하는 단위까지 쪼개서 partition을 수행한다. 그 결과로 정렬된 결과값을 얻어내게 된다.

##partition 함수
pivot으로 사용할 값을 사용할 요소를 선택 후, pivot보다 작은 값은 왼쪽 집합"left"에 두고, pivot보다 큰 값은 오른쪽 집합"right"에 둔다.
(pivot의 선정은 알고리즘 방식마다 다르다. 하지만 이 예제에서는 입력값의 범위가 소규모이므로 편의상 제일 앞자리에 있는 요소인 arr[0]을 pivot으로 선택한다.)

partition을 한 번 수행할 때마다 얻어지는 left, right집합의 특성은 아래와 같다.
> * left : 오름차순으로 정렬할 것이기 때문에 left에 pivot보다 작은 값들을 모아둔다.

> * right : 오름차순으로 정렬할 것이기 때문에 right에 pivot보다 큰 값들을 모아둔다.

파티션 함수내에서 반복문의 매 연산마다(while i=0~n, i=k일때) 수행되는 연산을 문장으로 정리해보면 아래와 같다.
>blah blah bla..~ ... 아 오늘은 도저히 못하게써... 내일 정리할끄얌~ ^^

#####예제 1)
int [] arr = {5,3,2,4,8,1,6,7}; 라는 배열이 있다고 해보자
> ##### Step 0) pivot위치, L,R위치 선정
5 3 2 4 8 1 6 7<br/>
P L---------- R

> ##### Step 1)
5 3 2 4 8 1 6 7<br/>
P-- L-------- R

> ##### Step 2)
5 3 2 4 8 1 6 7<br/>
P---- L------ R

> ##### Step 3)
5 3 2 4 8 1 6 7<br/>
P------ L---- R<br/>
L : stopped<br/>

> ##### Step 4)
5 3 2 4 8 1 6 7<br/>
P------ L-- R--<br/>

> ##### Step 5)
5 3 2 4 8 1 6 7<br/>
P------ L R----<br/>
R : stopped<br/>

> ##### Step 6)
5 3 2 4 1 8 6 7<br/>
P------ L R----<br/>
SWAP(L,R)<br/>
The values of L,R are swaped.<br/>

#####예제 2)
이번에는 각각의 연산마다의 수행을 모두 표현하지 않고 L,R이 멈출때의 각 요소들을 그림으로 표현해보겠다.
4 5 2 1 7 3 6 8<br/>
P L---------- R<br/>
L : Stopped.

4 5 2 1 7 3 6 8<br/>
P L------ R<br/>
R : Stopped.

4 3 2 1 7 5 6 8<br/>
P L------ R<br/>
SWAPPED : SWAP(L,R)

4 3 2 1 7 5 6 8<br/>
P------ L R<br/>
L : Stopped.

4 3 2 1 7 5 6 8<br/>
P-----R L<br/>
R : Stopped.

1 3 2 4 7 5 6 8<br/>
P-----R L<br/>
SWAPPED : SWAP(P,R)

psuedo code로 표현해보면,
<pre>
<code>
while(left<=right)
  while(arr[left]<arr[pivot])left+=1
  while(arr[right]>arr[pivot])right-=1
  swap(arr,left, right)
swap(arr,right, pivot)
</code>
</pre>




