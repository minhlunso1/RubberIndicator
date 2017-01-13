package android.minhna.rubberindicator.pager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int pos) {
		
		Log.d("debug","flag"+pos);
		return DummyFragment.newInstance(pos);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
