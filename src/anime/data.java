/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anime;

import com.mashape.unirest.http.HttpResponse;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mtech
 */
public class data {

    JSONObject first;
    JSONObject Second;
    JSONObject third;
    JSONObject forth;
    boolean errString;

    public void get_data(HttpResponse<String> response) {
        Object obj = JSONValue.parse(response.getBody());
        JSONObject js = (JSONObject) obj;
        JSONObject data = (JSONObject) js.get("data");
        JSONObject page = (JSONObject) data.get("Page");
        ArrayList<Object> media = (ArrayList<Object>) page.get("media");
        int i = 0;
        for (Object object : media) {
            i++;
        }
        System.out.println(i);
        if (i >= 4) {
            first = (JSONObject) media.get(0);
            Second = (JSONObject) media.get(1);
            third = (JSONObject) media.get(2);
            forth = (JSONObject) media.get(3);
        }else if (i == 3){
             first = (JSONObject) media.get(0);
            Second = (JSONObject) media.get(1);
            third = (JSONObject) media.get(2);
        }else if(i == 2){
             first = (JSONObject) media.get(0);
            Second = (JSONObject) media.get(1);
        }else if (i == 1){
            first = (JSONObject) media.get(0);
        }else{
            errString = true;
        }

    }
    
    public void get_anime_id(){
    
    }

}
