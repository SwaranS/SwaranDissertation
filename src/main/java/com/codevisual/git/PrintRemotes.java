package com.codevisual.git;

import java.io.File;
import java.io.IOException;
import java.util.Set;


//import org.dstadler.jgit.helper.CookbookHelper;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Simple snippet which shows how to retrieve the list of remotes from the configuration
 */
public class PrintRemotes {

    public static void main(String[] args) throws IOException {
    	FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:/Users/Home/AppData/Local/Temp/TestGitRepository6085814799011087022/.git"))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        Config storedConfig = repository.getConfig();
        Set<String> remotes = storedConfig.getSubsections("remote");

        for (String remoteName : remotes) {
            String url = storedConfig.getString("remote", remoteName, "url");
            System.out.println(remoteName + " " + url);
        }

        repository.close();
    }
}