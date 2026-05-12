import java.rmi.*;

public interface MyIntf extends Remote {
    String concat(String a, String b) throws RemoteException;
}



// // 1) This code is the RMI Interface.

// This interface file is needed because both client and server must agree on the same method structure in Java RMI.
// Without the interface, the client would not know:


// what methods exist
// what parameters to send

// what type of result comes back

// 2) You do NOT “run” the interface file separately 😭

// MyIntf.java is only a definition/contract file.

// It gets:

// compiled
// used by client and server

// but it does not have a main() method, so it cannot run independently.

// What You Actually Run

// You only run:

// 1. Server
// 2. Client

// It’s basically the common language between client and server.
// It acts like a contract between the client and server.

// It tells:

// what method can be called remotely
// method name
// parameters
// return type

// It does NOT do the actual work.
// It only defines the method structure.




// 2) Step 1 — Compile ALL Files
// javac *.java

// This compiles:

// MyIntf.java
// Server.java
// Client.java
// Step 2 — Run Server
// java Server

// Output:

// Server running...
// Step 3 — Run Client

// Open another terminal and run:

// java Client
// Why Interface Isn’t Run

// Because it only contains:

// String concat(String a, String b);

// No executable code.

// No:

// public static void main(String[] args)

// So Java cannot start it.

// Think Like This
// File	Purpose
// MyIntf.java	Defines methods
// Server.java	Executes methods
// Client.java	Calls methods



//  4)  How to run :

// To compile your Java RMI files, you use the javac command.

// But first, make sure:

// JDK is installed
// javac works

// Test in CMD:

// javac -version

// If you see a version number, you’re ready ✅

// Your Files

// You should have:

// MyIntf.java
// Server.java
// Client.java

// all inside the same folder.

// Method 1 — Compile All Files Together (Easiest)

// Open terminal/CMD in that folder and run:

// javac *.java

// This compiles all Java files together.

// What Happens After Compilation?

// Java creates:

// MyIntf.class
// Server.class
// Client.class

// These .class files are bytecode files executed by JVM.

// Method 2 — Compile One by One

// You can also compile individually:

// javac MyIntf.java
// javac Server.java
// javac Client.java

// But compiling together is easier.

// After Compilation

// Run server first:

// java Server

// Then run client in another terminal:

// java Client
// In Jupyter Notebook

// After installing Java properly:

// Compile
// !javac *.java
// Run Server
// !java Server
// Run Client

// In another notebook/terminal:

// !java Client
