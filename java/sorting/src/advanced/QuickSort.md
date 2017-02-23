Quick Sort (퀵 정렬)
===

##Quick 정렬은 ...
>1. 피봇보다 작은 요소들의 집합, 피봇보다 큰 요소들의 집합으로 분류하는 작업을 계속해나가면서 정렬된 전체 배열을 얻어내는 정렬기법이다.
>
2. 퀵정렬을 작성할 때, 제일 먼저 파티션(paratition)함수(분할 함수)를 작성한 후에 이를 재귀함수로 이루어진 quicksort함수에서 partition()을 수행한다.
>
3. partition()을 이용해 더 이상 쪼개지 못하는 단위까지 쪼개서 pivot보다 작은 요소들, 큰 요소들을 위치시키는 작업을 수행한다. 그 결과로 정렬된 결과값을 얻어내게 된다.

##partition 함수
pivot으로 사용할 값을 사용할 요소를 선택 후, pivot보다 작은 값은 왼쪽 집합"left"에 두고, pivot보다 큰 값은 오른쪽 집합"right"에 둔다.
(pivot의 선정은 알고리즘 방식마다 다르다. 하지만 이 예제에서는 입력값의 범위가 소규모이므로 편의상 제일 앞자리에 있는 요소인 arr[0]을 pivot으로 선택한다.)

partition을 한 번 수행할 때마다 얻어지는 left, right집합의 특성은 아래와 같다.
> * left : 오름차순으로 정렬할 것이기 때문에 left에 pivot보다 작은 값들을 모아둔다.

> * right : 오름차순으로 정렬할 것이기 때문에 right에 pivot보다 큰 값들을 모아둔다.

파티션 함수내에서 반복문의 매 연산마다(while left<=right, left=k, right=k'일때) 수행되는 연산을 문장으로 정리해보면 아래와 같다.
> * pivot보다 큰값을 찾을 때까지 left는 계속해서 증가한다(left++). pivot보다 큰값을 찾으면 멈춘다.

> * pivot보다 작은값을 찾을 때까지 right는 계속해서 감소한다(right--). pivot보다 작은값을 찾으면 멈춘다.

> * left가 right보다 작을때에만 arr[right]과 arr[left]를 교환한다.

> 이 세 과정을 left<=right일 동안 반복해서 수행한다.   

반복문이 끝나고 나서 수행하는 동작은 아래와 같다.
> * arr[right]와 arr[pivot]을 교환(swap()한다)
> * right를 return한다.

#####예제 1) while(left<=right)일 동안 수행
int [] arr = {5,3,2,4,8,1,6,7}; 라는 배열이 있다고 해보자
> ##### Step 0) pivot위치, L,R위치 선정
5 3 2 4 8 1 6 7  
P L---------- R

> ##### Step 1)
5 3 2 4 8 1 6 7  
P-- L-------- R

> ##### Step 2)
5 3 2 4 8 1 6 7  
P---- L------ R

> ##### Step 3)
5 3 2 4 8 1 6 7  
P------ L---- R  
L : stopped  

> ##### Step 4)
5 3 2 4 8 1 6 7  
P------ L-- R--  

> ##### Step 5)
5 3 2 4 8 1 6 7  
P------ L R----  
R : stopped  

> ##### Step 6)
5 3 2 4 1 8 6 7  
P------ L R----  
SWAPPED : SWAP(L,R)  
The values of L,R are swapped.  

> ##### Step 6)
5 3 2 4 1 8 6 7  
P-------R L----  
L : Stopped  
R : Stopped  
L값이 R값보다 커질때 반복문을 탈출하도록 while문에 조건을 걸어두었다.

> ##### Step 7)
1 3 2 4 5 8 6 7  
P-------R L----  
SWAPPED : SWAP(P,R)  
모아놓은 P에 대한 대/소로 나누어 놓은 소그룹인 L,R을 P로 파티셔닝(말뚝을 박는다)해놓는다.

> ##### Step 8)
1 3 2 4 5 8 6 7  
P-------R L----  
return R;
구분짓기 위해 말뚝을 박아놓은 위치(파티셔닝을 한 위치)의 index를 return해야한다. 따라서 R의 위치를 return한다.(P값은 R과 교체되었으므로)


#####예제 2)
이번에는 여러번의 swap()을 거쳐야 하는 배열을 준비했다. 각각의 연산마다의 수행을 모두 표현하지 않고 L,R이 멈출때의 각 요소들의 위치, swap될때의 요소들의 위치를 그림으로 표현해보면 아래와 같다.  
>##### Step 1)
4 5 2 1 7 3 6 8  
P L---------- R  
L : Stopped.

>##### Step 2)
4 5 2 1 7 3 6 8  
P L------ R  
R : Stopped.

>##### Step 3)
4 3 2 1 7 5 6 8  
P L------ R  
SWAPPED : SWAP(L,R)

>##### Step 4)
4 3 2 1 7 5 6 8  
P------ L R  
L : Stopped.

>##### Step 5)
4 3 2 1 7 5 6 8  
P-----R L  
R : Stopped.

>##### Step 6)
1 3 2 4 7 5 6 8  
P-----R L  
SWAPPED : SWAP(P,R)

partition()함수를 psuedo code로 표현해보면 아래와 같다.
```{.java}
while(left <= right)
  while(arr[left] < arr[pivot]) left+=1
  while(arr[right] > arr[pivot]) right-=1
  swap(arr, left, right)
swap(arr, right, pivot)
```
##QuickSort  
QuickSort가 수행되는 절차를 말로 표현해보면 아래와 같다.
> * 배열의 0~length-1까지의 partition()의 결과인 pivot을 얻어온다.
   pivot값 : 위에서 정리한 것처럼 초기 pivot을 기준으로 대/소그룹이 나눠진(파티셔닝된) 위치의 인덱스값이다.
   
> * 얻어낸 pivot값을 기준으로 아래의 연산을 수행한다.  
>  1) quicksort(arr, start, pivot-1)
>   pivot을 기준으로 앞에 위치한 그룹(<b>pivot값 보다 작은 요소들의 그룹</b>)에 대해 파티셔닝 작업을 수행하고 얻어낸 파티션 값을 기준으로 또 다시 파티셔닝 하는 방식이다.  
>  2) quicksort(arr, pivot+1, end )
>  pivot을 기준으로 뒤에 위치한 그룹(pivot값보다 큰 요소들의 그룹)에 대해 파티셔닝을 수행하고 또 그 뒤에 위치한 그룹에 대해 파티셔닝하는 방식이다.

> 위의 . 으로 표시된 과정을 start<end 일동안 반복한다.

#####예제 1)  
시간 날때마다 정리!!!!

##### psuedo-code
```{.java}
quicksort(int [] arr, int start, int end){
  if( start < end )
  {
    int p = partition(arr, start, end);
    quicksort(arr, start, p-1);
    quicksort(arr, p+1, end);
  }
}
```









