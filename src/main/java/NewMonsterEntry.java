import Service.MonsterService;

import java.util.Scanner;

public class NewMonsterEntry {

    MonsterService monsterService;

    String userInput = new String();
    public NewMonsterEntry(MonsterService ms){
        monsterService = ms;
    }

    public void userInput(String input){
        userInput = input;
    }

    public void addEntry(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Monster's name:");
        while(sc.hasNextInt() ) {
            System.out.println("Please use letters of the alphabet.");
            sc.nextLine();
        }
        String monsterName = sc.nextLine();
            MonsterManual.logger.info(monsterName);


        System.out.println("Monster's type (ex: humanoid, aberration):");
        while(sc.hasNextInt() ) {
            System.out.println("Please use letters of the alphabet.");
            sc.nextLine();
        }
        String monsterType = sc.nextLine();

            System.out.println("Monster's size: 's' for small, " +
                    "'m' for medium, 'l' for large");
            while (!sc.hasNext("[sml]")) {
                System.out.println("Please use 's', 'm', or 'l'.");
                sc.nextLine();
        }
        String monsterSize = sc.nextLine();


        System.out.println("Monster's short description:");
        while(sc.hasNextInt() ) {
            System.out.println("Please use letters of the alphabet.");
            sc.nextLine();
        }
        String monsterBio = sc.nextLine();

        System.out.println("Monster's Armor Class:");
        while(!sc.hasNextInt() ) {
            System.out.println("Please use whole numbers.");
            sc.nextLine();
        }

        Integer monsterAC = sc.nextInt();

        
        monsterService.addMonster(monsterName, monsterType, monsterSize,
                monsterBio, monsterAC);
    }


}
