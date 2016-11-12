package in.devmetric.opportunityhackcwdr;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

import in.devmetric.opportunityhackcwdr.Adapters.ViewPagerAdapters;
import in.devmetric.opportunityhackcwdr.BaseFrame.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFrame();
        mainScreenHolder.viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapters adapters = new ViewPagerAdapters(fm);
        mainScreenHolder.viewPager.setAdapter(adapters);

        mainScreenHolder.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mainScreenHolder.bottomBar.setCurrentItem(position);
                setPageTitle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mainScreenHolder.bottomBar.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                mainScreenHolder.viewPager.setCurrentItem(position);
                setPageTitle(position);
                return true;
            }
        });

    }

}
