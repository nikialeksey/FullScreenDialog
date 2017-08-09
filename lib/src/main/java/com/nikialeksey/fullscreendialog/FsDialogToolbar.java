package com.nikialeksey.fullscreendialog;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nikialeksey.fullscreendialog.theme.Color;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@SuppressLint("ViewConstructor")
public class FsDialogToolbar extends AppBarLayout {

    public FsDialogToolbar(@NonNull final Context context, @NonNull final String title,
                           @NonNull final FsCloseButton fsCloseButton,
                           @NonNull final FsActionButton fsActionButton) {
        super(context);
        final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);

        final Toolbar toolbar = new Toolbar(getContext());
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(textColorPrimary.intValue());

        fsCloseButton.addInToolbar(toolbar);
        fsActionButton.addInToolbar(toolbar);

        addView(toolbar, new AppBarLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
