package com.example.aoc.day07;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.aoc.util.Utility;

public class Day07 {

    public static void main(String[] args) {
        try {
            solve("day07/Input0.txt");
            solve("day07/Input1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve(String filePath) throws IOException {
        System.out.println("Input: " + filePath);
        List<String> lines = Utility.read(filePath);
        String answer1 = partOne(lines);
        System.out.println("Answer1: " + answer1);
        String answer2 = partTwo(lines);
        System.out.println("Answer2: " + answer2);
    }

    private static String partOne(List<String> lines) {
        int rows = lines.size();
        int cols = lines.getFirst().length();

        char[][] grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        Set<String> activeBeams = new HashSet<>();

        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'S') {
                    activeBeams.add(i + ":" + j);
                    break outer;
                }
            }
        }

        int count = 0;
        while (!activeBeams.isEmpty()) {
            Set<String> nextBeams = new HashSet<>();
            for (String activeBeam : activeBeams) {
                int x = Integer.parseInt(activeBeam.split(":")[0]);
                int y = Integer.parseInt(activeBeam.split(":")[1]);

                if ((x + 1) > (rows - 1)) {
                    continue;
                }

                if (grid[x + 1][y] == '^') {
                    if ((y - 1) >= 0 && (y + 1) < cols) {
                        nextBeams.add((x + 1) + ":" + (y - 1));
                        nextBeams.add((x + 1) + ":" + (y + 1));
                        count++;
                    }
                } else {
                    nextBeams.add((x + 1) + ":" + (y));
                }
            }
            activeBeams = nextBeams;
        }
        return String.valueOf(count);
    }

    private static String partTwo(List<String> lines) {
        return String.valueOf(lines.size());
    }

}
