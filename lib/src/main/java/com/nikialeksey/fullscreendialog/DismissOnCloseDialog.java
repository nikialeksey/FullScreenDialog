package com.nikialeksey.fullscreendialog;

import androidx.annotation.NonNull;

public class DismissOnCloseDialog implements Dialog {

    private final Dialog origin;

    public DismissOnCloseDialog(@NonNull final Dialog origin) {
        this.origin = origin;
        this.origin.addOnClose(new ClickListener() {
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
    public void addOnClose(@NonNull final ClickListener clickListener) {
        origin.addOnClose(clickListener);
    }

    @Override
    public void addOnAction(@NonNull final ClickListener clickListener) {
        origin.addOnAction(clickListener);
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
