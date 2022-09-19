/**
 * In Class 05
 * Group9_InClass5
 * Phi Ha
 * Srinath Dittakavi
 */

package edu.uncc.Group9_InClass05.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.Group9_InClass05.R;
import edu.uncc.Group9_InClass05.databinding.FragmentAppDetailsBinding;
import edu.uncc.Group9_InClass05.models.AppDetailsAdapter;
import edu.uncc.Group9_InClass05.models.AppsListAdapter;
import edu.uncc.Group9_InClass05.models.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppDetailsFragment extends Fragment {
    FragmentAppDetailsBinding binding;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_APP = "app";

    private DataServices.App app;

    ArrayAdapter adapter;

    public AppDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param app The App object to be displayed
     * @return A new instance of fragment AppDetailsFragment.
     */
    public static AppDetailsFragment newInstance(DataServices.App app) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_APP, app);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            app =(DataServices.App) getArguments().getSerializable(ARG_PARAM_APP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView appDetailsName = binding.appDetailsName;
        TextView appDetailsArtist = binding.appDetailsArtist;
        TextView appDetailsDate = binding.appDetailsDate;

        ListView listViewGenres = binding.listViewGenres;

        adapter = new AppDetailsAdapter(getActivity(), R.layout.app_details_row_item, app);
        listViewGenres.setAdapter(adapter);
    }
}