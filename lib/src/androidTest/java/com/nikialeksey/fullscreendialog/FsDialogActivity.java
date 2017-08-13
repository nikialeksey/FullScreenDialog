package com.nikialeksey.fullscreendialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class FsDialogActivity extends Activity {

    public static final String SHOW_DIALOG_TEXT = "show";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FrameLayout content = new FrameLayout(this);

        final TextView textView = new TextView(this);
        textView.setText(SHOW_DIALOG_TEXT);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog().show();
            }
        });

        final FrameLayout.LayoutParams lp =
            new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        content.addView(textView, lp);

        setContentView(content);
    }

    public abstract Dialog createDialog();
}
