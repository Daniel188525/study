package com.siebre.log4j;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * junit init logging
 * @ClassName: JUnit4ClassRunner
 * @Description: 
 * @author ZhaoHongshuai
 * @date 2016-5-27 ÉÏÎç11:02:57
 * @version 1.0
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {

	static {  
        try {  
            Log4jConfigurer.initLogging("classpath:config/log4j.properties");  
        } catch (FileNotFoundException ex) {  
            System.err.println("Cannot Initialize log4j");  
        }  
    }
	
	public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

}
