package xiaodou.jd_autolayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost;
import android.widget.TextView;

import xiaodou.jd_autolayout.fragment.MyFragment1;
import xiaodou.jd_autolayout.fragment.MyFragment2;
import xiaodou.jd_autolayout.fragment.MyFragment3;
import xiaodou.jd_autolayout.fragment.MyFragment4;
import xiaodou.jd_autolayout.view.TabView;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.初始化TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        // 2.新建TabSpec
        TabHost.TabSpec mTabSpec = mTabHost.newTabSpec("1214");
        TabView tabView1 = new TabView(this);
        tabView1.setText("12月14日");
//        tabView1.setTextColor(Color.parseColor("#F02B2B"));
        mTabSpec.setIndicator(tabView1);
        // 3.添加TabSpec
        mTabHost.addTab(mTabSpec, MyFragment1.class, null);

        mTabSpec = mTabHost.newTabSpec("1216");
        TabView tabView2 = new TabView(this);
        tabView2.setText("12月16日");
        mTabSpec.setIndicator(tabView2);
        mTabHost.addTab(mTabSpec, MyFragment2.class, null);

        mTabSpec = mTabHost.newTabSpec("1217");
        TabView tabView3 = new TabView(this);
        tabView3.setText("12月17日");
        mTabSpec.setIndicator(tabView3);
        mTabHost.addTab(mTabSpec, MyFragment3.class, null);

        mTabSpec = mTabHost.newTabSpec("1218");
        TabView tabView4 = new TabView(this);
        tabView4.setText("12月18日");
        mTabSpec.setIndicator(tabView4);
        mTabHost.addTab(mTabSpec, MyFragment4.class, null);


        mTabHost.setCurrentTabByTag("1214"); // 设置第一次打开时默认显示的标签，
        updateTab(mTabHost);//初始化Tab的颜色，和字体的颜色


        // tab切换
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mTabHost.setCurrentTabByTag(tabId);
                updateTab(mTabHost);
            }
        });
    }

    /**
     * 更新Tab标签(tab的背景颜色、字体大小或颜色)
     *
     * @param tabHost
     */
    public void updateTab(TabHost tabHost){
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++){
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(R.id.tv_text);
            if (tabHost.getCurrentTab() == i){
                tv.setTextColor(Color.parseColor("#F02B2B"));
            }else{
                tv.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

}
