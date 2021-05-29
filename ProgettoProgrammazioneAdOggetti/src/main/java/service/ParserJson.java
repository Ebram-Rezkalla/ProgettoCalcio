package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Squadra;

public class ParserJson {

	private String url;
	private String dodo;

public ParserJson(String url) {
	this.url=url;
	
}

public HashSet<Squadra> ChiamtaAPI () throws JSONException {
	try {
		HttpsURLConnection openConnection= (HttpsURLConnection) new URL(this.url).openConnection();
		openConnection.addRequestProperty("X-Auth-Token", "7c3732db0c284300b743a2f9d193e9e2");
		BufferedReader in=new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
		dodo= in.readLine();
		if(!dodo.isEmpty()) {
			JSONObject competizione =new JSONObject (dodo);
			JSONArray standings = competizione.getJSONArray("standings");
			JSONObject competizione2=standings.getJSONObject(0);
			JSONArray Teams = competizione2.getJSONArray("table");
			Squadra s;
			for(int i= 0; i<20;i++) {
				s=new Squadra((int)Teams.get("position"),(String)Teams.get());
				
				
				
			}
			
		}
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return dodo;
	
	
	
	
}


}
