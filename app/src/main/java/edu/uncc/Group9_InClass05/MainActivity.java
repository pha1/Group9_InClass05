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
import edu.uncc.Group9_InClass05.fragments.AppsListFragment;

public class MainActivity extends AppCompatActivity implements AppCategoriesFragment.IListener{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}