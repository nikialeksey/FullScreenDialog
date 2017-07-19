package com.nikialeksey.fullscreendialog.theme;


import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.TypedValue;

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
