package com.nikialeksey.fullscreendialog.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nikialeksey.fullscreendialog.FsDialog;
import com.nikialeksey.fullscreendialog.FsDialogCloseAction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout content = new FrameLayout(this);
        final TextView textView = new TextView(this, null,
                android.R.style.TextAppearance_Material_Small);
        textView.setText(R.string.mainSampleText);
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        content.addView(textView, lp);

        setContentView(content);

        new FsDialog(this, getString(R.string.mainFsDialogTitle), new FsDialogCloseAction() {
            @Override
            public void onClose() {

            }
        }).show();
    }
}
