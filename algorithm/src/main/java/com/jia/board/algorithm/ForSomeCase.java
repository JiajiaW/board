package com.jia.board.algorithm;

import java.util.Random;

public class ForSomeCase {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i=0; i <= 100; i++){
            double tmp = random.nextDouble();
            System.out.println(tmp);
        }

    }
}
