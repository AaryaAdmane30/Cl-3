


// The RMI (Remote Method Invocation) is an API that provides a mechanism to create distributed 
// application in java. The RMI allows an object to invoke methods on an object running in another 
// JVM. 
// The RMI provides remote communication between the applications using two objects stub and skeleton. 
// Understanding stub and skeleton 
// RMI uses stub and skeleton object for communication with the remote object. 
// A remote object is an object whose method can be invoked from another JVM. 

// stub :
// The stub is an object, acts as a gateway for the client side. All the outgoing requests are routed through it. It 
// resides at the client side and represents the remote object. When the caller invokes method on the stub object, it 
// does the following tasks: 
// 1. It initiates a connection with remote Virtual Machine (JVM), 
// 2. It writes and transmits (marshals) the parameters to the remote Virtual Machine (JVM), 
// 3. It waits for the result 
// 4. It reads (unmarshals) the return value or exception, and 
// 5. It finally, returns the value to the caller. 

// skeleton :
// The skeleton is an object, acts as a gateway for the server side object. All the incoming requests are routed 
// through it. When the skeleton receives the incoming request, it does the following tasks: 
// 1. It reads the parameter for the remote method 
// 2. It invokes the method on the actual remote object, and


//  Thus This application demonstrates the use of RMI to create a distributed application for string 
// concatenation, where the server receives two strings from the client, concatenates them, and returns the result 
// to the client






// This code is your Java RMI Server.
// Its job is to:

// create a remote object
// register it
// wait for client requests
// execute methods remotely

// The client asks for work.
// The server actually does the work.






import java.rmi.*;
import java.rmi.server.*; // Imports server-side RMI classes.
import java.rmi.registry.*; // Imports registry classes. - creating RMI registry


//  Class declarartion : Defines a class named Server.
// This class contains:
// remote methods
// registry setup
// server logic



// RMI communication won’t work properly.
public class Server extends UnicastRemoteObject implements MyIntf {

    // extends UnicastRemoteObject


// Makes this object remotely accessible.

// Meaning:
// clients from another process/computer can call its methods.

// Without this: RMI communication won’t work properly.

    Server() throws RemoteException {}
//  So server defines:

//  Remote Method
    public String concat(String a, String b) {

// This is the actual remote method
        return a + b;
    }

// Takes two strings:
// a
// b

// Returns combined string: a +  b

// Client sends:

// Hello
// Java

// Server executes:

// return "Hello" + "Java"; - HelloJava


//     Constructor
// Server() throws RemoteException {}

// Constructor of Server class.

// Runs when object is created:

// new Server()
// Why throws RemoteException?

// Because:

// remote object creation can fail
// networking issues may happen

// Java forces exception handling in RMI.


//  Main Method


    public static void main(String[] args) throws Exception { //  Starts the server.:

        LocateRegistry.createRegistry(1099); 
//         //  Create Registry
// LocateRegistry.createRegistry(1099);
// Creates RMI registry on port 1099.

// Registry is like a contact book.
// It stores:
// object names
// remote object references
// Clients search registry to find remote objects.

// Why 1099?

// Default RMI registry port.

//  Registers the server object in registry.
        Naming.rebind("rmi://localhost/obj", new Server());

        // rebind() - Stores object in registry. -  "Registry, save this object using name 'obj'"
        // "rmi://localhost/obj"
// Meaning:

// rmi:// → RMI protocol
// localhost → same computer
// obj → object name
        System.out.println("Server running...");
    }
}
//  VIva:
// Why extend UnicastRemoteObject?

// To make object remotely accessible.



// Why implement interface?

// Because server must define remote methods declared in interface.

// Why RemoteException?

// Because network communication can fail.

// What is registry?

// A naming service storing remote objects.

// Final Summary

// This server program:

// creates a remote object
// implements remote methods
// starts RMI registry
// registers object using name "obj"
// waits for client requests
// executes methods remotely
// sends results back to client