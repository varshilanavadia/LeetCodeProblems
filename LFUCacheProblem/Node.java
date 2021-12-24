public class Node{
    Integer key, value, frequency;
    Node next, prev;

    public Node(Integer key, Integer value){
        this.key = key;
        this.value = value;
        this.frequency = 0;
    }

    public int getKey(){
        return this.key;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }
}
