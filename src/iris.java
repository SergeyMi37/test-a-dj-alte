import com.intersystems.jdbc.IRIS;
import com.intersystems.jdbc.IRISConnection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class iris {
    //java iris localhost 1972 USER _system SYS apptools.core.django TS '{"status":"ok"}'
	public static void main(String[] args) {
	// init connection
		String host   = args[0];
		String port = args[1];
		String ns = args[2];
		String user = args[3];
		String pwd  = args[4];
    	String className = args[5];
    	String methodName = args[6];
    	String initstr = args[7];
	// get connected
	try {
		IRISConnection conn = (IRISConnection) DriverManager.getConnection("jdbc:IRIS://"+ host +":"+ port +"/"+ ns,user,pwd);
    	IRIS iris = IRIS.createIRIS(conn) ;

    	String result=iris.functionString("run","%ZAPM",className,methodName,initstr) ;	
    	System.out.println(result);

    	iris.close();
    	conn.close();
		}
  	catch (Exception e) {
          System.out.println("Error -- "+e.getMessage());
    }
    return ;
	}
}
