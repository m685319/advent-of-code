package com.example.aoc.day01;

import java.io.IOException;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day01 {

	public static void main(String[] args) {
		try {
			solve("day01/Input0.txt");
			solve("day01/Input1.txt");
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
		int position = 50;
		int count = 0;
		for (String s : lines) {
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
		return String.valueOf(count);
	}

	private static String partTwo(List<String> lines) {
		int position = 50;
		int count = 0;
		for (String s : lines) {
			char f = s.charAt(0);
			int d = Integer.parseInt(s.substring(1));
			int firstHit;
			if (f == 'L') {
				firstHit = (position == 0) ? 100 : position;
			} else {
				int x = (100 - position) % 100;
				firstHit = (x == 0) ? 100 : x;
			}
			if (d >= firstHit) {
				count += 1 + (d - firstHit) / 100;
			}
			if (f == 'L') {
				position = Math.floorMod(position - d, 100);
			} else {
				position = Math.floorMod(position + d, 100);
			}
		}
		return String.valueOf(count);
	}

}
