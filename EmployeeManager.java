//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if (args.length == 0) {
    System.out.println("Error: No arguments provided.");
    System.out.println("Usage:");
    System.out.println("  l      -> List all employees");
    System.out.println("  s      -> Show random employee");
    System.out.println("  +Name  -> Add employee");
    System.out.println("  ?Name  -> Search employee");
    System.out.println("  c      -> Count words");
    System.out.println("  uName  -> Update employee");
    System.out.println("  dName  -> Delete employee");
    return;   
}
if (args[0].equals("l")) {
System.out.println("Loading data ...");
try {
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String line = reader.readLine();
String employees[] = line.split(",");
for (String emp : employees) {
System.out.println(emp);
}
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].equals("s")) {
System.out.println("Loading data ...");
try {
BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String line = r.readLine();
System.out.println(line);
String employees[] = line.split(",");
Random random = new Random();
int randomindex = random.nextInt(employees.length);
System.out.println(employees[randomindex]);
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("+")) {
System.out.println("Loading data ...");
try {
BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true));
String n = args[0].substring(1);
writer.write(", " + n);
writer.close();
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("?")) {
System.out.println("Loading data ...");
try {
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String l = reader.readLine();
String e[] = l.split(",");
boolean found = false;
String searchName = args[0].substring(1);
for (int i = 0; i < e.length && !found; i++) {
if (e[i].equals(searchName)) {
System.out.println("Employee found!");
found = true;
}
}
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("c")) {
System.out.println("Loading data ...");
try {
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String l = reader.readLine();
char[] characters = l.toCharArray();
boolean inWord = false;
int count = 0;
for (char ch : characters) {
if (ch == ' ') {
if (!inWord) {
count++;
inWord = true;
} else {
inWord = false;
}
}
}
System.out.println(count + " word(s) found " + characters.length);
} 
catch (Exception e) {}
System.out.println("Data Loaded.");
} else if (args[0].contains("u")) {
System.out.println("Loading data ...");
try {
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String line = reader.readLine();
String e[] = line.split(",");
String n = args[0].substring(1);
for (int i = 0; i < e.length; i++) {
if (e[i].equals(n)) {
e[i] = "Updated";
}
}
BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
writer.write(String.join(",", e));
writer.close();
} 
catch (Exception e) {}
System.out.println("Data Updated.");
} else if (args[0].contains("d")) {
System.out.println("Loading data ...");
try {
BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("employees.txt")));
String line = reader.readLine();
String employees[] = line.split(",");
String n = args[0].substring(1);
List<String> list = new ArrayList<>(Arrays.asList(employees));
list.remove(n);
BufferedWriter writer = new BufferedWriter(
new FileWriter("employees.txt"));
writer.write(String.join(",", list));
writer.close();
} 
catch (Exception e) {}
System.out.println("Data Deleted.");
}
}
}
