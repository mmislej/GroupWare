package data;

import java.util.Properties;

public class MemberData {

	// Attributes
	public String member;
	public String projectAvailiability;
	public String role;

	// Constructor
	private MemberData(String m, String pa, String r) {

		this.member = m;
		this.projectAvailiability = pa;
		this.role = r;

	}

	// Selector de datos por Int
	public static MemberData get(int n, Properties prop) {
		MemberData data = new MemberData("", "", "");

		data.member = prop.getProperty("member_" + n);
		data.projectAvailiability = prop.getProperty("projectAvailiability_" + n);
		data.role = prop.getProperty("role_" + n);

		return data;
	}
}
