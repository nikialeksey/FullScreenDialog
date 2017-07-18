package com.nikialeksey.fullscreendialog;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FsDialog extends AppCompatDialog {

    public FsDialog(@NonNull final Context context, @NonNull final String title,
                    @NonNull final FsDialogCloseAction closeAction,
                    @NonNull final String actionTitle, @NonNull final FsDialogAction action) {
        super(context);
        // @todo #10:60m make the system bar and nav bar true color, when dialog is showing
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        final Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Non visual activity");
        }

        final View root = new FsDialogLayout(context, new FsDialogToolbar(context, title, new FsToolbarCloseAction() {
            @Override
            public void onClose() {
                dismiss();
                closeAction.onClose(FsDialog.this);
            }
        }, actionTitle, new FsToolbarAction() {
            @Override
            public void onAction() {
                action.onAction(FsDialog.this);
            }
        }));
        super.setContentView(root);

        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
    }
}
