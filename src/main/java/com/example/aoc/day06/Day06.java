package com.example.aoc.day06;

import java.io.IOException;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day06 {
	
	public static void main(String[] args) {
		try {
			solve("day06/Input0.txt");
			solve("day06/Input1.txt");
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
		int cols = lines.get(0).trim().split("\\s+").length;

		String[][] grid = new String[rows][cols];

		for (String line : lines) {
			grid[lines.indexOf(line)] = line.trim().split("\\s+");
		}

			long totalSum = 0;
			for (int j = 0; j < cols; j++) {
				String current = grid[rows-1][j];

				if(current.equals("*")) {
					long product = 1;
					for (int i = 0; i < rows - 1; i++) {
						product *= Integer.parseInt(grid[i][j]) ;
					}
					totalSum += product;
				} else {
					long sum = 0;
					for (int i = 0; i < rows - 1; i++) {
						sum += Integer.parseInt(grid[i][j]) ;
					}
					totalSum += sum;
				}
			}

		return String.valueOf(totalSum);
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
