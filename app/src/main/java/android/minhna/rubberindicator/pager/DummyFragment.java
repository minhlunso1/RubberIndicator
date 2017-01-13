package android.minhna.rubberindicator.pager;

import android.minhna.rubberindicator.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DummyFragment extends Fragment {

	private int pos;

	public static DummyFragment newInstance(int pos) {
		DummyFragment dummyFragment = new DummyFragment();
		dummyFragment.pos = pos;
		return dummyFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setGravity(Gravity.CENTER);
		textView.setText("Page " + (pos+1));
		textView.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
		textView.setTextSize(32.0f);

		View v = new View(getActivity());
		v.setLayoutParams(new ViewPager.LayoutParams());
		if (pos==0)
			v.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
		else if (pos==1)
			v.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
		else
			v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
		return v;
		
//		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
//		params.setMargins(0, 20, 0, 0);
//		TextView textView2 = new TextView(getActivity());
//		textView2.setLayoutParams(params);
//		textView2.setGravity(Gravity.CENTER);
//		textView2.setText("Minh");
//		
//		RelativeLayout layout = new RelativeLayout(getActivity());
//		layout.addView(textView);
//		layout.addView(textView2);
//		return layout;
	}
}
