package com.nikialeksey.fullscreendialog;

import android.support.annotation.NonNull;

public class DismissOnCloseDialog implements Dialog {

    private final Dialog origin;

    public DismissOnCloseDialog(@NonNull final Dialog origin) {
        this.origin = origin;
        origin.addOnClose(new ClickListener() {
            @Override
            public void onClick() {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        origin.show();
    }

    @Override
    public void addOnClose(@NonNull final ClickListener click) {
        origin.addOnClose(click);
    }

    @Override
    public void cancel() {
        origin.cancel();
    }

    @Override
    public void dismiss() {
        origin.dismiss();
    }
}
