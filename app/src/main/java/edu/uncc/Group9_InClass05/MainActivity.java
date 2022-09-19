/**
 * In Class 05
 * Group9_InClass5
 * Phi Ha
 * Srinath Dittakavi
 */

package edu.uncc.Group9_InClass05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uncc.Group9_InClass05.databinding.ActivityMainBinding;
import edu.uncc.Group9_InClass05.fragments.AppCategoriesFragment;
import edu.uncc.Group9_InClass05.fragments.AppDetailsFragment;
import edu.uncc.Group9_InClass05.fragments.AppsListFragment;
import edu.uncc.Group9_InClass05.models.DataServices;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.IListener, AppsListFragment.IListener{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initial Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoriesFragment())
                .commit();
    }

    /**
     * This method replaces the current Fragment with the AppsListFragment loaded with
     * the selected category
     * @param category The String that holds the name of the desired category to be loaded
     */
    @Override
    public void selectListApps(String category) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppsListFragment.newInstance(category))
                .addToBackStack(null)
                .commit();
    }

    /**
     * This method replaces the current Fragment with the AppDetailsFragment by passing it the
     * desired App object to be viewed
     * @param app The App object of the selected App the user wishes to view
     */
    @Override
    public void appDetails(DataServices.App app) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppDetailsFragment.newInstance(app))
                .addToBackStack(null)
                .commit();
    }
}