/*
* Given an array, determine if the given set of numbers form a winning hand in a simplified version of Mahjong. Each
* number represents a tile in the game of Mahjong. Each tile can be numbered between 1 and 9.
*
* A set is a group of 3 tiles of the same number, for eg [3, 3, 3] or [4, 4, 4]
* A street is group of 3 tiles that have consecutive numbers, for eg [1, 2, 3] or [4, 5, 6]
* A pair is a group of 2 tiles of the same number, for eg [2, 2] or [6, 6]
*
* A winning hand in Mahjong is one which has 1 pair and 4 set/street.
*
* For eg.
* Input : [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 7, 8]
* Output : true -> [[1, 2, 3], [1, 2, 3], [4, 4], [5, 5, 5], [6, 7, 8]]
*               OR [[1, 1], [2, 3, 4], [2, 3, 4], [5, 5, 5], [6, 7, 8]]
*
* Input : [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9]
* Output : false -> cannot form 1 pair and 4 set/street
* */

import java.util.*;

public class MahjongTiles {
    public static boolean isWinningHand(List<Integer> tiles){
        tiles.sort(Comparator.naturalOrder());
        System.out.println(tiles);
        return mahjongHelper(tiles, false);
    }

    private static boolean mahjongHelper(List<Integer> tiles, boolean pairFound) {
        if(tiles.isEmpty()){
            return true;
        }

        boolean pair = false, set = false, street = false;
        if(!pairFound && tiles.get(0).equals(tiles.get(1))){
            List<Integer> tilesCopy = new ArrayList<>(tiles);
            tilesCopy.remove(new Integer(tiles.get(0)));
            tilesCopy.remove(new Integer(tiles.get(1)));
            pair = mahjongHelper(tilesCopy, true);
            if(pair){
                System.out.println(Arrays.asList(tiles.get(0), tiles.get(1)));
            }
        }

        if(tiles.size() > 2 && tiles.get(0).equals(tiles.get(1)) && tiles.get(0).equals(tiles.get(2))){
            List<Integer> tilesCopy = new ArrayList<>(tiles);
            tilesCopy.remove(new Integer(tiles.get(0)));
            tilesCopy.remove(new Integer(tiles.get(1)));
            tilesCopy.remove(new Integer(tiles.get(2)));
            set = mahjongHelper(tilesCopy, pairFound);
            if(set){
                System.out.println(Arrays.asList(tiles.get(0), tiles.get(1), tiles.get(2)));
            }
        }

        if(tiles.contains(tiles.get(0) + 1) && tiles.contains(tiles.get(0) + 2)){
            List<Integer> tilesCopy = new ArrayList<>(tiles);
            tilesCopy.remove(new Integer(tiles.get(0)));
            tilesCopy.remove(new Integer(tiles.get(0) + 1));
            tilesCopy.remove(new Integer(tiles.get(0) + 2));
            street = mahjongHelper(tilesCopy, pairFound);
            if(street){
                System.out.println(Arrays.asList(tiles.get(0), tiles.get(0) + 1, tiles.get(0) + 2));
            }
        }

        return pair || set || street;
    }

    public static void main(String[] args) {
        System.out.println(isWinningHand(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 7, 8)));
        System.out.println(isWinningHand(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9)));
        System.out.println(isWinningHand(Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 6, 6, 6, 8, 8, 8)));
        System.out.println(isWinningHand(Arrays.asList(2, 5, 4, 3, 5, 3, 4, 2, 2, 8, 7, 8, 7, 7)));
        System.out.println(isWinningHand(Arrays.asList()));

        System.out.println(Arrays.asList(Collections.singletonList(new Random().ints(14, 1, 10).toArray())));

    }
}