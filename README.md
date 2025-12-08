# Advent of Code — Solutions

Repository containing solutions for Advent of Code 2025, implemented using Java 21 in a Maven multi-module mono-repo.

---

## Summary

This repository hosts implementations for the daily Advent of Code puzzles. Each day is isolated in its own module, with shared utilities placed in the `shared` module.

> 

---

## Repository layout

```
/ (root)
├─ README.md
├─ pom.xml
├─ shared/
├─ day01/
├─ day02/
└─ ...
```

Each `dayXX` module contains:

* Solution code under `src/main`
* Tests under `src/test`
* Local `input/` folder

---

## Conventions

* Java 21
* Maven multi-module build
* Conventional Commits
* Unit tests based on example inputs

---

## Running

Run all modules:

```bash
mvn -T 1C verify
```

Run a single module:

```bash
cd day01
mvn spring-boot:run
```
