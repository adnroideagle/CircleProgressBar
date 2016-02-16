package com.example.circleprogress;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		super.onResume();

		final CircleProgressBar bar = (CircleProgressBar) findViewById(R.id.circle_progressbar);
		bar.setValue(0);

		ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f,
				bar.getMaxValue());
		valueAnimator.setDuration(5000);
		valueAnimator
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						bar.setValue((Float) animation.getAnimatedValue());
					}
				});
		valueAnimator.start();
	}

}
