package com.example.aoc.day02;

import java.io.IOException;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day02 {
	
	public static void main(String[] args) {
		try {
			solve("day02/Input0.txt");
			solve("day02/Input1.txt");
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
		long sum = 0;
		String[] split = lines.get(0).split(",");
        for (String string : split) {
            long startingElement = Long.parseLong(string.split("-")[0]);
            long endingElement = Long.parseLong(string.split("-")[1]);

            for (long j = startingElement; j <= endingElement; j++) {
                String s = String.valueOf(j);
                int middleIndex1 = s.length() / 2;
                String firstHalf1 = s.substring(0, middleIndex1);
                String secondHalf1 = s.substring(middleIndex1);
                if (firstHalf1.equals(secondHalf1)) {
                    sum += j;
                }
            }
        }
		return String.valueOf(sum);
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
