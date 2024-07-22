import java.util.Scanner;

public class ChakravyuhaCrossing {
    static final int maxEnemies = 11; 
    static int  power;

    public static boolean canCrossChakrvyuha(int[] enemyPower, int enemy, int curPower, int behind, int skips, int recharge) {

        if (enemy == maxEnemies)
            return true;

        boolean flag = false;

        if (recharge > 0 && curPower < power)
            flag |= canCrossChakrvyuha(enemyPower, enemy, power, behind, skips, recharge - 1);

        if (curPower >= behind) {
            curPower -= behind;
            behind = 0;
        } else
            return false;

        if (skips > 0)
            flag |= canCrossChakrvyuha(enemyPower, enemy + 1, curPower, behind, skips - 1, recharge);

        if (curPower >= enemyPower[enemy]) {
            if (enemy == 2 || enemy == 6)
                behind = enemyPower[enemy] / 2;

            flag |= canCrossChakrvyuha(enemyPower, enemy + 1, curPower - enemyPower[enemy], behind, skips, recharge);
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide enemy powers total of 11 enymies");

        int[] enemyPower = new int[maxEnemies]; 

        for (int i = 0; i < maxEnemies; i++)
            enemyPower[i] = scanner.nextInt();
        
        int a, b; 

        System.out.println("Enter the power of abhimanyu");
        power = scanner.nextInt();
        System.out.println("Enter skips he can have");
        a = scanner.nextInt();
        System.out.println("Enter Recharges he can have");
        b= scanner.nextInt();
        a = Math.min(a, maxEnemies); 
        b = Math.min(b, maxEnemies); 

        int behind = 0;

        if (canCrossChakrvyuha(enemyPower, 0, power, behind, a, b))
            System.out.println("Abhimanyu can cross the Circlevyuha");//Manohar Gowda
        else
            System.out.println("Abhimanyu cannot cross the Circlevyuha");

        scanner.close();
    }
}


//test case : 1
// when i run the code it asks for array of integers synonym of enemies surrounded by circle of 11.
// then the power 
// then the skips abhimanyu had
// then recharge by him

//----->>>>>
//enemypower[] = {1 3 2 4 3 6 5 4 5 4 7}
//p0wer = 9
// a = 5
// b = 3 

//this will returns us "he can cross the circlevyuha".

//test case:2
//[] = {2 4 6 8 22 4 5 8 5 4 14}
// power = 5
// a = 4
// b  =2

//this returns us "Abhimanyu cannot cross Circlevyuha"

//Because he has less power and also he cannot get enough recharge and skips
//Thank you this tests are conducted by manohar gowda (Kodnest Intern (Java Full Stack))