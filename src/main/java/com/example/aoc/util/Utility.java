package com.example.aoc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utility {
	
	public static List<String> read(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(Utility.class.getClassLoader().getResourceAsStream(filePath))))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
            return lines;
        }
    }

}
