package com.nikialeksey.fullscreendialog;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FsCloseButton {

    private final Drawable icon;
    private final FsCloseButtonAction action;

    public FsCloseButton(@NonNull final Drawable icon, @NonNull final FsCloseButtonAction action) {
        this.icon = icon;
        this.action = action;
    }

    public void addInToolbar(@NonNull final Toolbar toolbar) {
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.onClose();
            }
        });
    }
}
