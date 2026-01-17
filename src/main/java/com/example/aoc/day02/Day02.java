package com.example.aoc.day02;

import java.io.IOException;
import java.util.ArrayList;
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
		String[] split = lines.getFirst().split(",");
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
		long sum = 0;
		String[] split = lines.getFirst().split(",");
		for (String string : split) {
			long startingElement = Long.parseLong(string.split("-")[0]);
			long endingElement = Long.parseLong(string.split("-")[1]);
			for (long j = startingElement; j <= endingElement; j++) {
				String s = String.valueOf(j);
				sum = getSum(s, sum);
			}
		}
		return String.valueOf(sum);
	}

	private static long getSum(String s, long sum) {
		int half = s.length()/2;
		for (int i = 1; i <= half; i++) {
			List<String> parts = splitByLength(s, i);
			boolean same = isSame(parts);
			if(same) {
				sum += Long.parseLong(s);
				return sum;
			}
		}
		return sum;
	}

	private static List<String> splitByLength(String s, int length) {
		List<String> parts = new ArrayList<>();
		for (int j = 0; j < s.length(); j += length) {
			int end = Math.min(j+length, s.length());
			parts.add(s.substring(j, end));
		}
		return parts;
	}

	private static boolean isSame(List<String> parts) {
		String first = parts.getFirst();
		for (String part : parts) {
			if(!part.equals(first)) {
				return false;
			}
		}
		return true;
	}
}
