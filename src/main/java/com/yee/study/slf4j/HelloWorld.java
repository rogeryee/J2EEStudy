package com.yee.study.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	    logger.info("Hello World!");
	}
}
