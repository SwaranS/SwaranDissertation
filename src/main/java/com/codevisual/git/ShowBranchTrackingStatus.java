package com.codevisual.git;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.BranchTrackingStatus;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Snippet which shows how to use BranchTrackingStatus to print
 * how many commits away the local git repository is from the 
 * remote branches.
 * 
 * @author dominik.stadler at gmx.at
 */
public class ShowBranchTrackingStatus {

    public static void main(String[] args) throws IOException, GitAPIException {
    	FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(new File("C:/Users/Home/AppData/Local/Temp/TestGitRepository6085814799011087022/.git"))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        List<Ref> call = new Git(repository).branchList().call();
        for (Ref ref : call) {
            List<Integer> counts = getCounts(repository, ref.getName());
            System.out.println("For branch: " + ref.getName());
            System.out.println("Commits ahead : " + counts.get(0));
            System.out.println("Commits behind : " + counts.get(1));
            System.out.println();
        }

        repository.close();
    }

    private static List<Integer> getCounts(org.eclipse.jgit.lib.Repository repository, String branchName) throws IOException {
        BranchTrackingStatus trackingStatus = BranchTrackingStatus.of(repository, branchName);
        List<Integer> counts = new ArrayList<Integer>();
        if (trackingStatus != null) {
            counts.add(trackingStatus.getAheadCount());
            counts.add(trackingStatus.getBehindCount());
        } else {
            System.out.println("Returned null, likely no remote tracking of branch " + branchName);
            counts.add(0);
            counts.add(0);
        }
        return counts;
    }
}
