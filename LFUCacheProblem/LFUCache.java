/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

import java.util.HashMap;
import java.util.Map;

public  class LFUCache {
    int capacity, size, minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DLLNode> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 1;

        this.cache = new HashMap();
        this.freqMap = new HashMap();
    }

    public int get(int key) {
        Node node = this.cache.get(key);
        if(node == null){
            return -1;
        }
        updateFrequencyPerPolicy(node);
        return node.getValue();
    }

    public java.lang.Integer put(int key, int value) {
        Node node = this.cache.get(key);

        if(node != null){
            node.setValue(value);
            updateFrequencyPerPolicy(node);
        } else {
            Node newNode = new Node(key, value);
            updateFrequencyPerPolicy(newNode);
            this.cache.put(key, newNode);
            this.size++;

            if(this.size > this.capacity){
                DLLNode freqDLL = this.freqMap.get(this.minFreq);
                Node lastNode = freqDLL.removeLast();
                this.cache.remove(lastNode.getKey());
                this.size--;
            }

            this.minFreq = 1;
        }
        return null;
    }

    private void updateFrequencyPerPolicy(Node node){
        int oldFreq = node.getFrequency();
        if(this.freqMap.containsKey(oldFreq)){
            DLLNode oldFreqDLL = this.freqMap.get(oldFreq);
            oldFreqDLL.deleteNode(node);
            if(this.minFreq == oldFreq && oldFreqDLL.length == 0){
                this.minFreq++;
            }
        }
        int newFreq = oldFreq + 1;
        node.setFrequency(newFreq);
        DLLNode newFreqDLL = this.freqMap.getOrDefault(newFreq, new DLLNode());
        newFreqDLL.addNode(node);
        this.freqMap.put(newFreq, newFreqDLL);
    }
}