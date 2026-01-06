# 🎄 Advent of Code 2025 — Java Solutions

Solutions for Advent of Code 2025, implemented in Java 21 using Maven.
Each day’s puzzle is organized as a separate Java package, with a simple main-based runner and shared utilities.

---

## 📌 Summary

This repository contains my daily solutions for Advent of Code 2025.
The focus is on:
* Clean and readable Java
* Minimal frameworks
* Fast iteration while solving puzzles
* Clear separation of Part 1 and Part 2
* Each day can be executed independently.

---

## 📁 Repository Structure

```
advent-of-code/
├─ pom.xml
├─ README.md
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/example/aoc/
│  │  │     ├─ day01/
│  │  │     │  └─ Day01.java
│  │  │     ├─ day02/
│  │  │     └─ ...
│  │  │     └─ util/
│  │  │        └─ Utility.java
│  │  └─ resources/
│  │     ├─ day01/
│  │     │  ├─ input0.txt   # sample input
│  │     │  └─ input1.txt   # actual puzzle input
│  │     ├─ day02/
│  │     └─ ...
└─ target/
```

---

## 🧠 Design Approach

One package per day (day01, day02, …)

Each day has:

A `main()` method for execution

`partOne()` and `partTwo()` methods

Inputs are loaded from `src/main/resources/dayXX`

Shared helpers live in `util/Utility.java`

---

## 🧪 Input Handling

Inputs are read via a small utility helper:

```bash
List<String> lines = Utility.read("day01/input1.txt");
```

Typical usage pattern:

```bash
solve("day01/input0.txt"); // test input
solve("day01/input1.txt"); // real input
```

---

## ▶️ Running Solutions
Run a specific day (from IDE)

Simply run the main() method inside:

```bash
com.example.aoc.dayXX.DayXX
```

Run from command line:

```bash
mvn clean compile
```

Then run using your IDE or via java command if desired.

---

## Tech Stack & Conventions

* Java 21
* Maven
* No Spring / frameworks (intentional)
* Immutable-first mindset where possible
* Simple String, List, and algorithmic solutions
* Code optimized for clarity over cleverness
