package com.kid.dev.domain;

import java.util.Arrays;

/**
 * 문제 1.
 * 1부터 16까지 2차원 배열이 있습니다.
 * 해당 배열을 밖에 배열은 반시계방향으로 한칸씩 이동시키고 안쪽 배열은 시계 반향으로 이동하여 출력하시오.
 * - 개발 언어 선택은 자유 C,C++,PHP,python,Javascript,JAVA 등
 * - 출력형식은 해당 언어별로 자유롭게 출력
 * - 2차원 배열은 초기값으로 설정
 */
public class ArraySort {

    /**
     * 2차원 배열
     */
    private int[][] numArray;

    /**
     * 객체 생성과 동시에 2차원 배열을 초기화 한다.
     */
    public ArraySort() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> No.1 Array Setting Start >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        numArray = new int[4][4];
        int num = 1;

        for(int i = 0 ; i < 4 ; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                numArray[i][j] = num++;
                System.out.print(numArray[i][j] + "\t");
            }

            System.out.println();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> No.1 Array Setting End >>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public int[][] sort() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> No.1 Array Sort Start >>>>>>>>>>>>>>>>>>>>>>>>>>>");

        int k = 0;
        int l = 0;
        for(int i = 0 ; i < 4 ; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                if((i%3)>0 && (j%3)>0) {
                    // 안쪽 2차원 배열(시계 방향)
                    System.out.print(numArray[3-j][i] + "\t");
                }
                else {
                    if((i%3)>0) {
                        // 두세 번째 줄 양 끝
                        System.out.print(numArray[k][j] + "\t");
                        k += 2;
                    }
                    else {
                        // 첫번째, 마지막 줄
                        System.out.print(numArray[i+(++l/4)][(j+1)-(l/4)-(i==3?2:0)] + "\t");
                    }
                }
            }

            if(k == 4) k -= 3;
            if(i == 2) {
                l = -5;
            }

            System.out.println();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> No.1 Array Sort End >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return numArray;
    }

    public int[][] getNumArray() {
        return numArray;
    }

    public void setNumArray(int[][] numArray) {
        this.numArray = numArray;
    }

    @Override
    public String toString() {
        return "ArraySort{" +
                "numArray=" + Arrays.toString(numArray) +
                '}';
    }
}
