package launch;
import java.util.Scanner;

import data.Path;
public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String pathName;
		String exit;
		do{
			System.out.println("Input a path:");
			pathName = scanner.nextLine();
			if (Path.isPath(pathName)) {
				Path path = new Path(pathName);
				System.out.println("Disk: " + path.getDisk());
				System.out.println("Extension: " + path.getExtension());
				System.out.println("File name: " + path.getFileName());
				System.out.println("Path: " + path.getFilePath());
				System.out.println("Folder: " + path.getFolder());				
			}
			else System.out.println("Invalid path name");
			System.out.println("Continue? Input Y/y. Press any key to exit.");
			exit = scanner.nextLine();
		}
		while(exit.equalsIgnoreCase("y"));
	}
}
