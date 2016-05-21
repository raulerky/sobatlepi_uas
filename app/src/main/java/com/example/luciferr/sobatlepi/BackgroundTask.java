package com.example.luciferr.sobatlepi;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by fandy on 21/05/2016.
 */
public class BackgroundTask extends AsyncTask<Void,laptop,Void> {

    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<laptop> arrayList = new ArrayList<>();

    public BackgroundTask(Context ctx){
            this.ctx = ctx;
        activity = (Activity)ctx;
    }
    String json_string = "http://192.168.56.2/sobatLaptop/get_laptop_detail.php";

    @Override
    protected void onPreExecute() {

        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected Void doInBackground(Void... params) {
        try {


            URL url = new URL(json_string);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line=bufferedReader.readLine())!=null){

                stringBuilder.append(line+"\n");
            }


            httpURLConnection.disconnect();
            String json_string = stringBuilder.toString().trim();
            JSONObject jsonObject = new JSONObject(json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            while (count<jsonArray.length())
            {

                JSONObject jo = jsonArray.getJSONObject(count);
                count++;
                laptop lepi = new laptop(jo.getString("tipe"),jo.getString("merk"),jo.getString("jenis"),jo.getInt("harga"));
                publishProgress(lepi);
            }

            Log.d("JSON STRING",json_string);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(laptop... values) {

        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
