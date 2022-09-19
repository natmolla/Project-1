package DAO;

import Model.LPlacement;
import Model.LoginModel;
import Model.Player;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    Connection conn;

    public PlayerRepository() {
        conn = ConnectionUtil.getConnection();
    }

    public List<Player> getAllPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Players");
            while (rs.next()) {
                Player loadedPlayer = new Player(rs.getString("p_name"), rs.getString("p_class"), rs.getInt("p_ac"), rs.getString("p_password"));
                allPlayers.add(loadedPlayer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlayers;
    }

    public List<LPlacement> getLeaderboard(){
        List<LPlacement> lPlacement = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from [Leaderboard]");
            while (rs.next()){
                LPlacement loadedPlayer = new LPlacement(rs.getString("player"), rs.getInt("count"));
                lPlacement.add(loadedPlayer);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return lPlacement;
    }

     public List<LoginModel> getAllPlayerLogins(){

        List<LoginModel> loginInformation = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select p_name, p_password from players");
            while (rs.next()){
                LoginModel loadedInformation = new LoginModel(rs.getString("p_name"),rs.getString("p_password"));
                loginInformation.add(loadedInformation);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return loginInformation;

    }




    public boolean checkLogin(String username, String password){
        boolean loggedIn = false;
        try {
            PreparedStatement statement = conn.prepareStatement("Select p_name, p_password from players where p_name = ? and p_password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                loggedIn = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedIn;



    }


    public void addKill(String player, String monster){
        try{
            PreparedStatement statement = conn.prepareStatement("INSERT into Kills(player, monster_killed)" + "values (?,?)");
            statement.setString(1,player);
            statement.setString(2,monster);
            statement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getKills(String name) {
        Integer kills = 0;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT count from [Leaderboard] where player = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                kills = rs.getInt("count");
                return kills;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getAllPlayerNames(List<Player> allPlayers) {
        List<String> allPlayerNames = new ArrayList<>();
        for (int i = 0; i < allPlayers.size(); i++) {
            String player = allPlayers.get(i).getName();
            allPlayerNames.add(player);
        }
        return allPlayerNames;

    }

    public void deletePlayerByName(String name){
        try{
            PreparedStatement statement = conn.prepareStatement("Delete from players where p_name = ?");
            statement.setString(1, name);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();

        }
    }

    public Player getPlayerByName(String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from Players where p_name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Player p = new Player(rs.getString("p_name"), rs.getString("p_class"), rs.getInt("p_ac"), rs.getString("p_password"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Player updatePlayerByName(String name, String selectedField, String update){
        try{
            if(selectedField.equals("class")) {
                PreparedStatement statement = conn.prepareStatement("Update players set p_class = ? where p_name = ?");
                statement.setString(1,update);
                statement.setString(2,name);
                statement.executeUpdate();
            }else if(selectedField.equals("armor class")){
                PreparedStatement statement = conn.prepareStatement("Update players set p_ac = ? where p_name = ?");
                statement.setString(1,update);
                statement.setString(2,name);
                statement.executeUpdate();
            }else if(selectedField.equals("password")){
                PreparedStatement statement = conn.prepareStatement("Update players set p_password = ? where p_name = ?");
                statement.setString(1,update);
                statement.setString(2,name);
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    public Player updateEntirePlayerByName(String name, Player p) {
        try {
            PreparedStatement statement = conn.prepareStatement("update players set p_class = ?, p_ac = ? where p_name = ?");
            statement.setString(1, p.getPlayerClass());
            statement.setInt(2, p.getArmorClass());
            statement.setString(3,name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void addPlayer(Player p){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into Players(p_name, p_class, p_ac, p_password)" + "values(?,?,?,?)");

            statement.setString(1,p.getName());
            statement.setString(2, p.getPlayerClass());
            statement.setInt(3, p.getArmorClass());
            statement.setString(4, p.getPassword());
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }



}