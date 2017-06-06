package com.example.usuario.examlp3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.examlp3.bean.Contacto;
import com.example.usuario.examlp3.commons.UrlRest;
import com.example.usuario.examlp3.service.ContactService;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Usuario on 04/06/2017.
 */

public class ContactsRest extends Fragment {


    String contactsId;
    TextView textUrl;
    ListView lstContacts;

    private static final int PROGRESS = 0x1;
    private  int mProgressStatus;
    //private Handler mHandler = new Handler();
    List<Contacto> listContactSs;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contact_tab_rest, container, false);

        ContactService contactService = new ContactService();
        String url = UrlRest.URL_REST;
        List<Contacto> list = contactService.findContact(url);

        textUrl = (TextView)view.findViewById(R.id.textUrl);

        lstContacts = (ListView)view.findViewById(R.id.lstContacts);
        ArrayAdapter<Contacto> adapter = new ArrayAdapter<Contacto>(getActivity(), android.R.layout.simple_list_item_1, list );
        lstContacts.setAdapter(adapter);

        lstContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                Contacto contacto = (Contacto) parent.getItemAtPosition(position);
                contactsId = contacto.getId()+"";
                Toast.makeText(getContext(),"Contacto Seleccionado: " + contacto.getName(), Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}
