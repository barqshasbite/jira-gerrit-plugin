package com.meetme.plugins.jira.gerrit.data;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import com.atlassian.jira.issue.Issue;
import com.meetme.plugins.jira.gerrit.data.dto.GerritChange;
import com.sonyericsson.hudson.plugins.gerrit.gerritevents.GerritQueryException;
import com.sonyericsson.hudson.plugins.gerrit.gerritevents.GerritQueryHandler;

public interface IssueReviewsManager {

    /**
     * Get all Gerrit reviews related to the {@link Issue#getKey() issue key}.
     * 
     * @param issueKey
     * @return A list of {@link JSONObject}s, as retrieved from Gerrit.
     * @throws GerritQueryException If any failure occurs while querying the Gerrit server.
     * @see GerritQueryHandler
     */
    public abstract List<GerritChange> getReviews(String issueKey) throws GerritQueryException;

    public abstract void doApproval(String issueKey, GerritChange change, String args) throws IOException;

}
