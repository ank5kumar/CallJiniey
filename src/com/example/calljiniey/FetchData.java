package com.example.calljiniey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;
import android.widget.Toast;

public class FetchData {


	public static ArrayList<ProblemDevice> GetProblemsForDeviceId(int id)
	{
		ArrayList<ProblemDevice> problems = new ArrayList<ProblemDevice>();

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		InputStream isr=null;
		String result=null;
		String line=null;
		int code;
		String query = Utils.GET_PROBLEM_LIST+Integer.toString(id);
		nameValuePairs.add(new BasicNameValuePair("id",Integer.toString(id)));

		try
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httppget = new HttpGet(query);
			//httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppget); 
			HttpEntity entity = response.getEntity();
			isr = entity.getContent();
			Log.e("pass 1", "connection success ");
		}
		catch(Exception e)
		{
			Log.e("Fail 1", e.toString());

		}     

		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			//String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isr.close();

			result=sb.toString();
		}
		catch(Exception e)
		{
			Log.e("Fail 2", e.toString());
		}     


		try
		{
			JSONArray jArray = new JSONArray(result);
			for(int i=0; i<jArray.length();i++){
				JSONObject json = jArray.getJSONObject(i);
				problems.add(new ProblemDevice(json.getInt("id"),json.getInt("itemid_id") ,json.getString("description")));
				//		records += n+a+"\n";
			}


		}
		catch(Exception e)
		{
			Log.e("Fail 3", e.toString());
		}


		return problems;

	}

	public static ArrayList<Device> GetDeviceList(){
		ArrayList<Device> list = new ArrayList<Device>();
		String result="";
		InputStream isr = null;
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(Utils.GET_DEVICE_LIST); //YOUR PHP SCRIPT ADDRESS
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isr = entity.getContent();
		}
		catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
			//		text.setText("Couldnt connect to database");
		}
		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isr.close();

			result=sb.toString();
		}
		catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try {
			String n = "";
			String a="";
			JSONArray jArray = new JSONArray(result);

			for(int i=0; i<jArray.length();i++){
				JSONObject json = jArray.getJSONObject(i);
				list.add(new Device(json.getInt("id"), json.getString("item"), "No url now"));
				//		records += n+a+"\n";
			}

			//text.setText(result);

		} catch (Exception e) {

			Log.e("log_tag", "Error Parsing Data "+e.toString());
		}

		return list;

	}




}
