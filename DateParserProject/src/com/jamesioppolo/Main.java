package com.jamesioppolo;

import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  

public class Main {  
public static void main(String[] args) {  

	// Initialises Spring
	Resource resource=new ClassPathResource("applicationContext.xml");  
    	BeanFactory factory=new XmlBeanFactory(resource);  
      
    	// Gets the date parser from the container and executes it
    	System.out.println("Date Parser Console Input");
    	ConsoleInputDateParser dateParser=(ConsoleInputDateParser)factory.getBean("consoleinputdateparser");  
    	dateParser.execute();      
	}  
}  
