import Service.PlayerService;

import java.util.Scanner;

public class NewPlayerEntry {

    PlayerService playerService;

    Scanner sc = new Scanner(System.in);
    String userInput = new String();

    public NewPlayerEntry(PlayerService ps){
        playerService = ps;
    }

    public void userInput(String input){
        userInput = input;
    }

    public void addEntry(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Player name:");
        while(sc.hasNextInt() ) {
            System.out.println("Please use letters of the alphabet.");
            sc.nextLine();
        }
        String playerName = sc.nextLine();

        System.out.println("Player's class:");
        while(sc.hasNextInt() ) {
            System.out.println("Please use letters of the alphabet.");
            sc.nextLine();
        }
        String playerClass = sc.nextLine();

        System.out.println("Player's Armor Class:");
        while(!sc.hasNextInt() ) {
            System.out.println("Please use whole numbers only.");
            sc.nextLine();
        }
        Integer playerArmorClass = sc.nextInt();

        sc.nextLine();
        System.out.println("Password:");

        String playerPassword = sc.nextLine();


        playerService.addPlayer(playerName, playerClass, playerArmorClass, playerPassword);

    }



}
