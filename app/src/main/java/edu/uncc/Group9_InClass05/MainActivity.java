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

public class MainActivity extends AppCompatActivity {
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
}