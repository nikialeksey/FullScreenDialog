package com.nikialeksey.fullscreendialog;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nikialeksey.fullscreendialog.theme.Color;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@SuppressLint("ViewConstructor")
public class FsDialogToolbar extends AppBarLayout {

    public FsDialogToolbar(@NonNull final Context context, @NonNull final String title,
                           // @todo #8:30m Think about close action (may be bad idea)
                           @NonNull final FsToolbarCloseAction closeAction,
                           @NonNull final String actionTitle,
                           @NonNull final FsToolbarAction action) {
        super(context);
        final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);

        final Toolbar toolbar = new Toolbar(getContext());
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(textColorPrimary.intValue());
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeAction.onClose();
            }
        });

        final Drawable closeIcon = ContextCompat.getDrawable(context, R.drawable.fs_close_icon);
        closeIcon.setColorFilter(textColorPrimary.intValue(), PorterDuff.Mode.SRC_IN);
        toolbar.setNavigationIcon(closeIcon);

        toolbar.getMenu()
                .add(actionTitle)
                .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                action.onAction();
                return true;
            }
        });

        addView(toolbar, new AppBarLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }
}
