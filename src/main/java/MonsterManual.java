import java.util.Scanner;

public class MonsterManual {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        boolean manualOpen = true;
        while(manualOpen){
            System.out.println("available actions (view, add, delete, close)");
            String userInput = in.nextLine();
            if(userInput.equals("close")){
                manualOpen = false;
            }else if(userInput.equals("add")){
                System.out.println("Insert monster's name:");
                String monsterName = in.nextLine();
                System.out.println("Insert monster's type (ex: humanoid, aberration):");
                String monsterType = in.nextLine();
                System.out.println("Insert monster's size:");
                String monsterSize = in.nextLine();
                System.out.println("Enter monster's short description:");
                String monsterBio = in.nextLine();
                System.out.println("Insert monster's armor class:");
                Integer monsterAC = in.nextInt();
            }else if(userInput.equals("view")){
                System.out.println();
            }else if(userInput.equals("delete")){

            }
        }

    }


}
