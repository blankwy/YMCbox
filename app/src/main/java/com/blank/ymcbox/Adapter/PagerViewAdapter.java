package com.blank.ymcbox.Adapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {
	List<Fragment> viewList=new ArrayList<Fragment>();
	public PagerViewAdapter(FragmentManager manager){
		super(manager);
	}
	
	@Override
	public Fragment getItem(int position) {
		return viewList.get(position);
	}

	@Override
	public int getCount() {
		return viewList.size();
	}
	
	public void addFragment(Fragment item){
		this.viewList.add(item);
	}
    
    
    
}
