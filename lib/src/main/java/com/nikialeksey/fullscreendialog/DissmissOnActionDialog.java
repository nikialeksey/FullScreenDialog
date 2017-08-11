package com.nikialeksey.fullscreendialog;

import android.support.annotation.NonNull;

public class DissmissOnActionDialog implements Dialog {

    private final Dialog origin;

    public DissmissOnActionDialog(@NonNull final Dialog origin) {
        this.origin = origin;
        this.origin.addOnAction(new ClickListener() {
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
