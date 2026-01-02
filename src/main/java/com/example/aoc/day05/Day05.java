package com.example.aoc.day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.aoc.util.Utility;

public class Day05 {
	
	public static void main(String[] args) {
		try {
			solve("day05/Input0.txt");
			solve("day05/Input1.txt");
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
		int i = lines.indexOf("");
		List<String> rangeList = lines.subList(0,i);
		List<Long> freshIDList = lines.subList(i+1, lines.size()).stream()
																	.map(Long::valueOf)
																	.toList();
		int count = 0;
		for(Long id : freshIDList) {
			for(String range : rangeList) {
				long lowerLimit = Long.parseLong(range.split("-")[0]);
				long upperLimit = Long.parseLong(range.split("-")[1]);
				if(id >= lowerLimit && id <= upperLimit) {
					count++;
					break;
				}
			}
		}


		return String.valueOf(count);
	}

	private static String partTwo(List<String> lines) {
		return String.valueOf(lines.size());
	}

}
