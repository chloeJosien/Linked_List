package lists_2420;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by chloe on 2/17/2017.
 */
public class Linked_List_2420<Type> implements List_2420<Type> {
    private Node firstElement = null;

    /**
     * this method must NOT use recursion
     * for our purposes DO NOT use the Node toString method  here
     * <p>
     * Creates a string that describes the contents of the list, starting with the size in
     * parentheses for example, a list of the numbers 0, 1, 2, 3 would print as:
     * <p>
     * "(4) [0]--> [1]--> [2]--> [3]--> null"
     * <p>
     * an empty list should simply return the string "empty"
     * <p>
     * WARNING: the syntax must be exact.  "open parenthesis, size, close parenthesis, space,
     * open square bracket, data, close square bracket, hyphen, hyphen, greater than space,
     * ... null"
     *
     * @return a string representation of this chain of nodes
     */
    public String toString() {
        if (firstElement == null) {
            return "empty";
        }
        if (firstElement.length() == 0) {
            return "empty";
        }

        String nodeList = "(" + firstElement.length() + ") ";
        Node current = firstElement;
        for (int count = 0; count < firstElement.length(); count++) {
            nodeList += "[" + current.theData + "]" + "--> ";
            current = current.nextNode;
        }
        return nodeList + "null";
    }

    /**
     * places a new node at the beginning of the list
     *
     * @param data - the data to be given to the new node
     */
    @Override
    public void add_first(Type data) {
        if (firstElement == null) {
            firstElement = new Node(data, null);
        } else {
            Node<Type> newElement = new Node<Type>(data, firstElement);
            firstElement = newElement;
        }
    }

    /**
     * Places a new node at the end of the list
     *
     * @param data - the data to be placed in the node
     */
    @Override
    public void add_last(Type data) {
        if (firstElement == null) {
            firstElement = new Node(data, null);
        } else {
            Node current = firstElement;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            Node newElement = new Node<Type>(data, null);
            current.nextNode = newElement;
        }
    }

    /**
     * Places a new n  ode in the middle of the list
     *
     * @param after - the position of the node before the newly inserted node
     * @param data  - the element to be placed in
     */
    @Override
    public void add_middle(int after, Type data) {
        if (firstElement == null) {
            add_first(data);
        }
        Node<Type> current = firstElement;
        for (int count = 0; count < after; count++) {
            current = current.nextNode;
        }
        Node<Type> newNode = new Node<Type>(data, current.nextNode);
        current.nextNode = newNode;

    }

    /**
     * removes all the nodes in the list
     */
    @Override
    public void clear() {
        firstElement = null;
    }

