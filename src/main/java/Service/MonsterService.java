package Service;

import DAO.MonsterRepository;
import Model.Monster;

import java.util.List;

public class MonsterService {

    MonsterRepository mr;
    public MonsterService(){
        mr = new MonsterRepository();
    }

    public void addMonster(String name, String type, String size,
    String description, int armorClass){
        Monster existingMonster = mr.getMonsterByName(name);
        if (existingMonster == null) {
            Monster newMonster = new Monster(name, type, size, description, armorClass);
            mr.addMonster(newMonster);
        }else{

        }
    }

    public void deleteMonsterByName(String name){
        mr.getMonsterByName(name);
        if(getMonsterByName(name)==null){
            System.out.println("This monster does not exist.");
        }else{
            mr.removeMonsterByName(name);
            System.out.println("Monster deleted.");
        }
    }

    public List<Monster> getAllMonsters(){
        return mr.getAllMonsters();
    }

    public Monster updateMonsterByName(String name, String selectedField, String update ){
        mr.getMonsterByName(name);
        if (getMonsterByName(name) == null){
            System.out.println("Incorrect monster name.");
        }else{
            mr.updateMonsterByName(name, selectedField, update);
        }
        return mr.getMonsterByName(name);
    }

    public Monster getMonsterByName(String name){
        return mr.getMonsterByName(name);
    }

    public List<String> getAllMonsterNames(){
        return mr.getAllMonsterNames(mr.getAllMonsters());
    }



}
