


// This is a simple Java RMI (Remote Method Invocation) client program.
// RMI basically means: one Java program can call methods of another Java program 
// running on a different machine/server like it’s a normal objec

// Check installation:
// java -version
// javac -version
// Compile:
// javac Server.java
// javac Client.java
// Run (IMPORTANT ORDER):
// java Server

// (open another terminal)

// java Client

import java.rmi.*;
import java.util.*;


// java.rmi.* → imports classes needed for Remote Method Invocation.
// java.util.* → imports utility classes like Scanner

public class Client {

    // The client is the program that:   connects to the RMI server -  calls remote methods - gets the result

    public static void main(String[] args) throws Exception { 
       // Entry point of the program.   throws Exception avoids writing try-catch everywhere if any error occurs, Java throws the exception automatically 

// Lookup Remote Object:
        MyIntf obj = (MyIntf) Naming.lookup("rmi://localhost/obj");

// This is the most important line

// The client searches for a remote object registered on the server.
// Breaking it:
// Naming.lookup() - Searches the RMI registry.

// "rmi://localhost/obj":
// Means:

// rmi:// → RMI protocol
// localhost → server is running on same computer
// obj → name used when server registered the object


// Naming.rebind("rmi://localhost/obj", new Server()); -   So the server registered itself using the name "obj"
// Type Casting
// (MyIntf)

// lookup() returns a general Remote object.

// So we convert it into MyIntf type to access methods like:

// obj.concat()

        Scanner sc = new Scanner(System.in);
// Scanner Object
// Scanner sc = new Scanner(System.in);
// Used to take user input from keyboard.

        System.out.print("Enter 2 strings: "); // User enters two strings. Example:
// Hello
// World

// Then:
// a = "Hello"
// b = "World"
        String a = sc.nextLine();
        String b = sc.nextLine();

        //  Remote Method Call:
// The method concat() is NOT running inside the client.

It runs on the server machine remotely.

// The client sends:    to the server.

// string a
// string b

// Server executes:

// return a + b;

// Then sends result back.
        System.out.println("Result: " + obj.concat(a, b));


        //  So output becomes:
// Result: HelloWorld
    }
}




// Step 1 — Compile All Files First

// Run:

// javac *.java

// This compiles:

// MyIntf.java
// Server.java
// Client.java

// and creates .class files.

// Step 2 — Run Server FIRST
// java Server

// Output:

// Server running...

// The server must run first because it:

// creates remote object
// starts registry
// waits for clients
// Step 3 — Run Client SECOND

// Open another terminal/Jupyter notebook tab and run:

// java Client

// Then enter strings.

// Example:

// Enter 2 strings:
// Hello
// Java

// Output:

// Result: HelloJava
// Full Order
// 1. javac *.java
// 2. java Server
// 3. java Client

// That’s the correct sequence.

// Why Server First?

// Because client does:

// Naming.lookup("rmi://localhost/obj");

// It searches for object "obj".

// But object exists only after server runs:

// Naming.rebind("rmi://localhost/obj", new Server());