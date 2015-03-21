package bot;

import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class Bot {
    private String username, authToken;

    public Bot(String username, String authToken) {
        this.username = username;
        this.authToken = authToken;
    }

    public void PostResult(String repoName, int prId, String lintResult) throws Exception {
        GitHub gh = GitHub.connect(this.username, this.authToken);
        GHRepository repo = gh.getRepository(repoName);
        GHPullRequest pr = repo.getPullRequest(prId);

        pr.comment(String.format("Hello! I am the LintMe bot! Here is the output of linting your javascript files:\n```\n%s\n```", lintResult));
    }
}