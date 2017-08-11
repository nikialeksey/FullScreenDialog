package com.nikialeksey.fullscreendialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class FsActionButton implements Button {

    private final String title;
    private final List<ClickListener> clickListeners = new ArrayList<>();

    public FsActionButton(final String title) {
        this.title = title;
    }

    public FsActionButton(@NonNull final String title, @NonNull final ClickListener action) {
        this(title);
        this.clickListeners.add(action);
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
                    for (final ClickListener clickListener : clickListeners) {
                        clickListener.onClick();
                    }
                    return true;
                }
            });
    }

    @Override
    public void addOnClick(final ClickListener clickListener) {
        this.clickListeners.add(clickListener);
    }
}
