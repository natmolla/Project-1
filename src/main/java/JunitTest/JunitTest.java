package JunitTest;

import DAO.PlayerRepository;
import Service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class JunitTest {

    PlayerRepository pr;
    static PlayerService ps;

    public JunitTest(){
        pr = new PlayerRepository();
        ps = new PlayerService();
    }

    @BeforeClass
    public static void setUp(){
        ps = new PlayerService();
    }


    @Test
    @DisplayName("Should check output of names")
    void getAllPlayerNames(){

        assertEquals("Abeth", pr.getPlayerByName("Abeth").getName());

    }

    @Test
    @DisplayName("Should check output of names")
    void getAllPlayerNames2(){

        assertEquals("Aduin", pr.getPlayerByName("Aduin").getName());

    }

}
