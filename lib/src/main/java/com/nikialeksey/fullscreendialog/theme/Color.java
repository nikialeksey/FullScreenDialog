package com.nikialeksey.fullscreendialog.theme;


import android.content.Context;
import android.util.TypedValue;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class Color {

    private final int color;

    public Color(@NonNull final Context context, @AttrRes final int attributeColor) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeColor, value, true);
        color = value.data;
    }

    @ColorInt
    public int intValue() {
        return color;
    }
}
