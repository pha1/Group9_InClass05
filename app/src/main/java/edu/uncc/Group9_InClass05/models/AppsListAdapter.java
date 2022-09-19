/**
 * In Class 05
 * Group9_InClass5
 * Phi Ha
 * Srinath Dittakavi
 */

package edu.uncc.Group9_InClass05.models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.uncc.Group9_InClass05.R;
import edu.uncc.Group9_InClass05.fragments.AppsListFragment;
import edu.uncc.Group9_InClass05.models.DataServices;

public class AppsListAdapter extends ArrayAdapter<DataServices.App> {

    final static String TAG = "test";

    public AppsListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.app_row_item, parent, false);
        }

        DataServices.App app = getItem(position);

        TextView textViewAppName = convertView.findViewById(R.id.appName);
        TextView textViewArtistName = convertView.findViewById(R.id.artistName);
        TextView textViewReleaseDate = convertView.findViewById(R.id.releaseDate);

        textViewAppName.setText(app.name);
        textViewArtistName.setText(app.artistName);
        textViewReleaseDate.setText(app.releaseDate);

        return convertView;
    }
}
