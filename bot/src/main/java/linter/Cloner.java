package linter;

import org.kohsuke.github.GitHub;

public class Cloner {
    private String cloneDir;

    public Cloner(String cloneDir) {
        this.cloneDir = cloneDir;
    }

    public void clonePr(String repoName, int prId) throws Exception {
        GitHub gh = GitHub.connect();
        gh.getRepository(repoName).getPullRequest(prId).get;
    }
}
