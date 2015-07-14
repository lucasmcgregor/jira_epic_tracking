Progress as a percentage of closed story points/total story points
<!--
customfield_10336 = sum of open children story points
customfield_10344 = sum of all children story points
-->
<!-- @@Formula: 
    (
     ((issue.get("customfield_10334") != null && issue.get("customfield_10336") != null)? ((issue.get("customfield_10334") - issue.get("customfield_10336"))/issue.get("customfield_10334")*100) : 0)
     ).intValue()
 -->
<!-- @@Format: numberTool.format(value) -->