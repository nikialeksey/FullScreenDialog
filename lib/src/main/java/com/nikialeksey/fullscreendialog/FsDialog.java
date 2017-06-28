package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class FsDialog extends AppCompatDialog {

    private final LinearLayout root;

    public FsDialog(Context context) {
        super(context);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }

        root = new FsDialogLayout(context);
        super.setContentView(root);

        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        // @todo #4:15min Set title in toolbar
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }
}
