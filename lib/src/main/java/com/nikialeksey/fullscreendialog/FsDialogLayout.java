package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class FsDialogLayout extends LinearLayout {

    public FsDialogLayout(Context context) {
        super(context);
        init();
    }

    public FsDialogLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FsDialogLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addView(new FsDialogToolbar(getContext()),
                new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
