package android.minhna.rubberindicator.pager;

import android.minhna.rubberindicator.R;
import android.minhna.rubberindicator.view.indicator.RubberIndicator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager vpImages;
	private RubberIndicator mRubberIndicator;
	private int previousPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		previousPosition=0;
		setContentView(R.layout.activity_main_pager);

		vpImages = (ViewPager) findViewById(R.id.vpImages);
		mRubberIndicator = (RubberIndicator) findViewById(R.id.rubber);

		mRubberIndicator.setCount(3, 0);

		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		
		vpImages.setAdapter(adapter);
		
		vpImages.setCurrentItem(0);
		vpImages.setOffscreenPageLimit(0);//run number of off screen, at least 1 so 0 will implicitly change to 1

		vpImages.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				if (previousPosition<position)
					mRubberIndicator.moveToRight();
				else if (previousPosition>position)
					mRubberIndicator.moveToLeft();
                previousPosition=position;
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

}
