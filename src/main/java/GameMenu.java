import DAO.PlayerRepository;
import Model.ClearSpace;

import java.util.Scanner;

public class GameMenu {

    PlayerRepository pr = new PlayerRepository();
    Scanner in = new Scanner(System.in);
    boolean loggedin = false;

    public boolean checkLogin() {
        String username = "";
        String password = "";

        System.out.println("Enter your username:");
        username = in.nextLine();
        MonsterManual.logger.info("User tried to login as:" +username);
        System.out.println("Enter your password:");
        password = in.nextLine();

        if (pr.checkLogin(username, password)) {
            ClearSpace.clearSpace();
                    System.out.println("""
                    
                             Welcome!
                    
                    """);
            loggedin = true;
        } else {
            ClearSpace.clearSpace();
            System.out.println("Wrong login information.");
        }
        while (loggedin) {

            System.out.println("""
                    ]--+++||GAME MENU||+++--[
                    |                       |
       
       
                         >fight a monster
                          >my inventory
                              >back
                    
                                            
                    |                       |
                    ]--+++||GAME MENU||+++--[
                    """);
            String userInput = in.nextLine();
            if (userInput.equals("back")) {
                loggedin = false;

            }

            

        }

        return true;
    }

}
