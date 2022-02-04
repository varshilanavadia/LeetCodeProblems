/**
 * Describe how you could use a single array to implement three stacks
 */

public class ThreeInOne{
    public static void main(String[] args) {
        simulateFixedMultiStack();


    }

    private static void simulateFixedMultiStack() {
        FixedMultiStack fixedMultiStack = new FixedMultiStack(3);
        fixedMultiStack.push(0, 1);
        fixedMultiStack.push(1, 4);
        fixedMultiStack.push(2, 7);

        System.out.println(fixedMultiStack.peek(0));
        System.out.println(fixedMultiStack.peek(1));
        System.out.println(fixedMultiStack.peek(2));

        fixedMultiStack.push(1, 5);

        System.out.println(fixedMultiStack.peek(0));
        System.out.println(fixedMultiStack.peek(1));
        System.out.println(fixedMultiStack.peek(2));

        System.out.println(fixedMultiStack.pop(1));

        System.out.println(fixedMultiStack.peek(0));
        System.out.println(fixedMultiStack.peek(1));
        System.out.println(fixedMultiStack.peek(2));

        fixedMultiStack.push(1, 6);
        fixedMultiStack.push(1, 7);

        System.out.println(fixedMultiStack.peek(0));
        System.out.println(fixedMultiStack.peek(1));
        System.out.println(fixedMultiStack.peek(2));
    }
}

class FixedMultiStack{
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        int numOfStacks = 3;
        this.stackCapacity = stackCapacity;
        this.sizes = new int[stackCapacity];
        this.values = new int[stackCapacity * numOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if(isFull(stackNum)){
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[getTopIndex(stackNum)] = value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new StackEmptyException();
        }
        return values[getTopIndex(stackNum)];
    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new StackEmptyException();
        }
        int topIndex = getTopIndex(stackNum);
        int returnVal = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return returnVal;
    }

    private int getTopIndex(int stackNum) {
        int offset = stackNum * this.stackCapacity;
        int size = this.sizes[stackNum];
        return offset + size - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == this.stackCapacity;
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
}

class FullStackException extends RuntimeException{
    public FullStackException() {
        this("Stack is full.");
    }

    public FullStackException(String message) {
        super(message);
    }
}

class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        this("Stack is empty.");
    }

    public StackEmptyException(String message) {
        super(message);
    }
}