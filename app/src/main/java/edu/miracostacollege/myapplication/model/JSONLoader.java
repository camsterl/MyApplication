package edu.miracostacollege.myapplication.model;


import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class loads Heros data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (Country) with data.
 */
public class JSONLoader {

    /**
     * Loads JSON data from a file in the assets directory.
     *
     * @param context The activity from which the data is loaded.
     * @throws IOException If there is an error reading from the JSON file.
     */
    public static List<Heros> loadJSONFromAsset(Context context) throws IOException {
        List<Heros> allHeroesList = new ArrayList<>();
        String json = null;
        InputStream is = context.getAssets().open("cs134superheroes.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allHeroesJSON = jsonRootObject.getJSONArray("CS134Superheroes");

            // Done: Loop through all the countries in the JSON data, create a Country
            int length = allHeroesJSON.length();

            JSONObject heroJSON;
            String name;
            String superPower;
            String oneThing;
            Heros heros;
            String fileName;

            for(int i = 0; i < length; i++)
            {
                heroJSON = allHeroesJSON.getJSONObject(i);
                //extract variables       name and region
                name = heroJSON.getString("Name");
                superPower = heroJSON.getString("Superpower");
                oneThing = heroJSON.getString("OneThing");
                fileName = heroJSON.getString("FileName");

                // Done: object for each and add the object to the allCountriesList
                heros = new Heros(name, superPower, oneThing, fileName);
                allHeroesList.add(heros);


            }





        } catch (JSONException e) {
            Log.e("Hero Quiz", e.getMessage());
        }

        return allHeroesList;
    }
}
