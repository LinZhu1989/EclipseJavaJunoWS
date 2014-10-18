package helperUI;

import java.io.FileWriter;

public class RunServerBat {

	private String serverPath;
	private Process p;

	public RunServerBat(String path) {
		serverPath = path;
		p = null;
	}

	public boolean runServer() {
		
		String[] s = serverPath.split("\\\\");
		Runtime rn = Runtime.getRuntime();
		
		try {
			FileWriter writer = new FileWriter("selenium-server.bat ");
			writer.write("java -jar selenium-server-standalone-2.43.1.jar");
			writer.close();
			p = rn.exec("cmd /k start selenium-server.bat");
			return true;
		} catch (Exception e1) {
			return false;
		}
	}

	public boolean stopServer() {

		try {
			p.destroy();
			return true;
		} catch (Exception e2) {
			return false;
		}

	}

}
