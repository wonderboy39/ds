# 동적 프로그래밍의 개요
> - 참고자료  
> [ZeroCho 블로그 - 알고리즘](https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182)  

## 동적 프로그래밍이란 ?
동적 프로그래밍의 단어의 의미에서 착각할 수 있는 부분은... 
> 동적(Dynamic)하지도 않고 프로그래밍을 한다는 의미도 절대 아니다.

프로그래머들, 개발자들 입장에서는 동적 프로그래밍은 이름이 잘못 지어진 것으로 생각하고 이해해야 한다.  
단어만 보고서는 혼동을 야기할수 있다.  
  
수학자들이 이름을 이렇게 지어서 우리 같은 개발자들은   
  
> **"아, 씨...프로그래밍을 동적으로 또 해야 하는 건가?"** 

하고 부담감을 가지게 될 수도 있다. 하지만 절대 그런 뜻이 아니다.    
오히려 **'기억'**을 위한 하나의 방식인데 이름만 고상하게 수학자들이 지어낸 것이다.  
테이블(2x2, 4x4, 1xn 등)의 테이블을 마련해두고 기억해두는 걸 수학자들은 프로그래밍이라고 생각하는 듯하다.      
  
## 기억법(자칭)을 사용하는 이유
기억법이라는 용어는 그냥 내가 지은 단어다. 절대 다른 곳에서 쓰지 말자. 입에 붙도록 연습하지도 말지어다.  
  
기억법을 이용해 기억을 하는 이유는 [위의 참고자료의 글](https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182)을 읽다보니 역시 재귀 알고리즘을 풀어내는 과정에서 Rn-1의 값을 기억해두기 위한 것이었다.  
  
분할 정복 기법을 사용하는 경우 여러 개의 조각으로 나뉘어져 문제가 풀어지게 되는데 풀었던 문제를 또 풀게 되는 경우가 생긴다.  
이 경우 같은 연산을 반복할 수 밖에 없는데 이 때 저장해두었다가 그 값을 사용하는 것이 동적 프로그래밍이다.  
  
메모이제이션 역시 동적 프로그래밍 중의 하나의 방식이라고 한다.   
동적 프로그래밍을 하는 방식은  
  
- Bottom-up    
 상향식 계산법이 대표적인 방식 중 하나    
  
- Top-Down  
 **메모이제이션**이 대표적인 Top-down 방식 계산방식 중 하나    
 
으로 나뉜다.  
    
## 막대 자르기 문제  

```text
길이 (i)       0   1   2   3    4    5    6    7    8    9   10
가격 (Pi)      0   2   7   8   12   20   21   22   23   24   30  
```
예를 들어 길이가 4인 막대기를 자를때 얻을 수 있는 최대 가격은 길이가 2인 막대기 두개로 나누어서 가격을 7 + 7 = 14 로 만드는 것이다.  
  
길이가 6인 막대는 자르지 않고 그냥 팔았을 때 최대 21의 가격을 얻을 수 있다.

길이가 n인 막대기의 최대 가격을 Rn 이라고 할 때
> Rn = max(Pi + Rn-i) (i 는 1 ~ n)  

로 나타낼 수 있다. (max는 여러값들 중의 최대값)  
수학자들이 만들어낸 공식인 것으로 보인다. 수열의 귀납법으로 푸는 그런 문제 들이라고 생각하고 있다.    
수열의 귀납법은 고등학교 때도, 대학교 수학시간에도 배워왔던 개념이다.    
  
예를 들면, 길이가 4인 막대기의 최대가격은  
```text
    R4 = max(P1 + R3, P2 + R2, P3 + R1, P4 + R0)
```

막대기의 가격 P는 이미 제공되어 있다.
```text
P1 : 2    P2 : 7    P3 : 8    P4 : 12 (이미 제공되어 있다.)
```
이제 

> **R(i)는 어떻게 구하는 가?**  

가 문제이다. 재귀가 항상 그러했듯이 바로 앞전에 구한 값들을 기반으로 다음 값을 계산해낸다.  
주의할 점은 끝이 정해져 있다는 것이다. (재귀를 무한으로 돌리게 되면 큰일난다.)  

### 계산과정
앞에서 정의된 수식인 

> Rn = MAX(Pi + Rn-i) (단, i = 1~n)  
> R4 = MAX(P1 + R3, P2 + R2, P3 + R1, P4 + R0) 을 염두해보며 풀어보자.  
> 아래에서는 R0,R1,R2,R3를 각각 구하는 것이다.  
  
#### R1  
```text
R1 : 2 
    MAX(
            p1 + R1-1,          : 2  + 0    :    2    
    ) 
```
 
#### R2
```text
R2 : 7
    MAX(
            p1 + R2-1,          : 2  + 1    :     3
            p2 + R2-2,          : 7  + 0    :     7
    ) 
```

#### R3
```text
R3 : 9
    MAX( 
            p1 + R3-1,          : 2   + 7   :     9
            p2 + R3-2,          : 7   + 2   :     9
            p3 + R3-3,          : 8   + 0   :     8
    )
```

#### R4
```text
R4 : 14
    MAX(
            p1 + R4-1,          : 2   + 9   :    11
            p2 + R4-2,          : 7   + 7   :    14     -- 가장 크다
            p3 + R4-3,          : 8   + 2   :    10
            p4 + R4-4,          : 12  + 0   :    12
    )
```

결론적으로 R4(막대기를 어떻게 잘라야 큰지)를 구하기 위해 R1, R2, R3 를 모두 구했다.  
그리고 그 과정에서 R1, R2, R3 연산을 중복적으로 수행했다.  
이렇게 중복수행되는 연산 중 이미 구해진 값이고, 어떠한 경우에도 같은 값이 나오는 경우는  
동적 프로그래밍으로 기억해 풀어낼 수 있다.  
  

동적 프로그래밍에는 
- Top-down (ex : 메모이제이션)
- Bottom-up (ex : 상향식 계산법)
이 있다.  

위의 문제를 bottom-up 으로 풀어보자.

## Bottom-up