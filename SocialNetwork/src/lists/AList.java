package lists;


import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
    
    private T[] list; 
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public AList() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    
    // constructor with initial capacity parameter
    public AList(int initialCapacity) {
        checkCapacity(initialCapacity); // check if initialCapacity is valid

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1]; // +1 for index adjustment
        list = tempList; // assign to list to initialize it to the array of size initialCapacity + 1 
        numberOfEntries = 0; // initialize number of entries to 0
        initialized = true; // flag that the list is initialized
    } // end constructor

    public void add(T newEntry) { // add new entry to end of list
        checkInitialization();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    } // end add

    public void add(int newPosition, T newEntry) { // add new entry at newPosition, changes size of list
        checkInitialization(); // check if list is initialized
        if (((newPosition <= numberOfEntries + 1) && newPosition >= 1)) { // check if newPosition is valid
            if (newPosition <= numberOfEntries) // if new position is at the end of the list
                makeRoom(newPosition); // make room for new entry
            list[newPosition] = newEntry; // add new entry
            numberOfEntries++; // increment number of entries
            ensureCapacity(); // Ensure enough room for next add
        } else // newPosition is invalid
            throw new IndexOutOfBoundsException(
                    "Entry is out of bounds.");
    } // end add

    public T remove(int givenPosition) { // remove entry at givenPosition, changes size of list
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries) && !isEmpty()) {
            T result = list[givenPosition]; // Get entry to be removed
            // Move subsequent entries towards entry to be removed,
            // unless it is last in list
            if (givenPosition < numberOfEntries) // if givenPosition is not the last entry we remove the gap
                removeGap(givenPosition);
            numberOfEntries--; // Decrease size of list by 1
            return result; // Return reference to removed entry
        } else
            throw new IndexOutOfBoundsException(
                    "Index provided to remove is out of bounds.");
    } // end remove

    public void clear() { // clear list, does not change size of list
        checkInitialization();
        for (int index = 1; index <= numberOfEntries; index++)
            list[index] = null;
        numberOfEntries = 0;
    } // end clear

    public T replace(int givenPosition, T newEntry) {
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries) && !isEmpty()) {
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else
            throw new IndexOutOfBoundsException(
                    "Index provided to replace is out of bounds.");
    } // end replace

    public T getEntry(int givenPosition) {
        checkInitialization();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries) && !isEmpty()) {
            return list[givenPosition];
        } else
            throw new IndexOutOfBoundsException(
                    "Index provided to getEntry is out of bounds.");
    } // end getEntry

    public T[] toArray() { // return array of entries in list
        checkInitialization();

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        }

        return result;
    } // end toArray

    public boolean contains(T anEntry) {
        checkInitialization();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry == list[index])
                found = true;
            index++;
        } // end while

        return found;
    } // end contains

    public int getLength() {
        return numberOfEntries; // the length of the list is the number of entries
    } // end getLength

    public boolean isEmpty() {
        return getLength() == 0; // if the length of the list is 0, the list is empty
    } // end isEmpty







    // professor provided code

    // Doubles the capacity of the array list if it is full.
    // Precondition: checkInitialization has been called.
    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?
            list = Arrays.copyOf(list, newCapacity + 1);
        } // end if
    } // end ensureCapacity

    // Makes room for a new entry at newPosition.
    // Precondition: 1 <= newPosition <= numberOfEntries + 1;
    // numberOfEntries is list's length before addition;
    // checkInitialization has been called.
    private void makeRoom(int newPosition) {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

        int newIndex = newPosition;
        int lastIndex = numberOfEntries;

        // Move each entry to next higher index, starting at end of
        // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    } // end makeRoom

    // Shifts entries that are beyond the entry to be removed to the
    // next lower position.
    // Precondition: 1 <= givenPosition < numberOfEntries;
    // numberOfEntries is list's length before removal;
    // checkInitialization has been called.
    private void removeGap(int givenPosition) {
        assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries;

        for (int index = removedIndex; index < lastIndex; index++)
            list[index] = list[index + 1];
    } // end removeGap

    // Throws an exception if this object is not initialized.
    private void checkInitialization() {
        if (!initialized)
            throw new SecurityException("AList object is not initialized properly.");
    } // end checkInitialization

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

}