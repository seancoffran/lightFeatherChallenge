package com.seanco.work.CodingChallenge.main;

import com.seanco.work.CodingChallenge.server.WebServer;

public class Main {
	public static int port = 23456;
	public static void main(String[] args) {
		// start http server
		WebServer httpServer = new WebServer();
		httpServer.Start(port);
		
	}
}


/**
 * example json to post
 * {	
  "Message": "Dad",
	"Shift": 3
}
 */
