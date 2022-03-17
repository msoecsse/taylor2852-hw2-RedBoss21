# CS2852 Homework 2

This will be the first of several assignments where you will be comparing the time complexity of different data structures. To do this, we are going to create some very basic implementations of an `ArrayList` and `Linked List` class and count the number of times the elements of the `List` are accessed to accomplish the same set of tasks.


### SimpleList\<E>

The `SimpleList` interface defines the public methods used by the implementing classes. Both of your `Lists` should implement this interface.


### SimpleArrayList\<E>

The `SimpleArrayList` class will have an additional static int variable *`accessCount`* initialized to zero. that will keep track of the number of element accesses that have been performed. In addition to overriding the abstract methods inherited from the `SimpleList` interface, it will also have:

* a no-parameter constructor, 
* a `resetCountAccess()` method to reset the *`accessCount`* variable back to zero, 
* a private `reallocate()` method to increase the size of the backing array when needed. You must implement `reallocate()` without using `Arrays.copyOf`, as you will need to keep track of all the element accesses.

### SimpleLinkedList\<E>

The `SimpleLinkedList` class will, similar to `SimpleArrayList`, have

* an *`accessCount`* variable, 
* a no-parameter constructor, 
* a `resetCountAccess()` method.
* It will also have a private `getNode()` method that will find and return a `Node` from the `List` at a given index. 
* There will also be a private inner class `Node<E>` that will be used by the `List`.

### Access Count

In your `SimpleList` implementations, whenever an element or field from the `List` is being accessed, whether it is accessing an array `data[i]` or a Node (`head == null, node = node.next, etc`) or the `size` field, that `List`'s *`accessCount`* variable should be incremented.

### toString()

The `toString()` methods in both `List`s are merely meant to be a convenience method to help you test and troubleshoot your implementation. You do not need to include access count incrementing here.

### Test Driver
A test driver and sample data has been included to verify your implementation. Note that your actual values may differ slightly from the sample output, though they should be fairly close and proportionally similar.

### Sample Run
<pre>
After add:
Array List: 90
Linked List: 524

After sort:
Array List: 1045
Linked List: 18058
</pre>

![HW2 UML](HW2UML.png?raw=true)
