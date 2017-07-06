package com.nikialeksey.fullscreendialog;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@SuppressLint("ViewConstructor")
public class FsDialogLayout extends LinearLayout {

    public FsDialogLayout(@NonNull final Context context, @NonNull final FsDialogToolbar toolbar) {
        super(context);
        addView(toolbar, new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
