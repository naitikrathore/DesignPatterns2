# DesignPatterns2

Java practice project with examples of:
- Creational design patterns
- Structural design patterns
- Behavioral design patterns
- Multithreading and LLD practice modules

## Prerequisites

- JDK 21
- IntelliJ IDEA (recommended)

## Run In IntelliJ IDEA

1. Clone this repository.
2. Open the project folder in IntelliJ IDEA.
3. Set Project SDK to Java 21.
4. Run any class that contains `public static void main(String[] args)`, for example:
   - `src/ThreadTest.java`
   - `src/StructuralDesignPattern/Main.java`
   - `src/CreationalDesignPattern/Main.java`

## Compile And Run From Terminal

From project root:

```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName } | Set-Content all_sources.txt
cmd /c "javac -encoding UTF-8 @all_sources.txt"
java -cp src ThreadTest
Remove-Item all_sources.txt
```

## Notes

- Build artifacts (`*.class`, `out/`) are ignored via `.gitignore`.
- Local IntelliJ state file `.idea/workspace.xml` is ignored.
