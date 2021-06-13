package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


// classe risponsabile della chiamata API e il salvataggio su due file locali
public class APICall {
	
	// metodo che prende il "url" dell'API e restituisce una srtinga che sara salvata sul file 
	
	public String ChiamataAPI(String url) {
		String input = null;
		try {
		HttpsURLConnection openConnection;
		
			openConnection = (HttpsURLConnection) new URL(url).openConnection();
		openConnection.addRequestProperty("X-Auth-Token", "7c3732db0c284300b743a2f9d193e9e2");
		BufferedReader in=new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
		input= in.readLine();
		
		} catch (IOException e ) {}
		return input;
		
		
		}

	public void writefileStagioni()  {
		String write1=ChiamataAPI("https://api.football-data.org/v2/competitions/2019");
		String write2=ChiamataAPI("https://api.football-data.org/v2/competitions/2015");
		String write3=ChiamataAPI("https://api.football-data.org/v2/competitions/2002");
		String writef = "["+write1+","+write2+","+write3+"]";
		PrintWriter printwriter = null;
		try {
			printwriter = new PrintWriter(new BufferedWriter(new FileWriter("datistagioni .json")));
		} catch (IOException e) {}
		printwriter.println(writef);
		printwriter.close();
		}
	
	public void writefileSquadre()  {
		String write1=ChiamataAPI("https://api.football-data.org/v2/competitions/2019/standings");
		String write2=ChiamataAPI("https://api.football-data.org/v2/competitions/2015/standings");
		String write3=ChiamataAPI("https://api.football-data.org/v2/competitions/2002/standings");
		String writef = "["+write1+","+write2+","+write3+"]";
		PrintWriter printwriter = null;
		try {
			printwriter = new PrintWriter(new BufferedWriter(new FileWriter("datisquadre.json")));
		} catch (IOException e) {}
		printwriter.println(writef);
		printwriter.close();
		}
	
	
	
	@SuppressWarnings("resource")
	public String readfile(String nomefile)   {
		String output = "";

		try {
			BufferedReader read;
				read = new BufferedReader(new FileReader(nomefile));
				output = read.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return output;
		 
		
	}
}
