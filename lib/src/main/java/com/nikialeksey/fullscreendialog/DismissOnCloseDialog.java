package com.nikialeksey.fullscreendialog;

public class DismissOnCloseDialog implements FsDialog {

    private final FsDialog origin;

    public DismissOnCloseDialog(final FsDialog origin) {
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
    public void addOnClose(final ClickListener click) {
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
