package laboration3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class KlientText {

	private static Socket socket;

	public static void main(String[] args) {
		try {
		       socket = new Socket("localhost",4444);
		       BufferedReader in=new BufferedReader
		           (new InputStreamReader(socket.getInputStream()));
		       PrintWriter ut=new PrintWriter(socket.getOutputStream());
		       ut.println("Charlotta"); ut.flush();
		       System.out.println(in.readLine());
		   }catch(Exception e){}

	}

}
