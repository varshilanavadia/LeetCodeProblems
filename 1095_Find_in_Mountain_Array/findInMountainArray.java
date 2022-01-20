/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

interface MountainArray{
    int get(int index);
    int length();
}

public class findInMountainArray implements MountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;

        int peak = findPeak(mountainArr);
        int index = binarySearch(target, mountainArr, 0, peak);
        if(index == -1){
            index = binarySearch(target, mountainArr, peak, mountainArr.length() - 1);
        }
        return index;
    }

    private int binarySearch(int target, MountainArray mountainArr, int left, int right){
        boolean isAscending = mountainArr.get(left) < mountainArr.get(right);

        while(left <= right){
            int mid = left + (right - left)/2;
            int guess = mountainArr.get(mid);
            if(guess == target){
                return mid;
            } else if(guess < target){
                if(isAscending){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(isAscending){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArr){
        int left = 0, right = mountainArr.length()-1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}