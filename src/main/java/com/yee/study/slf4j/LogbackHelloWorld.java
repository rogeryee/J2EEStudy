package com.yee.study.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackHelloWorld
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Logger logger = LoggerFactory
				.getLogger(LogbackHelloWorld.class);
		logger.debug("Hello World");

		// print internal state
//		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//		StatusPrinter.print(lc);
	}

}