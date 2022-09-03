import Model.ClearSpace;
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
        GameMenu gameMenu = new GameMenu();

        boolean manualOpen = true;
        boolean playerOptions = false;
        boolean monsterOptions = false;
        boolean playerProfile = false;
        boolean monsterProfile = false;
        boolean leaderboardMenu = false;


            while (manualOpen) {
                System.out.println("""
                        ]--+++||MAIN MENU||+++--[
                        |                       |
                         
                         
                         
                                 >log in
                            >player options
                            >monster options
                            >view leaderboard
                                 >close
                        
                        
                        
                        |                       |
                        ]--+++||MAIN MENU||+++--[
                        """);
                String userInput = in.nextLine();
                newMonsterEntry.userInput(userInput);
                newPlayerEntry.userInput(userInput);
                if (userInput.equals("close")) {
                    manualOpen = false;
                } else if (userInput.equals("monster options")) {
                    ClearSpace.clearSpaceLots();
                    manualOpen = false;
                    monsterOptions = true;
                }
                else if (userInput.equals("player options")) {
                    ClearSpace.clearSpaceLots();
                    manualOpen = false;
                    playerOptions = true;
                }
                else if (userInput.equals("view leaderboard")){
                    manualOpen = false;
                    leaderboardMenu = true;
                }else if (userInput.equals("log in")){
                    manualOpen = gameMenu.checkLogin();
                }

                while (leaderboardMenu) {
                    System.out.println("""  
                            ]----+++||OPTIONS||+++----[
                            |                         |
  
                                        
                                   >leaderboard
                                   >record kill
                                      >back
                              

                            |                         |
                            ]----+++||OPTIONS||+++----[
                            """);
                    userInput = in.nextLine();
                    if (userInput.equals("back")) {
                        ClearSpace.clearSpaceLots();
                        leaderboardMenu = false;
                        manualOpen = true;
                    }
                    else if(userInput.equals("leaderboard")){
                        ClearSpace.clearSpaceLots();
                        System.out.println("""
                                ]--+++||LEADERBOARD||+++--[
                                """);
                        System.out.println("""  
                                |||||||||||||||||||||||||||
                                |||||||||||||||||||||||||||
                                """);
                        System.out.println(playerService.getLeaderboard());
                        System.out.println("""  
                                |||||||||||||||||||||||||||
                                |||||||||||||||||||||||||||
                                """);
                        System.out.println("""
                                ]--+++||LEADERBOARD||+++--[
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
                        System.out.println("""
                                ]--+++||LEADERBOARD||+++--[
                                """);
                        System.out.println("""  
                                |||||||||||||||||||||||||||
                                |||||||||||||||||||||||||||
                                """);
                        System.out.println(playerService.getLeaderboard());
                        System.out.println("""  
                                |||||||||||||||||||||||||||
                                |||||||||||||||||||||||||||
                                """);
                        System.out.println("""
                                ]--+++||LEADERBOARD||+++--[
                                """);
                    }



                }
                while (playerOptions) {
                    System.out.println("""  
                            ]--+++||PLAYER OPTIONS||+++--[
                            |                            |
                            
                            
                            
                                     >new player
                                    >view players
                                    >select player
                                        >back
                            
                            
                            
                            |                            |
                            ]--+++||PLAYER OPTIONS||+++--[
                            """);
                    userInput = in.nextLine();
                    newMonsterEntry.userInput(userInput);
                    newPlayerEntry.userInput(userInput);

                    if (userInput.equals("back")) {
                        ClearSpace.clearSpaceLots();
                        playerOptions = false;
                        manualOpen = true;

                    } else if (userInput.equals("new player")) {
                        newPlayerEntry.addEntry();
                    } else if (userInput.equals("view players")) {
                        ClearSpace.clearSpace();
                        System.out.println("""   
                                ]]-----------ALL-PLAYERS------------[[
                                
                                """);
                        System.out.println(playerService.getAllPlayerNames());
                        System.out.println("""  
                                 
                                 
                                ]]------------ALL-PLAYERS-----------[[
                                """);
                        ClearSpace.clearSpace();
                    } else if (userInput.equals("select player")) {
                        System.out.println("user:");
                        userInput = in.nextLine();
                        ClearSpace.clearSpaceLots();
                        System.out.println("""   
                                ]]-----------PLAYER------------[[
                                
                                """);
                        System.out.println(playerService.getPlayerByName(userInput));
                        System.out.println("""   
                                
                                
                                ]]-----------PLAYER------------[[
                                """);
                        manualOpen = false;
                        playerOptions = false;
                        playerProfile = true;

                        while (playerProfile) {
                            System.out.println("""
                                    ]--+++||PLAYER PROFILE||+++--[
                                    |                            |



                                           >update profile
                                           >delete player
                                               >back
                                    
                                    
                                    
                                    |                            |
                                    ]--+++||PLAYER PROFILE||+++--[
                                    """);
                            userInput = in.nextLine();
                            String playerName = "";
                            String selectedField = "";
                            String update = "";

                            if (userInput.equals("back")) {
                                ClearSpace.clearSpaceLots();
                                playerOptions = true;
                                playerProfile = false;
                            } else if (userInput.equals("update profile")) {
                                System.out.println("Confirm user's name:");
                                playerName = in.nextLine();
                                System.out.println("""   
                                ]]-----------PLAYER------------[[
                                
                                """);
                                System.out.println(playerService.getPlayerByName(playerName));
                                System.out.println("""   
                                
                                
                                ]]-----------PLAYER------------[[
                                """);
                                System.out.println("Field to edit, select one: class, armor class, password");
                                selectedField = in.nextLine();
                                System.out.println("Enter new " + selectedField + ":");
                                update = in.nextLine();
                                playerService.updatePlayerByName(playerName, selectedField, update);
                                ClearSpace.clearSpaceLots();
                                System.out.println("""   
                                ]]-----------PLAYER------------[[
                                
                                """);;
                                System.out.println(playerService.getPlayerByName(playerName));
                                System.out.println("""   
                                
                                
                                ]]-----------PLAYER------------[[
                                """);

                            } else if (userInput.equals("delete player")) {
                                System.out.println("Player to delete:");
                                userInput = in.nextLine();
                                ClearSpace.clearSpaceLots();
                                playerService.deletePlayerByName(userInput);
                            }

                        }

                    }
                }


                while (monsterOptions) {
                    System.out.println("""
                            ]--+++||MONSTER OPTIONS||+++--[
                            |                             |
                            
                            
                            
                                     >new monster
                                    >view monsters
                                    >select monster
                                        >back
                               
                               
                                 
                            |                             |
                            ]--+++||MONSTER OPTIONS||+++--[
                            """);
                    userInput = in.nextLine();
                    newMonsterEntry.userInput(userInput);
                    newPlayerEntry.userInput(userInput);

                    if (userInput.equals("back")) {
                        ClearSpace.clearSpaceLots();
                        monsterOptions = false;
                        manualOpen = true;

                    } else if (userInput.equals("new monster")) {
                        newMonsterEntry.addEntry();
                    } else if (userInput.equals("view monsters")) {
                        ClearSpace.clearSpace();
                        System.out.println("""   
                                ]]-----------ALL-MONSTERS------------[[
                                
                                """);
                        System.out.println(monsterService.getAllMonsterNames());
                        System.out.println("""  
                                 
                                 
                                ]]------------ALL-MONSTERS-----------[[
                                """);
                        ClearSpace.clearSpace();
                    } else if (userInput.equals("select monster")) {
                        System.out.println("monster:");
                        userInput = in.nextLine();
                        ClearSpace.clearSpaceLots();
                        System.out.println("""   
                                ]]-----------MONSTER------------[[
                                
                                """);;
                        System.out.println(monsterService.getMonsterByName(userInput));
                        System.out.println("""   
                                
                                
                                ]]-----------MONSTER------------[[
                                """);
                        monsterProfile = true;
                        monsterOptions = false;

                        while (monsterProfile) {
                            System.out.println("""
                            ]--+++||MONSTER PROFILE||+++--[
                            |                             |
                            
                            
                                          
                                    >update monster
                                    >delete monster
                                        >back
                            
                            
                                    
                            |                             |
                            ]--+++||MONSTER PROFILE||+++--[
                                    """);
                            userInput = in.nextLine();
                            String monsterName = "";
                            String selectedField = "";
                            String update = "";


                            if (userInput.equals("back")) {
                                ClearSpace.clearSpaceLots();
                                monsterProfile = false;
                                monsterOptions = true;
                            } else if (userInput.equals("update monster")) {
                                System.out.println("Confirm monster's name:");
                                monsterName = in.nextLine();
                                ClearSpace.clearSpace();
                                System.out.println("""   
                                ]]-----------MONSTER------------[[
                                
                                """);;
                                System.out.println(monsterService.getMonsterByName(monsterName));
                                System.out.println("""   
                                
                                
                                ]]-----------MONSTER------------[[
                                """);
                                ClearSpace.clearSpace();
                                System.out.println("Field to edit, select one: type, size, description, armor class");
                                selectedField = in.nextLine();
                                System.out.println("Enter new " + selectedField + ":");
                                update = in.nextLine();
                                monsterService.updateMonsterByName(monsterName, selectedField, update);
                                ClearSpace.clearSpace();
                                System.out.println("""   
                                ]]-----------MONSTER------------[[
                                
                                """);;
                                System.out.println(monsterService.getMonsterByName(monsterName));
                                System.out.println("""   
                                
                                
                                ]]-----------MONSTER------------[[
                                """);

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

