package Service;

import DAO.MonsterRepository;
import Model.ClearSpace;
import Model.Monster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MonsterService {
    public static Logger logger = LogManager.getLogger(MonsterService.class);

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
            ClearSpace.clearSpace();
            System.out.println("""
                ]|---------------------------------|[
                
                     This monster already exists.
                    
                ]|---------------------------------|[
                """);
            ClearSpace.clearSpace();
        }
    }

    public void deleteMonsterByName(String name){
        mr.getMonsterByName(name);
        if(getMonsterByName(name)==null){
            ClearSpace.clearSpace();
            System.out.println("""
                ]|---------------------------------|[
                
                     This monster does not exist.
                    
                ]|---------------------------------|[
                """);
            ClearSpace.clearSpace();
        }else{
            mr.removeMonsterByName(name);
            ClearSpace.clearSpace();
            System.out.println("""
                ]|---------------------------------|[
                
                     Monster successfully deleted.
                    
                ]|---------------------------------|[
                """);
            ClearSpace.clearSpace();
        }
    }

    public List<Monster> getAllMonsters(){
        return mr.getAllMonsters();
    }

    public Monster updateEntireMonsterByName(String name, Monster updatedMonster){
        return mr.updateEntireMonsterByName(name, updatedMonster);

    }

    public Monster updateMonsterByName(String name, String selectedField, String update ){
        mr.getMonsterByName(name);
        if (getMonsterByName(name) == null){
            ClearSpace.clearSpace();
            System.out.println("""
                ]|------------------------------|[
                
                     Incorrect monster name.
                    
                ]|------------------------------|[
                """);
            ClearSpace.clearSpace();
        }else{
            mr.updateMonsterByName(name, selectedField, update);
        }
        return mr.getMonsterByName(name);
    }

    public Monster getMonsterByName(String name){
        MonsterService.logger.info("Monster: "+ name + " was selected.");
        return mr.getMonsterByName(name);
    }

    public List<String> getAllMonsterNames(){
        return mr.getAllMonsterNames(mr.getAllMonsters());
    }



}
