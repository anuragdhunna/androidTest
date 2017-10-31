package com.viithiisys.android.myplayapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.viithiisys.fragments.LM_Fragement;
import com.viithiisys.fragments.PM_Fragment;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    selectFragment(item);
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent = new Intent(BottomActivity.this, HomeActivity.class);
                    startActivity(intent);
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    selectFragment(item);
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
//
//        Configuration config = getResources().getConfiguration();
//
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        // Check Orientation of Device
//        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            LM_Fragement ls_fragment = new LM_Fragement();
//            fragmentTransaction.replace(android.R.id.content, ls_fragment);
//        } else {
//            PM_Fragment pm_fragment = new PM_Fragment();
//            fragmentTransaction.replace(android.R.id.content, pm_fragment);
//        }
//        fragmentTransaction.commit();
    }


    // Select Acitivity
    public void selectActivity (MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                // Call Activity

                callActivity(new HomeActivity());



        }
    }

    private void callActivity(Activity homeActivity) {

        Intent intent = new Intent(BottomActivity.this, HomeActivity.class);
        startActivity(intent);

    }

    /**
     * Perform action when any item is selected.
     *
     * @param item Item that is selected.
     */
    protected void selectFragment(MenuItem item) {
        Log.d(String.valueOf(item.getItemId()), "The onStop() event");

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                // Action to perform when Home Menu item is selected.
                pushFragment(new PM_Fragment());
                break;
            case R.id.navigation_dashboard:
                // Action to perform when Bag Menu item is selected.
                pushFragment(new LM_Fragement());
                break;
            /*case R.id.navigation_notifications:
                // Action to perform when Account Menu item is selected.
                pushFragment(new AccountFragment());
                break;*/
        }
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        Log.d(String.valueOf(fragment.getId()), "============fragment");
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.navigation, fragment);
                ft.commit();
            }
        }
    }


}
