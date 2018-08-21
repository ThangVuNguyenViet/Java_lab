package data;

public class Path {
	private static final String pathRegex = "([a-zA-Z]:)?(\\\\[\\w._-]+)+\\\\?";
	private String path;
	public Path(String path) {
		this.path = path;
	}
	//C:\thang\thang.txt
	//C:\thang.txt
	//\thang\thang.txt
	//\thang.txt
	
	public static boolean isPath(String path) {
		return path.matches(pathRegex);
	}

	public String getDisk() {
		if (path.indexOf(":") == -1) {
			return null;//No disk
		}
		else {
			return path.substring(0, path.indexOf(":"));//Have disk
		}
	}

	public String getFileName() {		
		int lastSlash = path.lastIndexOf("\\");
		int lastDot = path.lastIndexOf(".");
		if (lastSlash > lastDot) {
			return path.substring(lastSlash + 1); //C:\thang.abc\thang
		}
		else
			return path.substring(lastSlash + 1, lastDot);//C:\thang.abc\thang.txt
	}

	public String getExtension() {
		int lastSlash = path.lastIndexOf("\\");
		int lastDot = path.lastIndexOf(".");
		if (lastSlash > lastDot) {
			return null; //C:\thang.abc\thang
		}
		else
			return path.substring(lastDot + 1);//C:\thang.abc\thang.txt
	}

	public String getFilePath() {
		return path.substring(path.indexOf("\\") + 1, path.lastIndexOf("\\"));
		//C:\thang\thang.txt -> from the first "\" to the last "\"
	}

	public String getFolder() {
		int lastSlash = path.lastIndexOf("\\");
		int nextLastSlash = path.substring(0, lastSlash - 1).lastIndexOf("\\");
		//C:\thang\thang.txt -> from the next last "\" to the last "\"
		return path.substring(nextLastSlash + 1, lastSlash);
	}
	
}
