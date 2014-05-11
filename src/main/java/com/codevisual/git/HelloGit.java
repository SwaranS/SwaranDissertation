package com.codevisual.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class HelloGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {        
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("https://github.com/xiansong/codemetric.git"))
                .readEnvironment()
                .findGitDir()
                .build();

        ObjectId head = repository.resolve("HEAD");
        System.out.println(head);
    }
}
