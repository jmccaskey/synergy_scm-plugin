package hudson.plugins.synergy.impl;

/**
 * Get project grouping for release and member status.
 */
public class GetProjectGroupingCommand extends Command {
	private String release;	
	private String memberStatus;
	private String owner;
	private String projectGrouping;
	
	public GetProjectGroupingCommand(String release, String memberStatus, String owner) {
		this.release = release;
		this.memberStatus = memberStatus;
		this.owner = owner;
	}
	@Override
	public String[] buildCommand(String ccmExe) {	
		String[] commands = new String[] { ccmExe, "query", "-u", "-f", "%objectname", "type='project_grouping' and release='" + release + "' and member_status='" + memberStatus + "' and owner='" + owner + "'"};
		return commands;			
	}
	@Override
	public void parseResult(String result) {
		projectGrouping = result.trim();
	}
	public String getProjectGrouping() {
		return projectGrouping;
	}
	
}

