package id.ac.upnyk.fragmentrecycleview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navbar;
    Fragment fragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navbar = findViewById(R.id.main_navbar);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(new Fragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home: fragment = new HomeFragment();
                break;
            case R.id.list: fragment = new ListFragment();
                break;
            case R.id.profile: fragment = new ProfileFragment();
                break;
            case R.id.add: fragment = new AddFragment();
                break;
            case R.id.search: fragment = new SearchFragment();
                break;
        }
        return loadFragment(fragment);
    }
}