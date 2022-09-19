package edu.uncc.Group9_InClass05.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.Group9_InClass05.R;

public class AppDetailsAdapter extends ArrayAdapter<DataServices.App> {

    final static String TAG = "test";

    public AppDetailsAdapter(@NonNull Context context, int resource, @NonNull DataServices.App objects) {
        super(context, resource, (List<DataServices.App>) objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.app_details_row_item, parent, false);
        }

        DataServices.App app = getItem(position);

        TextView genreText = convertView.findViewById(R.id.genre_item);

        genreText.setText(app.genres.get(position));

        return convertView;
    }
}
