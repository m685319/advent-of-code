package com.example.aoc.day03;

import java.io.IOException;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day03 {
	
	public static void main(String[] args) {
		try {
			solve("day03/Input0.txt");
			solve("day03/Input1.txt");
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
		int totalSum = 0;
		for (String line: lines) {
			int firstMax = 0;
			int secondMax = 0;
			int firstMaxIndex = 0;
			for (int i = 0; i < line.length() - 1; i++) {
				int current = line.charAt(i) - '0';
				if(current > firstMax) {
					firstMax = current;
					firstMaxIndex = i;
				}
			}
			for (int i = firstMaxIndex + 1; i < line.length() ; i++) {
				int current = line.charAt(i) - '0';
				if(current > secondMax) {
					secondMax = current;
				}
			}
			int sum = firstMax*10 + secondMax;
			totalSum += sum;
		}
		return String.valueOf(totalSum);
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
