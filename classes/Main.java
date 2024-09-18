package classes;

import java.util.*;

public class Main {  

    public static void floodFill(List<List<Integer>> img, 
                                 int x, int y, int newClr) {
        int prevClr = img.get(x).get(y);
        if (prevClr == newClr) 
            return;
        dfs(img, x, y, prevClr, newClr);
    }

    public static void dfs(List<List<Integer>> img, int x,
                          int y, int prevClr, int newClr) {
      
        // Base case: if the current pixel is not the
        // same as the previous color
        if (img.get(x).get(y) != prevClr) {
            return;
        }

        // Marking it as the new color
        img.get(x).set(y, newClr);

        // Moving up, right, down, and left one by one
        int n = img.size();
        int m = img.get(0).size();
        if (x - 1 >= 0) {
            dfs(img, x - 1, y, prevClr, newClr);
        }
        if (y + 1 < m) {
            dfs(img, x, y + 1, prevClr, newClr);
        }
        if (x + 1 < n) {
            dfs(img, x + 1, y, prevClr, newClr);
        }
        if (y - 1 >= 0) {
            dfs(img, x, y - 1, prevClr, newClr);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> img = new ArrayList<>();
        img.add(Arrays.asList(1, 1, 1));
        img.add(Arrays.asList(1, 1, 0));
        img.add(Arrays.asList(1, 0, 1));

        // Co-ordinate provided by the user
        int x = 1;
        int y = 1;

        // New color that has to be filled
        int newClr = 3;
        floodFill(img, x, y, newClr);

        // Printing the updated img
        for (List<Integer> row : img) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}