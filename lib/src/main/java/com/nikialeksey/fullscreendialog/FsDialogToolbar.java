package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class FsDialogToolbar extends AppBarLayout {

    public FsDialogToolbar(Context context) {
        super(context);
        init();
    }

    public FsDialogToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        final Toolbar toolbar = new Toolbar(getContext());
        addView(toolbar, new AppBarLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
