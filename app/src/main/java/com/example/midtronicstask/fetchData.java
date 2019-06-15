package com.example.midtronicstask;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class fetchData extends AsyncTask<Void,Void,Void> {
    public static String country ="";
    String data="";
    String dataParsed = "";
    String singleParsed ="";
    String altSpell="";
    String web = "https://restcountries.eu/rest/v1/name/";
    String add = web + country;
    Double area =0.0; //0.0 is deault or null
    String cName = "";
    String capital ="";
    String region ="";
    String subRegion ="";
    String demonym ="";
    String nativeName ="";
    String relevance ="";
    String alpha2Code ="";
    String alpha3Code ="";
    int population =0;
    String callingCodes = "";
    Double gini =0.0;
    String numericCode= "";
    String lat = "";
    String lng = "";
    String topLevelDomain = "";
    String currencies ="";
    String timezones = "";
    String languages = "";
    String borders = "";

    @Override

    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(add);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if((httpURLConnection.getInputStream()) == null){

            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line !=null)
            {
                line= bufferedReader.readLine();
                data = data + line;

            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
               cName = (String)JO.get("name"); //Country Name
               capital = (String)JO.get("capital");
               region=  (String)JO.get("region");
               subRegion= (String)JO.get("subregion");
               if(JO.isNull("area")== false) //In case if the value is null in JSON file
               {area = (Double)JO.get("area");}
               demonym = (String)JO.get("demonym");
               nativeName = (String)JO.get("nativeName");
               relevance =  (String)JO.get("relevance");
                alpha2Code = (String)JO.get("alpha2Code");
                alpha3Code = (String)JO.get("alpha3Code");
                population = (int)JO.get("population");
                if(JO.isNull("gini")== true) {} //In case if the value is null in JSON file
                else
                {gini = (Double)JO.get("gini");}
                nativeName = (String)JO.get("nativeName");
                numericCode = (String)JO.get("numericCode");

                JSONArray st = JO.getJSONArray("latlng");
                for(int j = 0; j < st.length(); j++)
                {
                    lat = st.getString(0);
                    lng = st.getString(1);
                }
                JSONArray qe = JO.getJSONArray("altSpellings");
                for(int j = 0; j < qe.length(); j++)
                {
                    altSpell = altSpell +qe.getString(j);

                }
                JSONArray tLD = JO.getJSONArray("topLevelDomain");
                for(int j = 0; j < tLD.length(); j++)
                {
                    topLevelDomain = topLevelDomain + tLD.getString(j);

                }

                JSONArray cc = JO.getJSONArray("callingCodes");
                for(int j = 0; j < cc.length(); j++)
                {
                    callingCodes = callingCodes + cc.getString(j);

                }
                JSONArray tz = JO.getJSONArray("timezones");
                for(int j = 0; j < tz.length(); j++)
                {
                    timezones = timezones + tz.getString(j);
                }
                JSONArray bs = JO.getJSONArray("borders");
                for(int j = 0; j < bs.length(); j++)
                {
                    borders = borders +" " + bs.getString(j);
                }
                JSONArray cr = JO.getJSONArray("currencies");
                for(int j = 0; j < cr.length(); j++)
                {
                    currencies = currencies +" " + cr.getString(j);
                }
                JSONArray lng = JO.getJSONArray("languages");
                for(int j = 0; j < lng.length(); j++)
                {
                    languages = languages +" " + lng.getString(j);
                }
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
            System.out.println("Link is not working");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        CountryDetails.cName.setText(this.cName);
        CountryDetails.capitalAns.setText(this.capital);
        CountryDetails.borderAns.setText(this.borders);
        CountryDetails.regionAns.setText(this.region);
        CountryDetails.subRegionAns.setText(this.subRegion);
        CountryDetails.areaAns.setText(Double.toString(this.area));
        CountryDetails.demonymAns.setText(this.demonym);
        CountryDetails.nativeNameAns.setText(this.nativeName);
        CountryDetails.relevanceAns.setText(this.relevance);
        CountryDetails.alpha2CodeAns.setText(this.alpha2Code);
        CountryDetails.alpha3CodeAns.setText(this.alpha3Code);
        CountryDetails.populationAns.setText(Integer.toString(this.population));
        CountryDetails.giniAns.setText(Double.toString(this.gini));
        CountryDetails.numericCodeAns.setText(this.numericCode);
        CountryDetails.latAns.setText(this.lat);
        CountryDetails.lngAns.setText(this.lng);
        CountryDetails.topLevelDomainAns.setText(this.topLevelDomain);
        CountryDetails.currenciesAns.setText(this.currencies);
        CountryDetails.timezonesAns.setText(this.timezones);
        CountryDetails.languagesAns.setText(this.languages);
        CountryDetails.callingCodeAns.setText(this.callingCodes);
    }
}
