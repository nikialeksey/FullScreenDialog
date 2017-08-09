package com.nikialeksey.fullscreendialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class FsActionButton {

    private final String title;
    private final FsButtonClick action;

    public FsActionButton(@NonNull final String title, @NonNull final FsButtonClick action) {
        this.title = title;
        this.action = action;
    }

    // @todo #21:30m May be Toolbarable interface?
    public void addInToolbar(@NonNull final Toolbar toolbar) {
        // @todo #17:30m Fix actionTitle color for API 16
        toolbar.getMenu()
            .add(title)
            .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS)
            .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    action.onClick();
                    return true;
                }
            });
    }
}
