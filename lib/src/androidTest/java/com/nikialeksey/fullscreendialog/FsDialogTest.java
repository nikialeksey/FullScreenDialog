package com.nikialeksey.fullscreendialog;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class FsDialogTest {

    public static class FsDialogTestActivity extends Activity {

        public boolean wasDialogAction = false;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            final FrameLayout content = new FrameLayout(this);

            final TextView textView = new TextView(this);
            textView.setText("show");
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new FsDialog(FsDialogTestActivity.this, R.style.Theme_AppCompat, "Dialog Title", new FsDialogCloseAction() {
                        @Override
                        public void onClose(@NonNull final FsDialog dialog) {

                        }
                    }, "Action", new FsDialogAction() {
                        @Override
                        public void onAction(FsDialog dialog) {
                            dialog.dismiss();
                            wasDialogAction = true;
                        }
                    }).show();
                }
            });

            final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER;
            content.addView(textView, lp);

            setContentView(content);
        }
    }

    @Rule
    public ActivityTestRule<FsDialogTestActivity> rule = new ActivityTestRule<>(FsDialogTestActivity.class);

    @Test
    public void actionClicked() {
        onView(withText("show")).perform(click());
        onView(withText("Action")).perform(click());

        assertThat(rule.getActivity().wasDialogAction, is(true));
    }
}
