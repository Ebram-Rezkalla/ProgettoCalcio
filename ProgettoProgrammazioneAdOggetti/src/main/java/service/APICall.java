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

	public void writefileStagioni() throws MalformedURLException, IOException {
		String write1=ChiamataAPI("https://api.football-data.org/v2/competitions/2019");
		String write2=ChiamataAPI("https://api.football-data.org/v2/competitions/2015");
		String write3=ChiamataAPI("https://api.football-data.org/v2/competitions/2002");
		String writef = "["+write1+","+write2+","+write3+"]";
		PrintWriter printwriter= new PrintWriter(new BufferedWriter(new FileWriter("datistagioni .json")));
		printwriter.println(writef);
		printwriter.close();
		}
	
	public void writefileSquadre() throws MalformedURLException, IOException {
		String write1=ChiamataAPI("https://api.football-data.org/v2/competitions/2019/standings");
		String write2=ChiamataAPI("https://api.football-data.org/v2/competitions/2015/standings");
		String write3=ChiamataAPI("https://api.football-data.org/v2/competitions/2002/standings");
		String writef = "["+write1+","+write2+","+write3+"]";
		PrintWriter printwriter= new PrintWriter(new BufferedWriter(new FileWriter("datisquadre.json")));
		printwriter.println(writef);
		printwriter.close();
		}
	
	
	
	public String readfile(String nomefile) throws ParseException, IOException {
		BufferedReader read=new BufferedReader(new FileReader(nomefile));
		String output=read.readLine();
		//read.close();
		return output;
		 
		
	}
}
