# jira_epic_tracking
These fields use the Misc Custom Fields, which allow you to create
fields based upon scripts. 
(https://marketplace.atlassian.com/plugins/com.innovalog.jmcf.jira-misc-custom-fields)

Jira does not allow for hierarchical Epics. You can make a parent Epic that "depends on"
children epics via Jira links.

These scripts will total the story points for an Epic and all of the chidlren
Epics and allow you to see progress at each level.

For example:
	Epic A [0 story points] --> calculated 35 out of 80 done (50%)
		Child B (depended upon by A) [10 points down out of 20] --> calculated 20 out of 35 done (57%)
			Child B.1 (depended upon by B) [5 points down out of 10] --> calculated 5 out of 10 done (50%)
			Child B.2 (depended upon by B) [5 points down out of 5] --> calculated 5 out of 5 done (100%)
		Child C (depended upon by A) [15 points down out of 45] --> calculated 15 out of 45 done (30%)
