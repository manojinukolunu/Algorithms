package manoj.experiments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class BulkInsertJDBC {

	public static String bulkInsertSoftwareSQL = "BULK INSERT AM_ASSET_SOFTWARE_INSTALLED_manoj FROM 'C:\\software10000.txt' WITH (  FIELDTERMINATOR = ',', ROWTERMINATOR = '\r\n');";
	public static String bulkInsertTestSQL = "BULK INSERT AM_ASSET_SOFTWARE_INSTALLED_manoj FROM 'C:\\software10000.txt' WITH (  FIELDTERMINATOR = ',', ROWTERMINATOR = '\r\n');";

	public static String url = "jdbc:jtds:sqlserver://nam-2k8r2-vm4;user=sa;password=interOP@123;databaseName=platform_esd_app_db_999999";

	public Connection getConnection(String userName, String password, String url) throws Exception {
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

	private void execBcp(String bcpCommand) {
		try {
			Process process = Runtime.getRuntime().exec(bcpCommand);
			String line, output = "";
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = input.readLine()) != null) {
				output += (line + '\n');
			}
			System.out.println(output);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void executeBCP(String fileName) {
		String bcpSoftwares = "bcp platform_esd_app_db_999999.dbo.AM_ASSET_SOFTWARE_INSTALLED_MANOJ in " + fileName + " -h \"CHECK_CONSTRAINTS\" ,\"FIRE_TRIGGERS\" -f c:/format.xml -U sa -P interOP@123 -S NAM-2K8R2-VM4";
		String bcpAssets = "bcp platform_esd_app_db_999999.dbo.AM_BULK_ASSET_CUSTOM_ATTRIBUTES in " + fileName + " -h \"CHECK_CONSTRAINTS\" -h \"FIRE_TRIGGERS\" -f c:/assetformat.xml -U sa -P interOP@123 -S NAM-2K8R2-VM4";
		execBcp(bcpAssets);
	}

	public static void main(String[] args) throws Exception {
		BulkInsertJDBC bulk = new BulkInsertJDBC();
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().contains("--");
			}
		};
		long time = System.currentTimeMillis();
		// File[] f =
		// PerformBulkImport.performBulkImportFromDirectory("C:/Data/BulkTest/Software",
		// filter);
		// for (File file : f) {
		// System.out.println("Executing bcp on " + file.getAbsolutePath());
		//
		// }.
		bulk.executeBCP("C:/Data/BulkTest/Asset/assetAttributes.txt");
		long finalTime = System.currentTimeMillis();

		System.out.println("Total time is " + ((finalTime - time) / 1000));

	}
}
