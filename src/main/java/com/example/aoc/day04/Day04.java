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
		int rows = lines.size();
		int cols = lines.get(0).length();
		char[][] grid = new char[rows][cols];
		for (String line : lines) {
			grid[lines.indexOf(line)] = line.toCharArray();
		}
		int count = countAccessble(grid, rows, cols);
		return String.valueOf(count);
	}

	private static int countAccessble(char[][] grid, int rows, int cols) {
		int accessibleCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				char current = grid[i][j];
				if (current != '@') {
					continue;
				}
				boolean canAccess = isAccessible(grid, i, j, rows, cols);
				if (canAccess) {
					accessibleCount++;
				}
			}
		}
		return accessibleCount;
	}

	private static boolean isAccessible(char[][] grid, int i, int j, int rows, int cols) {
		int count = 0;
		if (j + 1 < cols) {
			count += grid[i][j + 1] == '@' ? 1 : 0;
		}
		if (j - 1 >= 0) {
			count += grid[i][j - 1] == '@' ? 1 : 0;
		}

		if (i - 1 >= 0) {
			count += grid[i - 1][j] == '@' ? 1 : 0;
			if (j + 1 < cols) {
				count += grid[i - 1][j + 1] == '@' ? 1 : 0;
			}
			if (j - 1 >= 0) {
				count += grid[i - 1][j - 1] == '@' ? 1 : 0;
			}
		}

		if (i + 1 < rows) {
			count += grid[i + 1][j] == '@' ? 1 : 0;
			if (j + 1 < cols) {
				count += grid[i + 1][j + 1] == '@' ? 1 : 0;
			}
			if (j - 1 >= 0) {
				count += grid[i + 1][j - 1] == '@' ? 1 : 0;
			}
		}

		if (count < 4) {
			return true;
		}
		return false;
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
