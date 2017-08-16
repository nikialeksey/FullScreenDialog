package com.nikialeksey.fullscreendialog.sample;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.nikialeksey.fullscreendialog.ClickListener;
import com.nikialeksey.fullscreendialog.DismissOnCloseDialog;
import com.nikialeksey.fullscreendialog.DissmissOnActionDialog;
import com.nikialeksey.fullscreendialog.FsDialog;
import com.nikialeksey.fullscreendialog.FsDialogToolbar;
import com.nikialeksey.fullscreendialog.buttons.FsActionButton;
import com.nikialeksey.fullscreendialog.buttons.FsCloseButton;
import com.nikialeksey.fullscreendialog.buttons.SimpleButton;
import com.nikialeksey.fullscreendialog.theme.Color;

import static android.graphics.Color.BLACK;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // @todo #22:30m Think about it, may be create one project with true OOP wrapper for SDK
        /**
         * new FrameLayout(
         *      new CenterInParent(
         *          new Button(
         *              "lalala",
         *              new ShowDialogOnClick(
         *                  new DissmissOnActionDialog(
         *                      new DismissOnCloseDialog(
         new FsDialog(
         context,
         R.style.AppTheme,
         new FsDialogToolbar(
         context,
         getString(R.string.mainFsDialogTitle),
         new FsCloseButton(
         new SimpleButton(
         new ClickListener() {
        @Override public void onClick() {
        Toast.makeText(context, "Close", Toast.LENGTH_LONG).show();
        }
        }),
         closeIcon),
         new FsActionButton(
         new SimpleButton(
         new ClickListener() {
        @Override public void onClick() {
        Toast.makeText(context, "Action", Toast.LENGTH_LONG).show();
        }
        }),
         "Action")), content)))))))
         *
         *
         */

        final TextView textView =
            new TextView(this, null, android.R.style.TextAppearance_Material_Small);
        textView.setTextColor(BLACK);
        textView.setText(R.string.mainSampleText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = MainActivity.this;
                final TextView contentText =
                    new TextView(context, null, android.R.style.TextAppearance_Material_Small);
                contentText.setTextColor(BLACK);
                contentText.setText(R.string.mainFsDialogContentText);

                final FrameLayout content = new FrameLayout(context);
                final FrameLayout.LayoutParams lp =
                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
                lp.gravity = Gravity.CENTER;
                content.addView(contentText, lp);

                final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);
                final Drawable closeIcon =
                    AppCompatResources.getDrawable(context, R.drawable.fs_close_icon);
                closeIcon.setColorFilter(textColorPrimary.intValue(), PorterDuff.Mode.SRC_IN);

                new DissmissOnActionDialog(new DismissOnCloseDialog(
                    new FsDialog(context, R.style.AppTheme,
                        new FsDialogToolbar(context, getString(R.string.mainFsDialogTitle),
                            new FsCloseButton(new SimpleButton(new ClickListener() {
                                @Override
                                public void onClick() {
                                    Toast.makeText(context, "Close", Toast.LENGTH_LONG).show();
                                }
                            }), closeIcon),
                            new FsActionButton(new SimpleButton(new ClickListener() {
                                @Override
                                public void onClick() {
                                    Toast.makeText(context, "Action", Toast.LENGTH_LONG).show();
                                }
                            }), "Action")), content))).show();
            }
        });

        final FrameLayout.LayoutParams lp =
            new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;

        final FrameLayout content = new FrameLayout(this);
        content.addView(textView, lp);

        setContentView(content);
    }
}
