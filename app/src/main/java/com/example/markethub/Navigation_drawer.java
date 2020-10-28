package com.example.markethub;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class Navigation_drawer extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    FragmentManager manager;
    FragmentTransaction transaction;
    ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationdrawer);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView=(NavigationView)findViewById(R.id.navigation);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //Main fragment
         manager =getSupportFragmentManager();
     transaction= manager.beginTransaction();
     transaction.add(R.id.container_frag, new MainFragment());
     transaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
               switch (item.getItemId())
                {
                    case R.id.dashboard:
                        toolbar.setTitle("Dashboard");
                        manager =getSupportFragmentManager();
                        transaction= manager.beginTransaction();
                        transaction.replace(R.id.container_frag, new DashboardFragment());
                        transaction.commit();
                        break;
                    case R.id.marketwatch:
                        toolbar.setTitle("MarketWatch");
                        manager =getSupportFragmentManager();
                        transaction= manager.beginTransaction();
                        transaction.replace(R.id.container_frag, new MarketWatch_Fragment());
                        transaction.commit();
                       // Toast.makeText(Navigation_drawer.this,"marketwatch",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.reports:
                        toolbar.setTitle("Reports");
                       // Toast.makeText(Navigation_drawer.this,"reports",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.analytictool:
                        Toast.makeText(Navigation_drawer.this,"analytictool",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mf:
                        Toast.makeText(Navigation_drawer.this,"mf",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.advisory:
                        Toast.makeText(Navigation_drawer.this,"advisory",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.news:
                        Toast.makeText(Navigation_drawer.this,"news",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.product:
                        Toast.makeText(Navigation_drawer.this,"product",Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        View view=navigationView.getHeaderView(0);
        TextView email=(TextView)view.findViewById(R.id.email);
        TextView name=(TextView)view.findViewById(R.id.name);
        email.setText("heenakathrotiya@gmail.com");
        name.setText("heena");

    }
    public  void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
    }
