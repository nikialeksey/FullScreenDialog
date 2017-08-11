package com.nikialeksey.fullscreendialog;

import android.content.DialogInterface;

public interface FsDialog extends DialogInterface {
    void show();
    void addOnClose(ClickListener click);
}