    /**
     * Finds the whether of not the item is in the
     * list iteratively.
     *
     * @param item - the item being looked for
     * @return - true or false if found or not
     */
    @Override
    public boolean contains(Type item) {

        if (firstElement == null) {
            return false;
        }
        Node current = firstElement;
        for (int count = 0; count < firstElement.length(); count++) {
            if (current.theData == item) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    /**
     * Finds the whether of not the item is in the
     * list using recursion
     *
     * @param item - the item being looked for
     * @return - true or false if found or not
     */
    @Override
    public boolean contains_recursive(Type item) {
        if (firstElement == null) {
            return false;
        }
        Node current = firstElement;
        if (current.theData == item) {
            return true;
        }
        return current.nextNode.contains_recursive(item);
    }

    /**
     * Finds and returns the first element in the list
     *
     * @return - the first element
     * @throws NoSuchElementException if not found
     */
    @Override
    public Type get_first() throws NoSuchElementException {
        if (firstElement == null) {
            throw new NoSuchElementException();
        }
        Type element = (Type) firstElement.theData;
        return element;
    }

    /**
     * finds the last element in the list
     *
     * @return the last element in the list
     * @throws NoSuchElementException if not found
     */
    @Override
    public Type get_last() throws NoSuchElementException {
        if (firstElement == null) {
            throw new NoSuchElementException();
        }
        Node current = firstElement;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        return (Type) current.theData;
    }

    /**
     * Removes the first node in the list
     *
     * @return - the element that was removed
     * @throws NoSuchElementException - if not found
     */
    @Override
    public Type remove_first() throws NoSuchElementException {
        if (firstElement == null) {
            throw new NoSuchElementException();
        }
        Type data = (Type) firstElement.theData;
        Node current = firstElement.nextNode;
        firstElement.nextNode = null;
        firstElement = current;
        return data;
    }

    /**
     * Removes the last node in the list
     *
     * @return - the element that was removed
     * @throws NoSuchElementException if not found
     */
    @Override
    public Type remove_last() throws NoSuchElementException {
        if (firstElement == null) {
            throw new NoSuchElementException();
        }
        Node current = firstElement;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        Type data = (Type) current.theData;
        current = null;
        firstElement = current;
        return data;
    }

    /**
     * Finds the size of the list iteratively
     *
     * @return - the size of the list
     */
    @Override
    public int size() {
        if (firstElement == null) {
            return 0;
        }
        int count = 0;
        Node current = firstElement;
        while (current.nextNode != null) {
            count++;
            current = current.nextNode;
        }
        //this is to account for the final node
        count++;
        return count;
    }

    /**
     * with a single traversal of the list, in place,
     * swap the order of the entire list, such that
     * that which was last is first and that which was first is last.
     */
    @Override
    public void reverse() {
        Node current = firstElement.nextNode;
        Node previous = firstElement;
        reverseRecursion(current, previous);
        previous.nextNode = null;
    }

    /**
     * Helper method for reverse. Traverses the array
     * and using recursion reverses the order.
     *
     * @param curent   - the current node position
     * @param previous - the previous node position
     */
    public void reverseRecursion(Node curent, Node previous) {
        if (curent.nextNode == null) {
            firstElement = curent;
            firstElement.nextNode = previous;
            return;
        } else {
            reverseRecursion(curent.nextNode, curent);
            curent.nextNode = previous;
        }
    }

    /**
     * finds the length of the list using recursion
     *
     * @return - the length of the list
     */
    @Override
    public int compute_size_recursive() {
        if (firstElement == null) {
            return 0;
        }
        return firstElement.length();
    }

    /**
     * @return an ArrayList of the data in the linked list in reverse order.
     * <p>
     * recursively traverse the list, building up an ArrayList of the data.
     * <p>
     * use the Node<Type>.to_ArrayList_post_recurse() function
     */
    @Override
    public ArrayList to_ArrayList_post_recurse() {
        return firstElement.to_ArrayList_post_recursive();
    }

    /**
     * iteratively traverse the list, building up an ArrayList of the data in order.
     */
    @Override
    public ArrayList to_ArrayList() {
        ArrayList nodeList = new ArrayList();
        Node current = firstElement;
        for (int count = 0; count < firstElement.length(); count++) {
            nodeList.add(current.theData);
            current = current.nextNode;
        }
        return nodeList;
    }


    protected static class Node<Type> {
        //create a data element of the Given Type
        private Type theData;
        //create reference to another node
        private Node<Type> nextNode;

        //write a constructor that simplifies building an initial node
        Node(Type the_data, Node<Type> after_me) {
            this.theData = the_data;
            this.nextNode = after_me;
        }

        /**
         * This function must be written recursively.
         *
         * @return the length of this "chain of nodes", including self.
         * <p>
         * Note: 1) it doesn't matter if something (or multiple somethings) points to this node,
         * 2) if this node doesn't point at anything, then the size would be 1.
         */
        public int length() {
            if (nextNode == null)
                return 1;
            else
                return nextNode.length() + 1;
        }

        /**
         * recursive determine if the item is in this node or the nodes after
         *
         * @param item - needle
         * @return true if item in chain
         */
        boolean contains_recursive(Type item) {

            if (theData.equals(item)) {
                return true;
            } else if (nextNode == null) {
                return false;
            } else
                return nextNode.contains_recursive(item);
        }


        /**
         * This function must be written recursively (using a helper method, with the
         * arraylist as a parameter, to do the recursion)
         * <p>
         * Create an array list containing the data from this node and all nodes after it.
         * <p>
         * In the helper method, add the data to the array list after the recursive call,
         * thus "reversing" the list.
         */
        ArrayList<Type> to_ArrayList_post_recursive() {
            ArrayList<Type> list = new ArrayList<Type>();
            return changeToArrayList(list);
        }

        /**
         * recursively goes through the link list to add them to
         * an arrayList
         *
         * @param array - an array list of type
         * @return - the arraylist
         */
        private ArrayList<Type> changeToArrayList(ArrayList<Type> array) {
            if (nextNode == null) {
                array.add(theData);
                return array;
            }
            nextNode.changeToArrayList(array);
            array.add(theData);
            return array;
        }

        /**
         * Creates a string that describes the current node and all following nodes, for
         * example, a list of the nubmers 0, 1, 2, 3 would print as:
         * <p>
         * "[0]--> [1]--> [2]--> [3]--> null"
         * <p>
         * WARNING: the syntax must be exact.
         * "open square bracket, data, close square bracket, hyphen, hyphen, greater than space,
         * ... null"
         *
         * @return a string representation of this chain of nodes
         */
        public String toString() {
            String results;
            results = "[" + theData + "]" + "--> ";
            if (nextNode == null) {
                return results;
            } else
                return results + nextNode.toString() + "null";
        }
    }
}
