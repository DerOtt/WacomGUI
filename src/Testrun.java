import java.io.IOException;

public class Testrun {

	public static void main(String[] args) {
		


	}
	
	void runInShell(String command) throws IOException  {
		
	Runtime.getRuntime().exec(command);
	
	}
	
	String runInShellIO(String command) throws IOException {
		Runtime.getRuntime().exec(command);
		return 
		
	}

}
