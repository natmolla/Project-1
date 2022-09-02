package Service;

import DAO.PlayerRepository;
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
                System.out.println("This player already exists.");
        }
    }

    public void deletePlayerByName(String name){
        pr.getPlayerByName(name);
        if (getPlayerByName(name) == null){
            System.out.println("Player not found.");
            }else{
            pr.deletePlayerByName(name);
            System.out.println("Player deleted.");
            }

        }

    public Player updatePlayerByName(String name, String selectedField, String update ){
        pr.getPlayerByName(name);
        if (getPlayerByName(name) == null){
            System.out.println("Incorrect player name.");
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
        System.out.println("Kill recorded.");
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



