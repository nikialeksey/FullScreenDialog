package com.nikialeksey.fullscreendialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.nikialeksey.fullscreendialog.theme.Color;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

public class FsDialog extends AppCompatDialog implements Dialog {

    private final FsDialogToolbar toolbar;

    public FsDialog(@NonNull final Context context, @StyleRes int appThemeId,
                    @NonNull final FsDialogToolbar toolbar, @NonNull final View content) {
        super(context, appThemeId);
        this.toolbar = toolbar;

        prepareWindow(getWindow());

        final LinearLayout dialogLayout = new LinearLayout(context);
        dialogLayout.setOrientation(VERTICAL);

        dialogLayout.addView(toolbar, new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        dialogLayout.addView(content, new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));

        super.setContentView(dialogLayout);
    }

    private void prepareWindow(final Window window) {
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(new Color(getContext(), R.attr.colorPrimaryDark).intValue());
        }
        window.setWindowAnimations(R.style.FsDialogAnimation);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void addOnClose(@NonNull final ClickListener clickListener) {
        toolbar.addOnClose(clickListener);
    }

    @Override
    public void addOnAction(@NonNull final ClickListener clickListener) {
        toolbar.addOnAction(clickListener);
    }
}
