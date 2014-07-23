package manoj.experiments;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProbClassifierParser {

	private static final String dbClassName = "com.mysql.jdbc.Driver";

	private static final String SQLSERVER_CONNECTION = "jdbc:jtds:sqlserver://nam-2k8r2-vm4;user=sa;password=interOP@123;databaseName=platform_esd_app_db_999999";

	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/PROBLEM_CLASSIFIER";

	private static final String insertSQL = "insert into problems (prob_name,prob_url) values ";

	public void sqlConnect() {

	}

	public static void main(String args[]) throws Exception {

		BulkInsertJDBC sqlserver = new BulkInsertJDBC();

		Connection con = sqlserver
				.getConnection("sa", "interOP@123",
						"jdbc:jtds:sqlserver://nam-2k8r2-vm4;databaseName=platform_esd_app_db_999999");

		Statement st = con.createStatement();
		st.execute("select 1");

		StringBuffer buff = new StringBuffer(insertSQL);
		PreparedStatement prepStmt = con
				.prepareStatement("select * from problem_tags");
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			System.out.println("Count 1");
		}

		File input = new File("C:/probclassifier.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		// Elements tables = doc.getElementsByTag("table");
		// System.out.println(tables.size());
		//
		// for (Element tab : tables) {
		//
		// List<Node> trs = tab.childNodes();
		// for (Node n : trs) {
		//
		// }
		// }
		Elements tds = doc.getElementsByTag("td");
		System.out.println(tds.size());
		for (Element td : tds) {
			for (Element e : td.children()) {
				if (e.nodeName().equals("a")) {
					// print href for problem location and html for name of
					// problem
					// System.out.println(e.attr("href") + " -- " + e.text());
					Element elem = e.parent().parent();
					buff.append("('" + e.text() + "','" + e.attr("href")
							+ "'),");
					String elemText = elem.text();
					if(elemText.indexOf(" ")!=-1){
						System.out.println(elemText+ " -- "+elemText.substring(elemText.indexOf(" ")));
					}
//					System.out.println(elemText.substring(elemText.indexOf(' ')));

//					System.out.println(elem.text() + " --- " + e.attr("href"));
				}
				// System.out.println(e.nodeName());
			}
		}
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate(buff.substring(0, buff.lastIndexOf(",")));
		System.out.println(buff.substring(0, buff.lastIndexOf(",")));

	}
}
