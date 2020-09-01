package data;

import java.util.Properties;

public class ProjectData {
	// Attributes
	public String title;
	public String startDate;
	public String endDate;
	public String times;
	public String timeUnit;
	public String status;

	// Constructor
	private ProjectData(String tit, String start, String end, String time, String timeU, String stat) {

		this.title = tit;
		this.startDate = start;
		this.endDate = end;
		this.times = time;
		this.timeUnit = timeU;
		this.status = stat;

	}

	// Selector de datos por Int
	public static ProjectData get(int n, Properties prop) {
		ProjectData data = new ProjectData("", "", "", "", "", "");

		data.title = prop.getProperty("title_" + n);
		data.startDate = prop.getProperty("startDate_" + n);
		data.endDate = prop.getProperty("endDate_" + n);
		data.times = prop.getProperty("times_" + n);
		data.timeUnit = prop.getProperty("timeUnit_" + n);
		data.status = prop.getProperty("status_" + n);

		return data;

	}

}
