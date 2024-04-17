package MontiHall_Paradox;

import java.util.Random;

public class Paradox {
    public static void main(String[] args) {
        int switchWins = 0;
        int stayWins = 0;
        Random gen = new Random();
        for(int plays = 0;plays < 1000;plays++ ){
            int[] doors = {0,0,0};
            doors[gen.nextInt(3)] = 1;
            int choice = gen.nextInt(3);
            int shown;
            do{
                shown = gen.nextInt(3);

            }while(doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];


            switchWins += doors[3 - choice - shown];
        }
        System.out.println("Выиграли те, кто изменил выбор " + switchWins + " раз.");
        System.out.println("Выиграли те, кто не изменил решение " + stayWins + " раз.");
    }
}
