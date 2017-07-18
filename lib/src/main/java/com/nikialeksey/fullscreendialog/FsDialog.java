package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FsDialog extends AppCompatDialog {

    public FsDialog(@NonNull final Context context, @StyleRes int appThemeId,
                    @NonNull final String title, @NonNull final FsDialogCloseAction closeAction,
                    @NonNull final String actionTitle, @NonNull final FsDialogAction action) {
        super(context, appThemeId);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getThemeColor(getContext(), R.attr.colorPrimaryDark));
        }

        final View root = new FsDialogLayout(context, new FsDialogToolbar(context, title, new FsToolbarCloseAction() {
            @Override
            public void onClose() {
                dismiss();
                closeAction.onClose(FsDialog.this);
            }
        }, actionTitle, new FsToolbarAction() {
            @Override
            public void onAction() {
                action.onAction(FsDialog.this);
            }
        }));
        super.setContentView(root);

        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }

    // @todo #11:30m change this method to class
    @ColorInt
    public int getThemeColor(@NonNull final Context context, @AttrRes final int attributeColor) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeColor, value, true);
        return value.data;
    }
}
