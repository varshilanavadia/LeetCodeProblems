public class FindCel {

    // Naive O(n^2) approach
    public int findCelebrity1(int n){
        for(int i = 0; i < n; i++){
            if(isCelebrity(i, n)){
                return i;
            }
        }
        return -1;
    }

    // Smart O(n) logical deduction
    public int findCelebrity2(int n){
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if(knows(candidate, i)){
                candidate = i;
            }
        }

        return isCelebrity(candidate, n) ? candidate : -1;

    }

    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if(i == j) continue;
            if(knows(j, i) || !knows(i, j)){
                return false;
            }
        }
        return true;
    }
}
