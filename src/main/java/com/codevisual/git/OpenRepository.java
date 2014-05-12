package com.codevisual.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;



/**
 * Simple snippet which shows how to open an existing repository
 * 
 * @author dominik.stadler at gmx.at
 */
public class OpenRepository {

    public static void main(String[] args) throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:/Users/Home/Documents/workspace/SwaranDissertation"))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();

        System.out.println("Having repository: " + repository.getDirectory());

        repository.close();
    }
}