public class Sol460 {
    public static void main(String[] args) {
        int capacity = 2;
        LFUCache lfuCache = new LFUCache(capacity);
        System.out.println(lfuCache.put(1, 1));
        System.out.println(lfuCache.put(2, 2));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.put(3, 3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.put(4, 4));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
