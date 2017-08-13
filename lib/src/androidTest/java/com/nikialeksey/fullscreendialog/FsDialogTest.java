package com.nikialeksey.fullscreendialog;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatImageButton;
import android.widget.FrameLayout;
import com.nikialeksey.fullscreendialog.buttons.FsActionButton;
import com.nikialeksey.fullscreendialog.buttons.FsCloseButton;
import com.nikialeksey.fullscreendialog.buttons.SimpleButton;
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

    private static final String DIALOG_ACTION = "Action";
    private static final String DIALOG_TITLE = "Dialog Title";

    @Rule
    public ActivityTestRule<TestActivity> rule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void showFsDialog() {
        onView(withText(FsDialogActivity.SHOW_DIALOG_TEXT)).perform(click());

        onView(withText(DIALOG_TITLE)).check(matches(isDisplayed()));
    }

    @Test
    public void actionClicked() {
        onView(withText(FsDialogActivity.SHOW_DIALOG_TEXT)).perform(click());
        onView(withText(DIALOG_ACTION)).perform(click());

        assertThat(rule.getActivity().wasDialogAction, is(true));
    }

    @Test
    public void closeClicked() {
        onView(withText(FsDialogActivity.SHOW_DIALOG_TEXT)).perform(click());
        // @todo #18:30m Bad to use class name matcher. Need configure close button in
        // FsDialog constructor
        onView(ViewMatchers.withClassName(is(AppCompatImageButton.class.getName()))).perform(
            click());

        assertThat(rule.getActivity().wasDialogClose, is(true));
    }

    public static class TestActivity extends FsDialogActivity {

        public boolean wasDialogAction = false;
        public boolean wasDialogClose = false;

        @Override
        public Dialog createDialog() {
            return new FsDialog(this, R.style.Theme_AppCompat,
                new FsDialogToolbar(this, DIALOG_TITLE,
                    new FsCloseButton(new SimpleButton(new ClickListener() {
                        @Override
                        public void onClick() {
                            wasDialogClose = true;
                        }
                    }), new ColorDrawable()),
                    new FsActionButton(new SimpleButton(new ClickListener() {
                        @Override
                        public void onClick() {
                            wasDialogAction = true;
                        }
                    }), DIALOG_ACTION)), new FrameLayout(this));
        }
    }
}
