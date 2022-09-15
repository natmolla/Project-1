import DAO.MonsterRepository;
import DAO.PlayerRepository;
import Model.Monster;
import Model.Player;
import Service.MonsterService;
import Service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MonsterManualAPI {

    public static Logger logger = LogManager.getLogger(MonsterManualAPI.class);




    public static void main(String[] args) {
        PlayerService ps = new PlayerService();
        PlayerRepository pr = new PlayerRepository();
        MonsterService ms = new MonsterService();
        MonsterRepository mr = new MonsterRepository();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins
        ).start(9000);

        MonsterManualAPI.logger.info("Logger initialized");
        
        //TRY LOGGING IN
        
        app.get("/monstermanual/player/{name}/{password}", ctx -> {
           ctx.json(pr.checkLogin(ctx.pathParam("name"),ctx.pathParam("password")));
        });

        //FETCHING ALL MONSTERS/PLAYERS

        app.get("/monstermanual/players", ctx -> {
            ctx.json(ps.getAllPlayerNames());
        });

        app.get("/monstermanual/monsters", ctx -> {
            ctx.json(ms.getAllMonsterNames());
        });

        //FETCHING MONSTER/PLAYER BY NAME

        app.get("/monstermanual/monster/{name}", ctx -> {
            ctx.json(ms.getMonsterByName(ctx.pathParam("name")));
        });

        app.get("/monstermanual/player/{name}", ctx -> {
            ctx.json(ps.getPlayerByName(ctx.pathParam("name")));
        });

        //ADDING NEW MONSTER/PLAYER

        app.post("/monstermanual/monsters", ctx -> {

            ObjectMapper mapper = new ObjectMapper();
            Monster requestMonster = mapper.readValue(ctx.body(), Monster.class);
            ms.addMonster(requestMonster.getName(), requestMonster.getType(), requestMonster.getSize(), requestMonster.getDescription(), requestMonster.getArmorClass());
        });

        app.post("/monstermanual/players", ctx -> {

            ObjectMapper mapper = new ObjectMapper();
            Player requestPlayer = mapper.readValue(ctx.body(), Player.class);
            ps.addPlayer(requestPlayer.getName(), requestPlayer.getPlayerClass(), requestPlayer.getArmorClass(), requestPlayer.getPassword());

        });

        //DELETING A PLAYER/MONSTER

        app.delete("/monstermanual/player/{name}", ctx -> {
            ps.deletePlayerByName(ctx.pathParam("name"));
        });

        app.delete("/monstermanual/monster/{name}", ctx -> {
            ms.deleteMonsterByName(ctx.pathParam("name"));
        });

        //UPDATING A PLAYER/MONSTER

        app.put("monstermanual/player/{name}", ctx -> {

            ObjectMapper mapper = new ObjectMapper();
            Player updatedPlayer = mapper.readValue(ctx.body(), Player.class);
            ps.updateEntirePlayerByName(ctx.pathParam("name"), updatedPlayer);
        });

        app.put("monstermanual/monster/{name}", ctx ->  {

           ObjectMapper mapper = new ObjectMapper();
           Monster updatedMonster = mapper.readValue(ctx.body(), Monster.class);
           ms.updateEntireMonsterByName(ctx.pathParam("name"), updatedMonster);
        });

        // OPEN THE LEADERBOARD

        app.get("monstermanual/leaderboard", ctx -> {
            ctx.json(pr.getLeaderboard());
        });

        // ADD KILL TO LEADERBOARD

        app.post("monstermanual/leaderboard/{name}/{kill}", ctx -> {
            pr.addKill(ctx.pathParam("name"),ctx.pathParam("kill"));
        });


    }

}

