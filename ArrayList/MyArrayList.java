import java.util.*;

class MyArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(containerWithMostWater(list));

    }

    public static int containerWithMostWater(ArrayList<Integer> height) {
        int maxWater = 0, lp = 0, rp = height.size() - 1;
        while (lp < rp) {
            int h = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currArea = h * width;
            maxWater = Math.max(maxWater, currArea);
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
}