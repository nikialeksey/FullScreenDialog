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

    // @todo #19:30m Add close button instead close action
    public FsDialogToolbar(@NonNull final Context context, @NonNull final String title,
                           @NonNull final FsToolbarCloseAction closeAction,
                           @NonNull final String actionTitle,
                           @NonNull final FsToolbarAction action) {
        super(context);
        final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);

        final Toolbar toolbar = new Toolbar(getContext());
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(textColorPrimary.intValue());

        final Drawable closeIcon = AppCompatResources.getDrawable(context, R.drawable.fs_close_icon);
        closeIcon.setColorFilter(textColorPrimary.intValue(), PorterDuff.Mode.SRC_IN);
        toolbar.setNavigationIcon(closeIcon);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeAction.onClose();
            }
        });

        // @todo #17:30m Fix actionTitle color for API 16
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
