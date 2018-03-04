package Model;

import java.util.Scanner;

/**
 * Created by Jedrzej Hodor on 28.02.18.
 */

public class GetFromHuman {

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static Boolean getBoolean() {
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.next();
            if(input.equals("1")) {
                return true;
            } else if(input.equals("0")) {
                return false;
            } else {
                System.out.println("Only possible answers are: 1 ot 0, try again!");
            }
        }
    }
}
