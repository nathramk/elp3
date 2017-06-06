package com.example.usuario.examlp3.service;

import com.example.usuario.examlp3.bean.Contacto;
import com.example.usuario.examlp3.rest.RequestMethod;
import com.example.usuario.examlp3.rest.RestClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 06/06/2017.
 */

public class ContactService {

    public List<Contacto> findContact(String url){
        List<Contacto> lst = new ArrayList<>();

        try {
            RestClient client = new RestClient(url);
            client.execute(RequestMethod.GET);
            if (client.getResponseCode() == 200){

                JSONArray jsonArray = new JSONArray(client.getResponse());
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    lst.add(new Contacto(obj.getInt("id"), obj.getString("allName"), obj.getString("nummberPhone")));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("message error: "+e.getLocalizedMessage());
        }



        return lst;
    }

}
