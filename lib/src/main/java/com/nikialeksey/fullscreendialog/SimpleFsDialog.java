package com.nikialeksey.fullscreendialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.nikialeksey.fullscreendialog.theme.Color;
import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

public class SimpleFsDialog extends AppCompatDialog implements FsDialog {

    private final FsDialogToolbar toolbar;

    public SimpleFsDialog(@NonNull final Context context, @StyleRes int appThemeId,
                          @NonNull final FsDialogToolbar toolbar, @NonNull final View content) {
        super(context, appThemeId);
        this.toolbar = toolbar;

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

        final LinearLayout dialogLayout = new LinearLayout(context);
        dialogLayout.setOrientation(VERTICAL);

        dialogLayout.addView(toolbar, new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        dialogLayout.addView(content, new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));

        super.setContentView(dialogLayout);

        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void addOnClose(final ClickListener clickListener) {
        toolbar.addOnClose(clickListener);
    }
}
