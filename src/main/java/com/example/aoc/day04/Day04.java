package com.example.aoc.day04;

import java.io.IOException;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day04 {
	
	public static void main(String[] args) {
		try {
			solve("day04/Input0.txt");
			solve("day04/Input1.txt");
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
		return String.valueOf(lines.size());
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
