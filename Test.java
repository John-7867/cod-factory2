package gr.aueb.cf.ch10;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("D://ASOE/lotto5in.txt"));
             PrintStream ps = new PrintStream("D:/ASOE/lotto5out.txt", StandardCharsets.UTF_8)) {

            final int Window = 6;
            int[] inputNumbers = new int[49];
            int pivot = 0;
            int[] result = new int[Window];
            int num;
            int window;

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumbers[pivot++] = num;
            }

            int[] numbers = Arrays.copyOfRange(inputNumbers, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - Window;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];

                                    if (!isEven(result, 4) && !isOfdd(result, 4) && !isContiguous(result) && !isSameEnding(result, 2) && !isSameTen(result, 3))
                                    {
                                        ps.printf("%d %d %d %d %d %d\n",
                                                result[0], result[1], result[2], result[3], result[4], result[5]);
                                        System.out.printf("%d %d %d %d %d %d\n",
                                            result[0], result[1], result[2], result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isEven(int[] arr, int threshold) {
        int even = 0;

        for (int num : arr) {
            if (num % 2 == 0) even++;
        }
        return even >= threshold;
    }

    public static boolean isOfdd(int[] arr, int threshold) {
        int odds = 0;

        for (int num : arr) {
            if (num % 2 != 0) odds++;
        }
        return odds >= threshold;
    }

    public static boolean isContiguous(int[] arr) {
        int consecutiveCount = 0;

        for (int i = 0; i <= 4; i++) {
            if (arr[i] == arr[i + 1] - 1){
                consecutiveCount++;
                break;
            }
        }
        return consecutiveCount >= 2;
    }

    public static boolean isSameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];

        for (int num : arr) {
            endings[num % 10]++;
        }

        return Arrays.stream(endings).anyMatch(e -> e >= threshold);
    }

    public static boolean isSameTen(int[] arr, int threshold) {
        int[] ten = new int[5];

        for (int num : arr) {
            ten[num/10]++;
        }

        return Arrays.stream(ten).anyMatch(t -> t >= threshold);
    }
}