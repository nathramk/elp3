package com.example.usuario.examlp3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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
    private Handler mHandler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
    List<Contactos> listContactSs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contact_tab_rest, container, false);
        return view;
    }
}
