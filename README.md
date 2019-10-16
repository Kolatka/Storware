# How to install
Clone this repository and then build package with:
```
$ mvn package
```

# How to use
To run this app type command below. You need to specify location of the file. Also you can use -full parameter to get a result with every arithmetical operation.
```
$ java -jar target\calculator-1.0.jar <file> [-full]
```

# Examples
File:
```
add 2 
multiply 3 
apply 10
```
---
**Example 1:**

Input:
```
$ java -jar target\calculator-1.0.jar target\example1.txt
```
Output:
```
36.0
```
*(Instructions are ignoring mathematical precedence so it's 10 + 2 = 12 and then 12 * 3 = 36.)*

---
**Example 2:**

Input:
```
$ java -jar target\calculator-1.0.jar target\example1.txt -full
```
Output:
```
10.0 + 2.0 * 3.0 = 36.0
```
