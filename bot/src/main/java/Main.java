import bot.Bot;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String args[]) throws Exception {
        BotConfig config = loadBotConfig();
        Bot bot = new Bot(config.getUsername(), config.getAuthToken());

        String repoName = args[0];
        String prRepoName = args[1];
        String prBranch = args[2];
        int prNumber = Integer.parseInt(args[3]);

        System.out.println(String.format("repoName %s, prNumber %s, username %s, token %s", repoName, prNumber, config.getUsername(), config.getAuthToken()));
        bot.PostResult(repoName, prNumber, "This is the result...");
    }

    private static BotConfig loadBotConfig() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("botconfig.json"), BotConfig.class);
    }
}
