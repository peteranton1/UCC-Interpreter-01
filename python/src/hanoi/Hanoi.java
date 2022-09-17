/*##############################
#
# Towers of Hanoi problem
# 
# See: https://www.youtube.com/watch?v=rf6uf3jNjbo
#
##############################*/
package hanoi;

import java.util.Scanner;

public class Hanoi {
    /**
    prints the list of steps required to
    move n disks from the start rod to the
    end rod
    >>> hanoi(2, 1, 3)
    1 -> 2
    1 -> 3
    2 -> 3
     */
    public void hanoi(int n, int start, int end) {
        if (n == 1){
            pm(start, end);
        }else{
            int other = 6 - (start + end);
            hanoi(n - 1, start, other);
            pm(start, end);
            hanoi(n - 1, other, end);
        }
    }

    public void pm(int start, int end){
        System.out.println(start + "->" + end);
    }

    public int askNumber(){
        try (Scanner s = new Scanner(System.in)){
            System.out.print("Enter value for n: ");
            int n = s.nextInt();
            return n;
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        int n = h.askNumber();
        h.hanoi(n, 1, 3);
    }
}

