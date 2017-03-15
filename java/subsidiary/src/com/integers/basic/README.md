 
# 1.정수쌍 구하기 (Count all distinct pairs with difference equal to k)
#### - FindSubK.java
 이진 탐색으로 고쳐아하는 부분.
 현재 2중 for문으로 인해 n^2의 시간복잡도를 보이고 있다.
 이를 개선하기 위해서는 아래와 같은 조금 더 개선된 탐색기법이 필요하다.

 1) 시간 복잡도가 nlogn인 정렬기법을 이용해 배열을 정렬한다.(병합정렬 등)<br/>
  : nlogn중 그나마 쉽게 사용할수 있는 quicksort를 사용함.

 2) for문의 각 요소에 대해 아래와 같은 step을 거치도록 한다.<br/>
  a) arr[i] + k를 binary search로 i+1 ~ n-1까지 탐색한다.<br/>
  b) arr[i] + k를 찾으면 count 를 증가시킨다.<br/>

 3) count를 return한다.

# 2.배열의 무게중심 구하기 (find center of gravity in Array)
#### - CenterBalance.java
  배열의 우측합 구하는 부분을 효율적으로 구할 수 있도록 수정한 소스
  
  
