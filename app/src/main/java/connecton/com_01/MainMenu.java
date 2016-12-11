package connecton.com_01;

import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainMenu extends AppCompatActivity {

    private String[] mListNav;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //membuat fragment default menjadi home dengan mengcommit fragment transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,new HomeFragment());
        ft.commit();
        setTitle("Home");



        mTitle = mDrawerTitle = getTitle();
        //ambil item dr array nav_list
        mListNav = getResources().getStringArray(R.array.nav_list);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        setupToolbar();

        DataModel[] drawerItem = new DataModel[5];

        //Icon dan Nama Item pada Navbar cuy
        drawerItem[0] = new DataModel(/*R.drawable.home,*/ "Home");
        drawerItem[1] = new DataModel(/*R.drawable.silabus,*/ "Silabus");
        drawerItem[2] = new DataModel(/*R.drawable.referensi,*/ "Referensi");
        drawerItem[3] = new DataModel(/*R.drawable.settings,*/ "Settings");
        drawerItem[4] = new DataModel(/*R.drawable.about,*/ "About");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this,R.layout.list_view_item_row,
                drawerItem);
        mDrawerList.setAdapter(adapter);



        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }

        private void selectItem(int position){
            Fragment fragment = null ;
            switch (position){
                case 0 :
                    fragment = new HomeFragment();
                    break;
                case 1 :
                    fragment = new SilabusFragment();
                    break;
                case 2 :
                    fragment = new ReferensiFragment();
                    break;
                case 3 :
                    fragment = new SettingsFragment();
                    break;
                case 4 :
                    fragment = new AboutFragment();
                    break;
                default:
                    break;
            }

            if (fragment != null){
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerList.setSelection(position);
                setTitle(mListNav[position]);
                mDrawerLayout.closeDrawer(mDrawerList);
            }else{
                Log.e("Main Activity", "Error creating fragment");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        super.setTitle(title);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,
                R.string.app_name,R.string.app_name);
        mDrawerToggle.syncState();
    }
}
