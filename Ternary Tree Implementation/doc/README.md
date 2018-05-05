**THIS README CONTAINS ALL THE DOCUMENTATION AND EXPLANATION OF THE MANY DATA STRUCTURES USED IN THIS PROJECT** 
**CHECK OUT THE CLASSES THEMSELVES IF QUESTIONS REMAIN AS TO HOW THEY IMPLEMENT THE UNDERLYING DATA STRUCTURE**

***

EmptyQueueException.java 

    - Runtime exception that is thrown to let the user know that a specific action on a Queue cannot be performed because the Queue is actually empty.

EmptyTreeException.java

    - Runtime exception that is thrown to let the user know that a specific action on a Queue cannot be performed because the tree is actually empty. 

LinkedQueue.java

    - Implementation of a Queue using a chain of nodes and head and tail references so as for quick searching. 

LinkedStack.java

    - A Stack data structure where the entries are stored as a chain of nodes. 

QueueInterface.java 

    - Interface abstraction for a Queue that the LinkedQueue.java implements. 

StackInterface.java

    - Interface abstraction for a Stack that the LinkedStack.java implements.

TernaryNode.java 

    - The node data structure that a "TernaryTree" data structure relies on to make up the tree with. The node contains information about the data within it as well as containing three possible references for children nodes. 

TernaryTree.java 

    - The tree data structure that is the heart/crux of this entire /src/ folder. This is the file that contains the commands for executing and creating a "TernaryTree" data structure to hold data.

TernaryTreeInterface.java 

    - Interface abstraction for a TernaryTree that the TernaryTree.java implements. 

TernaryTreeTester.java 

    - Tester class for the "TernaryTree" data structure to prove that it works correctly and as expected. 

TreeInterface.java

    - Interface abstraction for a TernaryTree that is extended by TernaryTreeInterface.java and ultimately implemented by TernaryTree.java

TreeIteratorInterface.java 

    - Interface abstraction for a TernaryTree that is extended by TernaryTreeInterface.java and ultimately implemented by TernaryTree.java