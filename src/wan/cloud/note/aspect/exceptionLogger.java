package wan.cloud.note.aspect;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Timestamp;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class exceptionLogger {

	@AfterThrowing(throwing="e",pointcut="within(wan.cloud.note.controller..*)")
	
	public void log(Exception e){
		PrintWriter pw;
		try {
			FileWriter fw=new FileWriter("./src/date.txt");
			pw = new PrintWriter(fw);
			e.printStackTrace(pw);
			
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
