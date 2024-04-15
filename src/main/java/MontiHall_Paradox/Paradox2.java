package MontiHall_Paradox;

import java.util.Random;
import java.util.Scanner;

public class Paradox2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        int userDoor, openDoor, otherDoor;

        // generate random value 1 to 3
        int prizeDoor = generator.nextInt(3) + 1;
        int goatDoor1 = prizeDoor;
        while (goatDoor1 == prizeDoor) {
            goatDoor1 = generator.nextInt(3) + 1;
        }
        int goatDoor2 = goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2 = generator.nextInt(3) + 1;
        }


        System.out.println("Добро пожаловать на Поле Чудес");
        System.out.print("Выберите дверь 1, 2, или 3: ");
        userDoor = scan.nextInt();


        if (userDoor > 3 || userDoor <= 0) {
            System.out.print("Пожалуйста выберите дверь 1, 2, или 3");
            userDoor = scan.nextInt();
        } else {
            if (userDoor == goatDoor1) {
                openDoor = goatDoor2;
                otherDoor = prizeDoor;
            } else if (userDoor == goatDoor2) {
                openDoor = goatDoor1;
                otherDoor = prizeDoor;
            } else {
                openDoor = goatDoor1;
                otherDoor = goatDoor2;
            }

            System.out.println("\nСейчас мы узнаем где приз "
                    + " но сначала мы узнаем "
                    + " что находится за этой дверью");
            System.out.println("\nЗа дверью " + openDoor
                    + " КОЗА!");
            System.out.println("Вы выбрали дверь номер " + userDoor);
            System.out.print("\nНе желаете изменить свой выбор " +
                    " двери (y/n)? ");


            char userReply = scan.next().charAt(0);
            while (userReply != 'y' && userReply != 'n') {
                System.out.print("Пожалуйста введите y или n");
                userReply = scan.next().charAt(0);
            }
            if (userReply == 'y') {
                userDoor = otherDoor;
                System.out.println("Вы изменили свой выбор на дверь "
                        + userDoor);
            }

            System.out.println("Выигрыш находится за дверью : "
                    + prizeDoor);

            
            if (userDoor == prizeDoor) {
                System.out.println("Поздравляем! Вы выиграли приз!");
            } else {
                System.out.println("К сожалению вы проиграли.");
            }
            scan.close();
        }
    }
}
