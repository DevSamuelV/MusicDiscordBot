import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import util.Json;

public class Bot {

    public static Json json = new Json();
    public static Constants constants = new Constants();
    public static JDA jda = null;
    public static JDABuilder builder = JDABuilder.createDefault(json.readToken(constants.path));

    public static void Init() throws LoginException {
        builder.addEventListeners(new Message());

        jda = builder.build();

        jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("SamuelTheBoi On Twitch"));
    }

    public static void main(String[] args) throws Exception {
        Init();
    }
}
