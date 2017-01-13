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
    PagerContainer pagerContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		previousPosition=0;
		setContentView(R.layout.activity_main_pager);

//		vpImages = (ViewPager) findViewById(R.id.vpImages);
		mRubberIndicator = (RubberIndicator) findViewById(R.id.rubber);
        pagerContainer = (PagerContainer) findViewById(R.id.pager_container);
        vpImages = pagerContainer.getViewPager();

		mRubberIndicator.setCount(3, 0);

		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        vpImages.setAdapter(adapter);
        vpImages.setOffscreenPageLimit(adapter.getCount());
        vpImages.setPageMargin(120);
        vpImages.setClipChildren(false);

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
