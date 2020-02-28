package com.riluca.healthyair.ui.normative;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.riluca.healthyair.R;

public class NormativeFragment extends SingleFragment {

    private GalleryViewModel galleryViewModel;


    @Override
    protected Fragment createFragment() {
        return new ReciclerFragment().newInstance();
    }

}