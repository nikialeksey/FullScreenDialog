package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.content.res.AppCompatResources;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nikialeksey.fullscreendialog.theme.Color;

public class FsDialog extends AppCompatDialog {

    public FsDialog(@NonNull final Context context, @StyleRes int appThemeId,
                    @NonNull final FsDialogLayout fsDialogLayout) {
        super(context, appThemeId);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }

        window.setWindowAnimations(R.style.FsDialogAnimation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(new Color(getContext(), R.attr.colorPrimaryDark).intValue());
        }

        super.setContentView(fsDialogLayout);

        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }
}
