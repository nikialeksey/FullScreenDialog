package com.nikialeksey.fullscreendialog;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@SuppressLint("ViewConstructor")
public class FsDialogToolbar extends AppBarLayout {

    // @todo #6:15min Add close action
    public FsDialogToolbar(@NonNull final Context context, @NonNull final String title) {
        super(context);
        init(title);
    }

    private void init(@NonNull final String title) {
        final Toolbar toolbar = new Toolbar(getContext());
        toolbar.setTitle(title);
        addView(toolbar, new AppBarLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
