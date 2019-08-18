package algorithm.dynamic;

public class BottomUpMain {

    public static void main(String [] args){
        int [] priceArr     = {0, 2, 7, 8, 12, 20, 21, 22, 23, 24, 30};
        int [] lengthArr    = {0, 1, 2, 3,  4,  5,  6,  7,  8,  9, 10};
    }

    /**
     *
     * @param priceArr
     *      price의 배열
     *
     * @param lengthArr
     *      막대기 길이의 배열
     *
     * @param k
     *      몇번째 막대기를 계산할지(즉, R(k)) 선택하는 지표
     *
     * @return
     *      rnArr (귀납적 수열의 원소 R(i)의 각각의 값)
     */
    public int [] bottomUp(int [] priceArr, int [] lengthArr, int k){
        Integer [] riArr = new Integer [priceArr.length];
        Integer [] rnArr = new Integer [priceArr.length];

        riArr[0] = 0;
        rnArr[0] = 0;

        /**
         *
         * i=1 일때 R1 : P1 + R0
         *      => i : 1
         *
         * i=2 일때 R2 : MAX(P1 + R1, P2 + R0)
         *      => i : 1 ~ 2
         *
         * i=3 일때 R3 : MAX(P1 + R2, P2 + R1, P3 + R0)
         *      => i : 1 ~ 3
         *
         * i=4 일때 R4 : MAX(P1 + R3, P2 + R2, P3 + R1, P4 + R0)
         *      => i : 1 ~ 4
         *
         */

        for(int i=1; i<k; i++){

            for(int j=1; j<i; j++){
                // Rn = Max(Pi + Rn-i)
                if(riArr[i] == null){
                    int temp = priceArr[i] + riArr[j-i];
                    riArr[i] = temp;
                }

                // 검토 필요
//                int temp = priceArr[i] + rnArr[j-1];
//                rnArr[i] = Math.max(temp, getMax(rnArr));
            }

            rnArr[i] = getMax(riArr);
        }
        return null;
    }

    private int getMax(Integer[] arr){
        int result = 0;

        for(int i=0; i<arr.length; i++){
            if(result < arr[i]){
                result = arr[i];
            }
        }

        return result;
    }
}
