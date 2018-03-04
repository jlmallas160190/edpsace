/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ejb.Stateless;
import org.json.JSONException;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class ServiceClient implements Serializable {

    public String getResponse(String paramUrl, String query) {
        StringBuilder response = new StringBuilder();
        try {
            String paramUrlQuery = paramUrl + "?" + query;
            URL url = new URL(paramUrlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes("");
            wr.close();
            //Get Response  
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            // or StringBuffer if Java version 5+
            String line;

            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }

            rd.close();
        } catch (IOException e) {

        } catch (JSONException e) {
            System.out.println(e);
        }
        return response.toString();
    }
}
