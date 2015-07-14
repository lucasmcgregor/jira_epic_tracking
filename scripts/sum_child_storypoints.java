The sum of story points for children tasks
<!-- @@Formula: 
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.link.IssueLink;
import com.atlassian.jira.issue.link.IssueLinkManager;
import com.atlassian.jira.issue.issuetype.IssueType;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Double;
import java.util.List;

// SWAP THIS WITH THE FIELD WHERE YOU STORE STORY POINTS
private static long STORY_POINT_FIELD = 10007;

private static String STORY_NAME = "Story";
private static String EPIC_NAME = "Epic";

// I ONLY WANT TO INCLUDE CHILDREN THAT ARE STORIES
// OR ARE DEPENDENT EPICS
private static String[] LEGAL_SUB_EPIC_LINKS = {"Dependency", "Epic-Story Link"};

// TRACK ALL THE EPICS CHECKED TO AVOID FOLLOWING CIRCULAR REFS
private List checkedEpics = new ArrayList();

/**
*@return the number of story points for a story
**/
int getStoryPointsForStory(Issue theIssue) {
    int rv = 0;
    CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();
    CustomField storyCF = customFieldManager.getCustomFieldObject(STORY_POINT_FIELD);
    if(theIssue.getCustomFieldValue(storyCF) != null) {
	try {
	    rv = Double.valueOf(theIssue.getCustomFieldValue(storyCF)).intValue();
	} catch (Exception e) {
	}
    }
    return rv;
}

/**
* @return the sum of story points for the given issue
**/
int sumChildrenStoryPoints(Issue theIssue) { int rv = 0; String issueTypeName = theIssue.getIssueTypeObject().getName();

    // IF THE ISSUE IS A STORY, RETURN THE STORY POINTS
    if (STORY_NAME.equals(issueTypeName)) {
	rv = getStoryPointsForStory(theIssue);
	// BAIL EARLY ON NON-EPICS
    } else if (!EPIC_NAME.equals(issueTypeName)) {
	rv = 0;
	// IF IT IS AN EPIC, MAKE SURE WE HAVE NOT CHECK THIS EPIC BEFORE
    } else if (!checkedEpics.contains(theIssue.getId())){
	// REMEMBER TO AVOID CIRCULAR DEPENDENCIES
	checkedEpics.add(theIssue.getId());

	IssueLinkManager issueLinkManager = ComponentAccessor.getIssueLinkManager();
	List legalLinks = Arrays.asList(LEGAL_SUB_EPIC_LINKS);
	for(IssueLink link : issueLinkManager.getOutwardLinks(theIssue.getId())) {
	    if(legalLinks.contains(link.getIssueLinkType().getName())) {
		rv = rv + sumChildrenStoryPoints(link.getDestinationObject());
	    }
	}
    } 

    return rv;
}
sumChildrenStoryPoints(issue.getIssueObject());
 -->
    <!-- @@Format: numberTool.format(value) -->