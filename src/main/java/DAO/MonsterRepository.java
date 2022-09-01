package DAO;

import Model.Monster;
import Model.Player;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonsterRepository {

    Connection conn; // stating that ill use variable from Connection class

    public MonsterRepository(){
        conn = ConnectionUtil.getConnection(); //referencing the sql tables as my repo
        }


    public List<Monster> getAllMonsters(){
        List<Monster> allMonsters = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Monsters");
            while(rs.next()){
                Monster loadedMonster = new Monster(rs.getString("m_name"),rs.getString("m_type"),rs.getString("m_size"), rs.getString("m_description"), rs.getInt("m_ac") );
                allMonsters.add(loadedMonster);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return allMonsters;
    }

    public List<String> getAllMonsterNames(List<Monster> allMonsters){
        List<String> allMonsterNames = new ArrayList<>();
        for (int i = 0; i<allMonsters.size(); i++){
           String monster = allMonsters.get(i).getName();
            allMonsterNames.add(monster);
        }
        return allMonsterNames;
    }

    public Monster getMonsterByName(String name){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from Monsters where m_name = ?");
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Monster m = new Monster(rs.getString("m_name"),rs.getString("m_type"),rs.getString("m_size"), rs.getString("m_description"), rs.getInt("m_ac"));
                return m;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public void removeMonsterByName(String name){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from monsters where m_name = ?");
            statement.setString(1,name);
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public Player updateMonsterByName(String name, String selectedField, String update) {
        try {

            if (selectedField.equals("type")) {
                PreparedStatement statement = conn.prepareStatement("Update monsters set m_type = ? where m_name = ?");
                statement.setString(1, update);
                statement.setString(2, name);
                statement.executeUpdate();
            } else if (selectedField.equals("size")) {
                PreparedStatement statement = conn.prepareStatement("Update monsters set m_size = ? where m_name = ?");
                statement.setString(1, update);
                statement.setString(2, name);
                statement.executeUpdate();
            } else if (selectedField.equals("description")) {
                PreparedStatement statement = conn.prepareStatement("Update monsters set m_description = ? where m_name = ?");
                statement.setString(1, update);
                statement.setString(2, name);
                statement.executeUpdate();
            } else if (selectedField.equals("armor class")) {
                PreparedStatement statement = conn.prepareStatement("Update monsters set m_ac = ? where m_name = ?");
                statement.setString(1, update);
                statement.setString(2, name);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMonster(Monster m) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into Monsters(m_name, m_type, m_size, m_description, m_ac)" + "values(?,?,?,?,?)");
            statement.setString(1,m.getName());
            statement.setString(2,m.getType());
            statement.setString(3,m.getSize());
            statement.setString(4,m.getDescription());
            statement.setInt(5,m.getArmorClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
