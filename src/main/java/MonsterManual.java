import Service.MonsterService;
import Service.PlayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class MonsterManual {

    public static Logger logger = LogManager.getLogger(MonsterManual.class);


    public static void main(String[] args) {

        logger.info("Logger initialized.");

        Scanner in = new Scanner(System.in);
        MonsterService monsterService = new MonsterService();
        PlayerService playerService = new PlayerService();
        NewMonsterEntry newMonsterEntry = new NewMonsterEntry(monsterService);
        NewPlayerEntry newPlayerEntry = new NewPlayerEntry(playerService);
        ClearSpace clearSpace = new ClearSpace();

        boolean manualOpen = true;
        boolean playerOptions = false;
        boolean monsterOptions = false;
        boolean playerProfile = false;
        boolean monsterProfile = false;
        boolean leaderboardMenu = false;


            while (manualOpen) {
                System.out.println("""
                                      SELECT
                                      
                        >player options
                        >monster options
                        >view leaderboard
                        >close
                        
                        
                        
                        """);
                String userInput = in.nextLine();
                newMonsterEntry.userInput(userInput);
                newPlayerEntry.userInput(userInput);
                if (userInput.equals("close")) {
                    manualOpen = false;
                } else if (userInput.equals("monster options")) {
                    ClearSpace.clearSpace();
                    manualOpen = false;
                    monsterOptions = true;
                }
                else if (userInput.equals("player options")) {
                    ClearSpace.clearSpace();
                    manualOpen = false;
                    playerOptions = true;
                }
                else if (userInput.equals("view leaderboard")){
                    manualOpen = false;
                    leaderboardMenu = true;
                }

                while (leaderboardMenu) {
                    System.out.println("""  
                                        SELECT
                                        
                            >leaderboard
                            >record kill
                            >back
                                                        
                                                        
                                                        
                            """);
                    userInput = in.nextLine();
                    if (userInput.equals("back")) {
                        leaderboardMenu = false;
                        manualOpen = true;
                    }
                    else if(userInput.equals("leaderboard")){
                        ClearSpace.clearSpace();
                        System.out.println("""
                                
                                
                                ]--||LEADERBOARD||--[
                                
                                
                                """);
                        System.out.println(playerService.getLeaderboard());
                        System.out.println("""
                                
                                
                                ]--||LEADERBOARD||--[
                                
                                
                                """);
                    }
                    else if(userInput.equals("record kill")){
                        String player = "";
                        String monster = "";
                        System.out.println("Player's name:");
                        player = in.nextLine();
                        System.out.println("Enter name of monster killed:");
                        monster = in.nextLine();
                        playerService.addKill(player, monster);
                    }



                }
                while (playerOptions) {
                    System.out.println("""  
                                        SELECT
                                        
                            >new player
                            >view players
                            >select player
                            >back
                            
                            
                            
                            """);
                    userInput = in.nextLine();
                    newMonsterEntry.userInput(userInput);
                    newPlayerEntry.userInput(userInput);

                    if (userInput.equals("back")) {
                        playerOptions = false;
                        manualOpen = true;

                    } else if (userInput.equals("new player")) {
                        newPlayerEntry.addEntry();
                    } else if (userInput.equals("view players")) {
                        ClearSpace.clearSpace();
                        System.out.println(playerService.getAllPlayerNames());
                    } else if (userInput.equals("select player")) {
                        System.out.println("user:");
                        userInput = in.nextLine();
                        ClearSpace.clearSpace();
                        System.out.println(playerService.getPlayerByName(userInput));
                        manualOpen = false;
                        playerOptions = false;
                        playerProfile = true;

                        while (playerProfile) {
                            System.out.println("""
                                            SELECT
                                    
                                    >update profile
                                    >delete player
                                    >back
                                    
                                    
                                    
                                    """);
                            userInput = in.nextLine();
                            String playerName = "";
                            String selectedField = "";
                            String update = "";

                            if (userInput.equals("back")) {
                                playerOptions = true;
                                playerProfile = false;
                            } else if (userInput.equals("update profile")) {
                                System.out.println("Confirm user's name:");
                                playerName = in.nextLine();
                                System.out.println(playerService.getPlayerByName(playerName));
                                System.out.println("Field to edit, select one: class, armor class, password");
                                selectedField = in.nextLine();
                                System.out.println("Enter new " + selectedField + ":");
                                update = in.nextLine();
                                playerService.updatePlayerByName(playerName, selectedField, update);
                                ClearSpace.clearSpace();
                                System.out.println(playerService.getPlayerByName(playerName));


                            } else if (userInput.equals("delete player")) {
                                System.out.println("Player to delete:");
                                userInput = in.nextLine();
                                ClearSpace.clearSpace();
                                playerService.deletePlayerByName(userInput);
                            }

                        }

                    }
                }


                while (monsterOptions) {
                    System.out.println("""
                                   SELECT
                                   
                            >new monster
                            >view monsters
                            >select monster
                            >back
                            
                            
                            
                            """);
                    userInput = in.nextLine();
                    newMonsterEntry.userInput(userInput);
                    newPlayerEntry.userInput(userInput);

                    if (userInput.equals("back")) {
                        monsterOptions = false;
                        manualOpen = true;

                    } else if (userInput.equals("new monster")) {
                        newMonsterEntry.addEntry();
                    } else if (userInput.equals("view monsters")) {
                        ClearSpace.clearSpace();
                        System.out.println(monsterService.getAllMonsterNames());
                    } else if (userInput.equals("select monster")) {
                        System.out.println("monster:");
                        userInput = in.nextLine();
                        ClearSpace.clearSpace();
                        System.out.println(monsterService.getMonsterByName(userInput));
                        monsterProfile = true;
                        monsterOptions = false;

                        while (monsterProfile) {
                            System.out.println("""
                                    
                                    
                                         SELECT
                                         
                                    >update monster
                                    >delete monster
                                    >back
                                    
                                    
                                    
                                    """);
                            userInput = in.nextLine();
                            String monsterName = "";
                            String selectedField = "";
                            String update = "";


                            if (userInput.equals("back")) {
                                monsterProfile = false;
                                monsterOptions = true;
                            } else if (userInput.equals("update monster")) {
                                System.out.println("Confirm monster's name:");
                                monsterName = in.nextLine();
                                System.out.println(monsterService.getMonsterByName(monsterName));
                                System.out.println("Field to edit, select one: type, size, description, armor class");
                                selectedField = in.nextLine();
                                System.out.println("Enter new " + selectedField + ":");
                                update = in.nextLine();
                                monsterService.updateMonsterByName(monsterName, selectedField, update);
                                System.out.println(monsterService.getMonsterByName(monsterName));


                            } else if (userInput.equals("delete monster")) {
                                System.out.println("Monster to delete:");
                                userInput = in.nextLine();
                                monsterService.deleteMonsterByName(userInput);
                            }
                        }

                    }


                }
            }
    }
}

