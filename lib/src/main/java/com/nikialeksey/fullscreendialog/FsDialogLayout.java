package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.LinearLayout;

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
        // @todo #5:60min Initialize appbar layout
        final AppBarLayout appBarLayout = new AppBarLayout(getContext());
        final Toolbar toolbar = new Toolbar(getContext());
        appBarLayout.addView(toolbar);
    }
}
