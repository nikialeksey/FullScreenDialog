package com.nikialeksey.fullscreendialog.buttons;

import androidx.annotation.NonNull;

import com.nikialeksey.fullscreendialog.ClickListener;
import java.util.ArrayList;
import java.util.List;

public class SimpleButton implements Button {

    private final List<ClickListener> clickListeners = new ArrayList<>();

    public SimpleButton() {
    }

    public SimpleButton(@NonNull final ClickListener clickListener) {
        addOnClick(clickListener);
    }

    @Override
    public void addOnClick(@NonNull final ClickListener clickListener) {
        this.clickListeners.add(clickListener);
    }

    @Override
    public void click() {
        for (final ClickListener clickListener : clickListeners) {
            clickListener.onClick();
        }
    }
}
