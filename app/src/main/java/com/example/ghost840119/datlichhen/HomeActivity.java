package com.example.ghost840119.datlichhen;


import android.app.Dialog;
import android.support.design.widget.TabLayout;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ghost840119.datlichhen.adapter.PagerApdater;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon_event));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icons_list_friend));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        final PagerApdater adapter = new PagerApdater(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        int tab = tabLayout.getTabCount();
        if (tab==1)
            inflater.inflate(R.menu.menu_fragment_even_layout, menu);
        else
            inflater.inflate(R.menu.menu_fragment_even_layout, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add_even:
                Toast.makeText(HomeActivity.this, "Add Even ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_add_friend:
                DialogSearchFriend();
                break;
            case R.id.menu_account:
                Toast.makeText(HomeActivity.this, "Menu Acount ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                Toast.makeText(HomeActivity.this, "Menu Logout ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search_even:
                break;
            case R.id.menu_search_friend:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void DialogSearchFriend(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.search_friend_layout);
        final EditText edtMailFriend = (EditText)dialog.findViewById(R.id.tv_mail_search);
        Button btnSearch = (Button)dialog.findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailFriend = edtMailFriend.getText().toString().trim();

            }
        });
        dialog.show();
    }

}
