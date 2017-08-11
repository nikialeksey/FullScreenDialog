package com.nikialeksey.fullscreendialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import com.nikialeksey.fullscreendialog.buttons.ToolbarButton;
import com.nikialeksey.fullscreendialog.theme.Color;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@SuppressLint("ViewConstructor")
public class FsDialogToolbar extends AppBarLayout {

    private final ToolbarButton fsCloseButton;

    public FsDialogToolbar(@NonNull final Context context, @NonNull final String title,
                           @NonNull final ToolbarButton closeButton,
                           @NonNull final ToolbarButton actionButton) {
        super(context);
        this.fsCloseButton = closeButton;

        final Color textColorPrimary = new Color(context, android.R.attr.textColorPrimary);

        final Toolbar toolbar = new Toolbar(getContext());
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(textColorPrimary.intValue());

        closeButton.addInToolbar(toolbar);
        actionButton.addInToolbar(toolbar);

        addView(toolbar, new AppBarLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
    }

    public void addOnClose(@NonNull final ClickListener clickListener) {
        fsCloseButton.addOnClick(clickListener);
    }
}
