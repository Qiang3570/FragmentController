package com.johnny.fragmentcontroller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

public class MainFragmentActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        fragmentManager=getFragmentManager();
        ((RadioGroup)findViewById(R.id.rgcontroller)).setOnCheckedChangeListener(this);
        ((RadioGroup)findViewById(R.id.rgcontroller)).check(R.id.rbone);/*默认先显示第一页*/
    }

    /**
     * 显示fragment
     */
    private void showFragment(int index){
        fragmentTransaction=fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);/*想要显示一个fragment,先隐藏所有fragment，防止重叠*/
        switch (index){
            case 1:
                /*如果fragment1已经存在则将其显示出来*/
                if (oneFragment != null)
                    fragmentTransaction.show(oneFragment);
			    /*否则是第一次切换则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add*/
                else {
                    oneFragment = new OneFragment();
                    fragmentTransaction.add(R.id.fragment_controller, oneFragment);
                }
                break;
            case 2:
                if(twoFragment!=null)
                    fragmentTransaction.show(twoFragment);
                else{
                    twoFragment=new TwoFragment();
                    fragmentTransaction.add(R.id.fragment_controller, twoFragment);
                }
                break;
            case 3:
                if(threeFragment!=null)
                    fragmentTransaction.show(threeFragment);
                else{
                    threeFragment=new ThreeFragment();
                    fragmentTransaction.add(R.id.fragment_controller, threeFragment);
                }
                break;
            case 4:
                if(fourFragment!=null)
                    fragmentTransaction.show(fourFragment);
                else{
                    fourFragment=new FourFragment();
                    fragmentTransaction.add(R.id.fragment_controller, fourFragment);
                }
                break;
            case 5:
                if(fiveFragment!=null)
                    fragmentTransaction.show(fiveFragment);
                else{
                    fiveFragment=new FiveFragment();
                    fragmentTransaction.add(R.id.fragment_controller, fiveFragment);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏fragment
     */
    private void hideFragment(FragmentTransaction ft){
        if(oneFragment!=null)
            ft.hide(oneFragment);
        if(twoFragment!=null)
            ft.hide(twoFragment);
        if(threeFragment!=null)
            ft.hide(threeFragment);
        if(fourFragment!=null)
            ft.hide(fourFragment);
        if(fiveFragment!=null)
            ft.hide(fiveFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbone:
                showFragment(1);
                break;
            case R.id.rbtwo:
                showFragment(2);
                break;
            case R.id.rbthree:
                showFragment(3);
                break;
            case R.id.rbfour:
                showFragment(4);
                break;
            case R.id.rbfive:
                showFragment(5);
                break;
        }
    }
}
