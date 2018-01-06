import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Testrun {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<String> a = Arrays.asList(sc.nextLine().split(" "));
		runInShellIO(a);
	}
	

	
	static void runInShellIO(List<String> command) throws IOException {
		Process p = new ProcessBuilder(command).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader (p.getInputStream()));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line=reader.readLine()) != null) {
			builder.append(line);
			builder.append(System.getProperty("line.separator"));
		}
		System.out.println(builder.toString());
		
		

		

		
		
		
	}

}
