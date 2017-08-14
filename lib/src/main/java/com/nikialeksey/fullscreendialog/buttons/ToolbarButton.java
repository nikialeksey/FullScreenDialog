package com.nikialeksey.fullscreendialog.buttons;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

public interface ToolbarButton extends Button {
    void addInToolbar(@NonNull Toolbar toolbar);
}
