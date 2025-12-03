package com.example.aoc.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day01 {
    public static void run() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src/main/resources/input.txt"));
        System.out.println("Result: " + solve(list));
    }

    public static int solve(List<String> list) {
        int position = 50;
        int count = 0;

        for (String s : list) {
            char f = s.charAt(0);
            int d = Integer.parseInt(s.substring(1));

            if (f == 'L') {
                position = (position - d + 100) % 100;
            } else {
                position = (position + d) % 100;
            }

            if (position == 0) {
                count++;
            }
        }

        return count;
    }
}
