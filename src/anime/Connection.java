/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anime;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mtech
 */
public class Connection extends data {

    public void getanime(String search) {

        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://graphql.anilist.co")
                    .header("Content-Type", "application/json")
                    .header("Cookie", "laravel_session=0BlxqGWQ1OyJk3PR7w0uG54BkNmU5c2mv0PPqJT6")
                    .body("{\"query\":\"query ($search: String) { # Define which variables will be used in the query (id)\\r\\n Page(page : 1, perPage: 5){\\r\\n    media (search: $search, type: ANIME, sort: POPULARITY_DESC) { # Insert our variables into the query arguments (id) (type: ANIME is hard-coded in the query)\\r\\n \\r\\n    title {\\r\\n        romaji\\r\\n        }\\r\\n        episodes\\r\\n        duration\\r\\n        bannerImage\\r\\n        coverImage{\\r\\n            large\\r\\n        }\\r\\n        id\\r\\n        averageScore\\r\\n        popularity\\r\\n        \\r\\n    }\\r\\n    \\r\\n  }\\r\\n}\",\"variables\":{\"search\":\"" + search + "\"}}")
                    .asString();
            get_data(response);

            if (forth != null) {
                hold4 = (JSONObject) forth.get("coverImage");
                th4 = (JSONObject) forth.get("title");
                pop4 = new URL((String) hold4.get("large"));
                e4 = (Long) forth.get("episodes");
                p4 = (Long) forth.get("averageScore");
            }
            if (third != null) {
                hold3 = (JSONObject) third.get("coverImage");
                th3 = (JSONObject) third.get("title");
                pop3 = new URL((String) hold3.get("large"));
                e3 = (Long) third.get("episodes");
                p3 = (Long) third.get("averageScore");
            }
            if (Second != null) {
                th2 = (JSONObject) Second.get("title");
                hold2 = (JSONObject) Second.get("coverImage");
                pop2 = new URL((String) hold2.get("large"));
                e2 = (Long) Second.get("episodes");

                p2 = (Long) Second.get("averageScore");

            }
            if (first != null) {
                hold1 = (JSONObject) first.get("coverImage");

                p1 = (Long) first.get("averageScore");
                th1 = (JSONObject) first.get("title");
                pop1 = new URL((String) hold1.get("large"));
                e1 = (Long) first.get("episodes");

            }
            if (first == null) {
                System.out.println("all null");
            }

        } catch (UnirestException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    JSONObject media;

    public JSONObject getanimebyeid(Long id) {
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://graphql.anilist.co")
                    .header("Content-Type", "application/json")
                    .header("Cookie", "laravel_session=JTCE044aJVrvQON8Pz2FaCKOyicNhNSs12atgxcb")
                    .body("{\"query\":\"query ($id: Int) { # Define which variables will be used in the query (id)\\r\\n Page{\\r\\n    media (id: $id, type: ANIME, sort: POPULARITY_DESC) { # Insert our variables into the query arguments (id) (type: ANIME is hard-coded in the query)\\r\\n \\r\\n    title {\\r\\n        romaji\\r\\n        }\\r\\n        episodes\\r\\n        duration\\r\\n        bannerImage\\r\\n        coverImage{\\r\\n            large\\r\\n        }\\r\\n        id\\r\\n        averageScore\\r\\n        popularity\\r\\n        status\\r\\n        season\\r\\n        seasonYear\\r\\n        source\\r\\n        isAdult\\r\\n        \\r\\n    }\\r\\n    \\r\\n  }\\r\\n}\",\"variables\":{\"id\":" + id + "}}")
                    .asString();
            Object obj = JSONValue.parse(response.getBody());
            JSONObject js = (JSONObject) obj;
            JSONObject data = (JSONObject) js.get("data");
            System.out.println(data);
            JSONObject page = (JSONObject) data.get("Page");
            System.out.println(page);
            ArrayList<Object> media = (ArrayList<Object>) page.get("media");
            System.out.println(media.get(0));
            return (JSONObject) media.get(0);
        } catch (UnirestException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(media);
        return media;

    }

    URL pop1;
    URL pop2;
    URL pop3;
    URL pop4;
    JSONObject hold1;
    JSONObject hold2;
    JSONObject hold3;
    JSONObject hold4;
    JSONObject th1;
    JSONObject th2;
    JSONObject th3;
    JSONObject th4;
    Long e1;
    Long e2;
    Long e3;
    Long e4;
    Long p1;
    Long p2;
    Long p3;
    Long p4;

    public void get_pop() {
        Unirest.setTimeouts(0, 0);
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://graphql.anilist.co")
                    .header("Content-Type", "application/json")
                    .header("Cookie", "laravel_session=JTCE044aJVrvQON8Pz2FaCKOyicNhNSs12atgxcb")
                    .body("{\"query\":\"query { # Define which variables will be used in the query (id)\\r\\n Page(page : 1, perPage: 5){ # Insert our variables into the query arguments (id) (type: ANIME is hard-coded in the query)\\r\\n        media(sort: POPULARITY_DESC, type: ANIME){\\r\\n            title{\\r\\n            romaji\\r\\n        }\\r\\n        episodes\\r\\n                coverImage{\\r\\n            large\\r\\n        }\\r\\n        id\\r\\n        popularity\\r\\n        }\\r\\n        \\r\\n  }\\r\\n}\",\"variables\":{}}")
                    .asString();

            get_data(response);
            hold1 = (JSONObject) first.get("coverImage");
            hold2 = (JSONObject) Second.get("coverImage");
            hold3 = (JSONObject) third.get("coverImage");
            hold4 = (JSONObject) forth.get("coverImage");
            th1 = (JSONObject) first.get("title");
            th2 = (JSONObject) Second.get("title");
            th3 = (JSONObject) third.get("title");
            th4 = (JSONObject) forth.get("title");
            pop1 = new URL((String) hold1.get("large"));
            pop2 = new URL((String) hold2.get("large"));
            pop3 = new URL((String) hold3.get("large"));
            pop4 = new URL((String) hold4.get("large"));
            e1 = (Long) first.get("episodes");
            e2 = (Long) Second.get("episodes");
            e3 = (Long) third.get("episodes");
            e4 = (Long) forth.get("episodes");
            p1 = (Long) first.get("popularity");
            p2 = (Long) Second.get("popularity");
            p3 = (Long) third.get("popularity");
            p4 = (Long) forth.get("popularity");
        } catch (UnirestException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
