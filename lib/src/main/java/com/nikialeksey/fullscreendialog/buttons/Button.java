package com.nikialeksey.fullscreendialog.buttons;

import androidx.annotation.NonNull;

import com.nikialeksey.fullscreendialog.ClickListener;

public interface Button {

    void addOnClick(@NonNull ClickListener clickListener);

    void click();
}
