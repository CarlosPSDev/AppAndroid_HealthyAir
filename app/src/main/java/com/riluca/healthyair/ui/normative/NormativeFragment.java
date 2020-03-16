package com.riluca.healthyair.ui.normative;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.riluca.healthyair.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NormativeFragment extends Fragment {

    private TextView txt;
    private PDFView pdf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_normative, container, false);

        pdf = vista.findViewById(R.id.ViewPdf);
        txt = vista.findViewById(R.id.txt);

        String pdfUrl = "https://www.esmadrid.com/sites/default/files/protocolo_anticontaminacion_madrid_08102018.pdf";

        try{
            new RetrievePdfStream().execute(pdfUrl);
        }
        catch (Exception e){
           // TODO:
        }

        return  vista;
    }

    class RetrievePdfStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }
            } catch (IOException e) {
                return null;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdf.fromStream(inputStream).load();
        }
    }

}