package gr.aueb.cf.chTest;

import java.io.*;
public class Project03 {


        public static void main(String[] args) {
            try {int[][] charCount = countCharacters("D://ASOE/A B C.txt");

                System.out.println("Character frequencies sorted alphabetically:");
                printSortedByCharacter(charCount);

                System.out.println("\nCharacter frequencies sorted by count:");
                printSortedByCount(charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        // Count character and their frequency
        public static int[][] countCharacters(String filename) throws IOException {
            int[][] charCount = new int[128][2];

            for (int i = 0; i < 128; i++) {
                charCount[i][0] = i;  // Store using ASCII
                charCount[i][1] = 0;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch >= 32 && ch < 128 && ch != ' ') {
                    charCount[ch][1]++;
                }
            }
            reader.close();
            return charCount;
        }

        public static void printSortedByCharacter(int[][] charCount) {
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i][1] > 0) {  // Print only if character appeared
                    System.out.println((char) charCount[i][0] + ": " + charCount[i][1]);
                }
            }
        }

        public static void printSortedByCount(int[][] charCount) {
            for (int i = 0; i < charCount.length - 1; i++) {
                for (int j = i + 1; j < charCount.length; j++) {
                    if (charCount[i][1] < charCount[j][1]) {
                        int[] temp = charCount[i];
                        charCount[i] = charCount[j];
                        charCount[j] = temp;
                    }
                }
            }

            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i][1] > 0) {  // Print only if character appeared
                    System.out.println((char) charCount[i][0] + ": " + charCount[i][1]);
                }
            }
        }
}
