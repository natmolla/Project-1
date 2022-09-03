package Service;

import DAO.PlayerRepository;
import Model.ClearSpace;
import Model.LPlacement;
import Model.Player;

import java.util.List;

public class PlayerService {

    PlayerRepository pr;

    public PlayerService(){
        pr = new PlayerRepository();
    }

    public void addPlayer(String name, String playerClass, int armorClass, String password) {
        Player existingPlayer = pr.getPlayerByName(name);
        if (existingPlayer == null) {
            Player newPlayer = new Player(name, playerClass, armorClass, password);
            pr.addPlayer(newPlayer);
        } else {
            ClearSpace.clearSpace();
            System.out.println("""
                ]|---------------------------------|[
                
                     This player already exists.
                    
                ]|---------------------------------|[
                """);
            ClearSpace.clearSpace();
        }
    }

   // public boolean checkLogin(String username, String password){
     //   pr.checkLogin(username, password);

    //}


    public void deletePlayerByName(String name){
        pr.getPlayerByName(name);
        if (getPlayerByName(name) == null){
            ClearSpace.clearSpace();
            System.out.println("""
                ]|---------------------------------|[
                
                     This player does not exist.
                    
                ]|---------------------------------|[
                """);
            ClearSpace.clearSpace();
            }else{
            pr.deletePlayerByName(name);
            ClearSpace.clearSpace();
            System.out.println("""
                ]|-----------------------------------|[
                
                     Player successfully deleted.
                    
                ]|-----------------------------------|[
                """);
            ClearSpace.clearSpace();
            }

        }

    public Player updatePlayerByName(String name, String selectedField, String update ){
        pr.getPlayerByName(name);
        if (getPlayerByName(name) == null){
            ClearSpace.clearSpace();
            System.out.println("""
                ]|-----------------------------|[
                
                     Incorrect player name.
                    
                ]|-----------------------------|[
                """);
            ClearSpace.clearSpace();
        }else{
            pr.updatePlayerByName(name, selectedField, update);
        }
        return pr.getPlayerByName(name);
    }


    public List<LPlacement> getLeaderboard(){
        return pr.getLeaderboard();
    }

    public void addKill(String player, String monster){
        pr.addKill(player, monster);
        ClearSpace.clearSpace();
        System.out.println("""
                ]|--------------------|[
                
                     Kill Recorded
                    
                ]|--------------------|[
                """);
        ClearSpace.clearSpace();
    }


    public List<Player> getAllPlayers(){
            return pr.getAllPlayers();
        }

    public Player getPlayerByName(String name) {
            return pr.getPlayerByName(name);

    }


    public List<String> getAllPlayerNames(){
        return pr.getAllPlayerNames(pr.getAllPlayers());
    }



}



