package org.example.lab5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input U: ");
        String U = scanner.nextLine();
        char[] Uc = U.toCharArray();
        Arrays.sort(Uc);
        U = String.valueOf(Uc);
        System.out.print("Input A: ");
        String A = scanner.nextLine();
        System.out.print("Input B: ");
        String B = scanner.nextLine();
        int[] bitA = makeBitArray(U, A);
        int[] bitB = makeBitArray(U, B);
        determine(bitA,bitB,U);


    }


//    public static void determine(int[] bitA, int[] bitB,String U){
//        int N = bitA.length;
//        int[] notA = new int[N];
//        int[] aAndB = new int[N];
//        int[] aOrB = new int[N];
//        int[] aDifferenceB = new int[N];
//        int[] aXorB = new int[N];
//
//        for (int i =0;i<N;i++){
//            notA[i] = 1 - bitA[i];
//            aAndB[i] = (bitA[i]==1&&bitB[i]==1)?1:0;
//            aOrB[i] = (bitA[i]==1||bitB[i]==1)?1:0;
//            aDifferenceB[i]=(bitA[i]==1&&bitB[i]==0)?1:0;
//            aXorB[i]=bitA[i]^bitB[i];
//
//        }
//
//        System.out.println("U:\t"+U);
//        System.out.println("A:\t"+Arrays.toString(bitA));
//        System.out.println("B:\t"+Arrays.toString(bitB));
//        System.out.println("notA:\t"+Arrays.toString(notA));
//        System.out.println("aAndB:\t"+Arrays.toString(aAndB));
//        System.out.println("aOrB:\t"+Arrays.toString(aOrB));
//        System.out.println("aDifferenceB:\t"+Arrays.toString(aDifferenceB));
//        System.out.println("aXorB:\t"+Arrays.toString(aXorB));
//
//
//
//    }


    public static void determine(int[] bitA, int[] bitB, String U) {
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        int N = U.length();
        StringBuilder notAString = new StringBuilder();
        int[] notA = new int[N];
        StringBuilder aAndBString = new StringBuilder();
        int[] aAndB = new int[N];
        StringBuilder aOrBString = new StringBuilder();
        int[] aOrB = new int[N];
        StringBuilder aDifferenceBString = new StringBuilder();
        int[] aDifferenceB = new int[N];
        StringBuilder aXorBString = new StringBuilder();
        int[] aXorB = new int[N];

        for (int i = 0; i < N; i++) {
            if (bitA[i] == 1) A.append(U.charAt(i));
            if (bitB[i] == 1) B.append(U.charAt(i));
            notA[i] = 1 - bitA[i];
            if (notA[i] == 1) notAString.append(U.charAt(i));
            aAndB[i] = (bitA[i] == 1 && bitB[i] == 1) ? 1 : 0;
            if (aAndB[i] == 1) aAndBString.append(U.charAt(i));
            aOrB[i] = (bitA[i] == 1 || bitB[i] == 1) ? 1 : 0;
            if (aOrB[i] == 1) aOrBString.append(U.charAt(i));
            aDifferenceB[i] = (bitA[i] == 1 && bitB[i] == 0) ? 1 : 0;
            if (aDifferenceB[i] == 1) aDifferenceBString.append(U.charAt(i));
            aXorB[i] = bitA[i] ^ bitB[i];
            if (aXorB[i] == 1) aXorBString.append(U.charAt(i));

        }
        System.out.println("U:\t" + U);
        System.out.printf("A:            %s\t%10s\n",Arrays.toString(bitA), A);
        System.out.printf("B:            %s\t%10s\n", Arrays.toString(bitB), B);
        System.out.printf("notA:         %s\t%10s\n", Arrays.toString(notA) ,notAString);
        System.out.printf("aAndB:        %s\t%10s\n" ,Arrays.toString(aAndB) ,aAndBString);
        System.out.printf("aOrB:         %s\t%10s\n" , Arrays.toString(aOrB) , aOrBString);
        System.out.printf("aDifferenceB: %s\t%10s\n" , Arrays.toString(aDifferenceB) , aDifferenceBString);
        System.out.printf("aXorB:        %s\t%10s\n" , Arrays.toString(aXorB) ,aXorBString );
    }

    public static int[] makeBitArray(String U, String T) {
        int[] result = new int[U.length()];
        for (int i = 0; i < U.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                if (T.charAt(j) == U.charAt(i)) {
                    result[i] = 1;
                    break;
                }
            }
        }
        return result;
    }

}
