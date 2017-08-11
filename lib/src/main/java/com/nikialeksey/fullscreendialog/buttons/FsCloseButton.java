package com.nikialeksey.fullscreendialog.buttons;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.nikialeksey.fullscreendialog.ClickListener;

public class FsCloseButton implements Button, ToolbarButton {

    private final Button origin;
    private final Drawable icon;

    public FsCloseButton(@NonNull final Button origin, @NonNull final Drawable icon) {
        this.origin = origin;
        this.icon = icon;
    }

    @Override
    public void addInToolbar(@NonNull final Toolbar toolbar) {
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origin.click();
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
