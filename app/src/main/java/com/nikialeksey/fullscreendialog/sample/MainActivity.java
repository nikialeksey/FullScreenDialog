package com.nikialeksey.fullscreendialog.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nikialeksey.fullscreendialog.FsDialog;
import com.nikialeksey.fullscreendialog.FsDialogAction;
import com.nikialeksey.fullscreendialog.FsDialogCloseAction;
import com.nikialeksey.fullscreendialog.FsToolbarCloseAction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout content = new FrameLayout(this);

        final TextView textView = new TextView(this, null,
                android.R.style.TextAppearance_Material_Small);
        textView.setText(R.string.mainSampleText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FsDialog(MainActivity.this, R.style.AppTheme, getString(R.string.mainFsDialogTitle), new FsDialogCloseAction() {
                    @Override
                    public void onClose(@NonNull final FsDialog dialog) {

                    }
                }, "Action", new FsDialogAction() {
                    @Override
                    public void onAction(FsDialog dialog) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Sample action", Toast.LENGTH_LONG).show();
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
