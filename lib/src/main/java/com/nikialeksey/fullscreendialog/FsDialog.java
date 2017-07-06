package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FsDialog extends AppCompatDialog {

    public FsDialog(@NonNull final Context context, @NonNull final String title) {
        super(context);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }

        final View root = new FsDialogLayout(context, new FsDialogToolbar(context, title));
        super.setContentView(root);

        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }
}
