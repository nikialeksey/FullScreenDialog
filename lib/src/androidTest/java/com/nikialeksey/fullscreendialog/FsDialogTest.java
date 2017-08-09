package com.nikialeksey.fullscreendialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatImageButton;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.nikialeksey.fullscreendialog.theme.Color;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class FsDialogTest {

    public static class FsDialogTestActivity extends Activity {

        public boolean wasDialogAction = false;
        public boolean wasDialogClose = false;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            final FrameLayout content = new FrameLayout(this);

            final TextView textView = new TextView(this);
            textView.setText("show");
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Context context = FsDialogTestActivity.this;

                    final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);
                    final Drawable closeIcon = AppCompatResources.getDrawable(context, R.drawable.fs_close_icon);
                    closeIcon.setColorFilter(textColorPrimary.intValue(), PorterDuff.Mode.SRC_IN);
                    final FsCloseButton fsCloseButton = new FsCloseButton(closeIcon, new FsButtonClick() {
                        @Override
                        public void onClick() {
                            wasDialogClose = true;
                        }
                    });

                    final FsActionButton fsActionButton =
                        new FsActionButton("Action", new FsButtonClick() {
                            @Override
                            public void onClick() {
                                wasDialogAction = true;
                            }
                        });

                    new FsDialog(
                        context,
                        R.style.Theme_AppCompat,
                        new FsDialogLayout(
                            context,
                            new FsDialogToolbar(
                                context,
                                "Dialog Title",
                                fsCloseButton,
                                fsActionButton
                            ),
                            new FrameLayout(FsDialogTestActivity.this)
                        )
                    ).show();
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
    public void showFsDialog() {
        onView(withText("show")).perform(click());

        onView(withText("Dialog Title")).check(matches(isDisplayed()));
    }

    @Test
    public void actionClicked() {
        onView(withText("show")).perform(click());
        onView(withText("Action")).perform(click());

        assertThat(rule.getActivity().wasDialogAction, is(true));
    }

    @Test
    public void closeClicked() {
        onView(withText("show")).perform(click());
        // @todo #18:30m Bad to use class name matcher. Need configure close button in FsDialog constructor
        onView(ViewMatchers.withClassName(is(AppCompatImageButton.class.getName()))).perform(click());

        assertThat(rule.getActivity().wasDialogClose, is(true));
    }
}
