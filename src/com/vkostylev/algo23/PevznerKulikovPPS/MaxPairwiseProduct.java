package com.vkostylev.algo23.PevznerKulikovPPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solving maximum pairwise product programming challenge from
 * "Ace Your Next Coding Interview by Learning Algorithms through Programming and Puzzle Solving"
 * by Pavel Pevzner and Alexander Kulikov.
 * See https://acecodinginterview.org/ or https://stepik.org/course/126012/info
 * @TODO identify getMaxPairwiseProductEvenFast complexity
 */

public class MaxPairwiseProduct {
    // Naive algorithm with O(N) complexity
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        (long) numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }
    // Faster algorithm with O(2N) complexity
    static long getMaxPairwiseProductFast(int[] numbers) {
        long maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
                maxIndex = i;
            }
        }

        long secondMaxValue = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > secondMaxValue && i != maxIndex) {
                secondMaxValue = numbers[i];
            }
        }

        return maxValue*secondMaxValue;
    }

    // Even faster algorithm with ? complexity
    static long getMaxPairwiseProductEvenFast(int[] numbers) {
        long maxValue1 = Integer.MIN_VALUE;
        long maxValue2 = Integer.MIN_VALUE;

        if (numbers[0] > numbers[1]) {
            maxValue1 = numbers[0];
            maxValue2 = numbers[1];
        } else {
            maxValue1 = numbers[1];
            maxValue2 = numbers[0];
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > maxValue1) {
                maxValue2 = maxValue1;
                maxValue1 = numbers[i];
            } else if (numbers[i] > maxValue2) {
                maxValue2 = numbers[i];
            }
        }

        return maxValue1*maxValue2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
        System.out.println(getMaxPairwiseProductEvenFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
