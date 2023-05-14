/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anime;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mtech
 */
public class Anime {
  

   /* public static JFrame ma;*/

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) throws UnirestException {
       
        // TODO code application logic here

         login m = new login();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        
/*

        m = new signup();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        /*
 /*
                Connection c = new Connection();

        System.out.println(c.first.get("duration"));
        System.out.println(c.first.get("title"));
        System.out.println(c.first.get("coverImage"));
        System.out.println(c.first.get("bannerImage"));
**/
    }

}
