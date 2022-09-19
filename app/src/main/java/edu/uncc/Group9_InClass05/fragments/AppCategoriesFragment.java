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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.uncc.Group9_InClass05.databinding.FragmentAppCategoriesBinding;
import edu.uncc.Group9_InClass05.models.DataServices;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppCategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppCategoriesFragment extends Fragment {
    FragmentAppCategoriesBinding binding;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_CATEGORIES = "categories";

    private ArrayList<String> categories;
    final static public String TAG = "test";

    ListView listView;
    ArrayAdapter adapter;

    public AppCategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param categories Parameter 1.
     * @return A new instance of fragment AppCategoriesFragment.
     */
    public static AppCategoriesFragment newInstance(ArrayList<String> categories) {
        AppCategoriesFragment fragment = new AppCategoriesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_CATEGORIES, categories);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categories = (ArrayList<String>) getArguments().getSerializable(ARG_PARAM_CATEGORIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppCategoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categories = DataServices.getAppCategories();

        Log.d(TAG, "onViewCreated: " + categories.get(0));
        //adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, categories);
        //listView.setAdapter(adapter);
    }
}