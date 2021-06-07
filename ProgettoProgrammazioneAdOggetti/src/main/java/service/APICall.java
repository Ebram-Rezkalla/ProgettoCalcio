package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.json.ParseException;

public class APICall {
	
	
	
	public String ChiamataAPI(String url) throws MalformedURLException, IOException {
		
		HttpsURLConnection openConnection= (HttpsURLConnection) new URL(url).openConnection();
		openConnection.addRequestProperty("X-Auth-Token", "7c3732db0c284300b743a2f9d193e9e2");
		BufferedReader in=new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
		String input= in.readLine();
		return input;
		}

	public void writefile(String url) throws MalformedURLException, IOException {
		String write=ChiamataAPI(url);
		PrintWriter printwriter= new PrintWriter(new BufferedWriter(new FileWriter("dati.json")));
		printwriter.println(write);
		printwriter.close();
		}
	
	
	public String readfile() throws ParseException, IOException {
		BufferedReader read=new BufferedReader(new FileReader("dati.json"));
		String output=read.readLine();
		
		return output;
		 
		
	}
}
