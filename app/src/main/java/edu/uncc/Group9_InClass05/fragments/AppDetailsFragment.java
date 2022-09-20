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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import edu.uncc.Group9_InClass05.databinding.FragmentAppDetailsBinding;
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

        getActivity().setTitle(app.getName());

        // Initialize TextViews
        TextView appDetailsName = binding.appDetailsName;
        TextView appDetailsArtist = binding.appDetailsArtist;
        TextView appDetailsDate = binding.appDetailsDate;

        // Set TextViews to corresponding information
        appDetailsName.setText(app.getName());
        appDetailsArtist.setText(app.getArtistName());
        appDetailsDate.setText(app.getReleaseDate());

        ListView listViewGenres = binding.listViewGenres;

        // Apply the categories to the ListView
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, app.getGenres());
        listViewGenres.setAdapter(adapter);
    }
}