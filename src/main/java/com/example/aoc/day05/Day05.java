package com.example.aoc.day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int j = lines.indexOf("");
		List<String> rangeList = lines.subList(0,j);
		List<long[]> ranges = new ArrayList<>();

		long count = 0;
		for(String range : rangeList) {
			long lowerLimit = Long.parseLong(range.split("-")[0]);
			long upperLimit = Long.parseLong(range.split("-")[1]);
			ranges.add(new long[]{lowerLimit, upperLimit});
		}
		ranges.sort(Comparator.comparingLong(a -> a[0]));
		long currentLowerLimit = ranges.getFirst()[0];
		long currentUpperLimit = ranges.getFirst()[1];

		for(int i = 1; i < ranges.size(); i++) {
			long start = ranges.get(i)[0];
			long end = ranges.get(i)[1];

			if(start <= currentUpperLimit) {
				currentUpperLimit = Math.max(currentUpperLimit, end);
			} else {
				count += currentUpperLimit - currentLowerLimit + 1;
				currentLowerLimit = start;
				currentUpperLimit = end;
			}
		}
		count += currentUpperLimit - currentLowerLimit + 1;
		return String.valueOf(count);
	}

}
