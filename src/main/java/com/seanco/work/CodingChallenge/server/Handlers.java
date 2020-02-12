package com.seanco.work.CodingChallenge.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.JSONObject;

import com.seanco.work.CodingChallenge.cipher.ShiftCipher;
import com.seanco.work.CodingChallenge.main.Main;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handlers {
	public static class RootHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + Main.port
					+ "</h1>";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	public static class PostHandler implements HttpHandler {

		private static final int STATUS_OK = 200;
		private static final int STATUS_FAIL = 500;

		@Override
		public void handle(HttpExchange he) throws IOException {			
			InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			String query = "";
			while(line != null) {
				query += line;
				line = br.readLine();
			}
			String response = "";
			try {
				JSONObject json = new JSONObject(query);
				response = ShiftCipher.cipher(json.getString("Message"), json.getInt("Shift"));
				he.sendResponseHeaders(STATUS_OK, response.length());
				writeOutputStream(response);
			} catch (Exception e) {
				he.sendResponseHeaders(STATUS_FAIL, 0);
			}
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}
	}
	
	 private static void writeOutputStream(String data) {
	        OutputStream os = null;
	        try {
	            os = new FileOutputStream(new File("C:\\Users\\Public\\challenge.txt"));
	            os.write(data.getBytes(), 0, data.length());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                os.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
