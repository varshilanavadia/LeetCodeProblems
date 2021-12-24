public class Main2 {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lruCache = new LRUCache(capacity);
        System.out.println(lruCache.put(1, 1));
        System.out.println(lruCache.put(2, 2));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.put(3, 3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.put(4, 4));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
