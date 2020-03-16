package com.riluca.healthyair.ui.madrid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.riluca.healthyair.R;

public class WebMadridFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_web_madrid, container,false);
        String url = "https://www.comunidad.madrid/";
        WebView view = (WebView) vista.findViewById(R.id.webWiew);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setLoadWithOverviewMode(true);
        view.getSettings().setUseWideViewPort(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setPluginState(WebSettings.PluginState.ON);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(url);

        return vista;
    }
}