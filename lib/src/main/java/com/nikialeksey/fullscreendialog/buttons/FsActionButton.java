package com.nikialeksey.fullscreendialog.buttons;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nikialeksey.fullscreendialog.ClickListener;

public class FsActionButton implements Button, ToolbarButton {

    private final String title;
    private final Button origin;

    public FsActionButton(@NonNull final Button origin, @NonNull final String title) {
        this.origin = origin;
        this.title = title;
    }

    @Override
    public void addInToolbar(@NonNull final Toolbar toolbar) {
        // @todo #17:30m Fix actionTitle color for API 16
        toolbar.getMenu()
            .add(title)
            .setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS)
            .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(@NonNull final MenuItem item) {
                    origin.click();
                    return true;
                }
            });
    }

    @Override
    public void addOnClick(@NonNull final ClickListener clickListener) {
        origin.addOnClick(clickListener);
    }

    @Override
    public void click() {
        origin.click();
    }
}
