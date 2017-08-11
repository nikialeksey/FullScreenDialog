package com.nikialeksey.fullscreendialog;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FsCloseButton implements Button {

    private final Drawable icon;
    private final List<ClickListener> clickListeners = new ArrayList<>();

    public FsCloseButton(final Drawable icon) {
        this.icon = icon;
    }

    public FsCloseButton(@NonNull final Drawable icon, @NonNull final ClickListener action) {
        this(icon);
        this.clickListeners.add(action);
    }

    public void addInToolbar(@NonNull final Toolbar toolbar) {
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (final ClickListener clickListener : clickListeners) {
                    clickListener.onClick();
                }
            }
        });
    }

    @Override
    public void addOnClick(final ClickListener clickListener) {
        clickListeners.add(clickListener);
    }
}
