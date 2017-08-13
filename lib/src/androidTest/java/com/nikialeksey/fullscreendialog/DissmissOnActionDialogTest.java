package com.nikialeksey.fullscreendialog;

import android.graphics.drawable.ColorDrawable;
import android.support.test.rule.ActivityTestRule;
import android.widget.FrameLayout;
import com.nikialeksey.fullscreendialog.buttons.FsActionButton;
import com.nikialeksey.fullscreendialog.buttons.FsCloseButton;
import com.nikialeksey.fullscreendialog.buttons.SimpleButton;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DissmissOnActionDialogTest {

    private static final String DIALOG_ACTION = "Action and dismiss";
    private static final String DIALOG_TITLE = "Dismiss on Action dialog";

    @Rule
    public ActivityTestRule<TestActivity> rule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void dissmissOnAction() {
        onView(withText(FsDialogActivity.SHOW_DIALOG_TEXT)).perform(click());
        onView(withText(DIALOG_ACTION)).perform(click());

        onView(withText(DIALOG_TITLE)).check(doesNotExist());
    }

    public static class TestActivity extends FsDialogActivity {

        @Override
        public Dialog createDialog() {
            return new DissmissOnActionDialog(new FsDialog(this, R.style.Theme_AppCompat,
                new FsDialogToolbar(this, DIALOG_TITLE,
                    new FsCloseButton(new SimpleButton(), new ColorDrawable()),
                    new FsActionButton(new SimpleButton(), DIALOG_ACTION)), new FrameLayout(this)));
        }
    }
}