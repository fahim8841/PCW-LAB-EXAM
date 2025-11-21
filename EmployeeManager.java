import java.io.*;
import java.util.*;

public class EmployeeManager {
// Method to read employee data
static String readFromFile() throws Exception {
try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.FILE_NAME)
))) {
return reader.readLine();
}
}
// Method to overwrite file
static void writeToFile(String data) throws Exception {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"))) {
writer.write(data);
}
}
// Method to append data
static void appendToFile(String data) throws Exception {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true))) {
 writer.write(data);
}
}
public class Constants {
    public static final String FILE_NAME = "employees.txt";
}
    public static void main(String[] args) {
if (args.length == 0) {
System.out.println("Error: No arguments provided.");
return;
}
if (args[0].equals("l")) {
try {
String line = readFromFile();
String employees[] = line.split(",");
for (String emp : employees) {
System.out.println(emp);
}
}
catch (Exception e) {}
}else if (args[0].equals("s")) {
try {
String line = readFromFile();
String employees[] = line.split(",");
Random random = new Random();
int randomindex = random.nextInt(employees.length);
System.out.println(employees[randomindex]);
} 
catch (Exception e) {}
}else if (args[0].contains("+")) {
try {
String n = args[0].substring(1);
appendToFile(", " + n);
} 
catch (Exception e) {}
}else if (args[0].contains("?")) {
try {
String l = readFromFile();
String e[] = l.split(",");
String searchName = args[0].substring(1);

boolean found = false;
for (int i = 0; i < e.length && !found; i++) {
if (e[i].equals(searchName)) {
System.out.println("Employee found!");
found = true;
}
}
} 
catch (Exception e) {}
}else if (args[0].contains("c")) {
try {
String l = readFromFile();
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
} catch (Exception e) {}
}
else if (args[0].contains("u")) {
try {
String line = readFromFile();
String e[] = line.split(",");
String n = args[0].substring(1);
for (int i = 0; i < e.length; i++) {
if (e[i].equals(n)) {
e[i] = "Updated";
}
}
writeToFile(String.join(",", e));
} catch (Exception e) {}
}
else if (args[0].contains("d")) {
try {
String line = readFromFile();
String employees[] = line.split(",");
String n = args[0].substring(1);
List<String> list = new ArrayList<>(Arrays.asList(employees));
list.remove(n);
writeToFile(String.join(",", list));
} catch (Exception e) {}
}
}
}