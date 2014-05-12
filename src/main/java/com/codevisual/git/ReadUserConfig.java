package com.codevisual.git;

import java.io.File;
import java.io.IOException;



import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Simple snippet which shows how to retrieve the user name and email that is configured in Git.
 */
public class ReadUserConfig {

    public static void main(String[] args) throws IOException {
    	FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:/Users/Home/AppData/Local/Temp/TestGitRepository6085814799011087022/.git"))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        Config config = repository.getConfig();
        String name = config.getString("user", null, "name");
        String email = config.getString("user", null, "email");
        if (name == null || email == null) {
            System.out.println("User identity is unknown!");
        } else {
            System.out.println("User identity is " + name + " <" + email + ">");
        }
        repository.close();
    }
}