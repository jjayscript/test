package wan.cloud.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect//将当前组件设置成切面组件
public class ServiceLogger {

	//@Before("within(wan.cloud.note.service..*)")
	
	public void servicelogger(){
		System.out.println("servicelogger");
	}
}
