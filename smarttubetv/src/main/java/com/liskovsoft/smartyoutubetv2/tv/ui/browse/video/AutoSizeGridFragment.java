package com.liskovsoft.smartyoutubetv2.tv.ui.browse.video;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.liskovsoft.smartyoutubetv2.tv.R;
import com.liskovsoft.smartyoutubetv2.tv.ui.common.Utils;
import com.liskovsoft.smartyoutubetv2.tv.ui.mod.fragments.GridFragment;

public class AutoSizeGridFragment extends GridFragment {
    protected int getColumnsNum(int cardWidthResId) {
        return getColumnsNum(cardWidthResId, 1.0f);
    }

    protected int getColumnsNum(int cardWidthResId, float cardScale) {
        Resources res = getResources();
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        int displayWidthPx = (int) (displayMetrics.widthPixels * displayMetrics.density);
        int cardWidthDp = (int) (res.getDimension(cardWidthResId) * cardScale);
        int cardSpacingDp = (int) res.getDimension(R.dimen.grid_item_horizontal_spacing);
        int cardWidthPx = Utils.convertDpToPixel(res, cardWidthDp);
        int cardSpacingPx = Utils.convertDpToPixel(res, cardSpacingDp);

        // Get into consideration space from grid sides
        return (displayWidthPx - cardSpacingPx * 4) / (cardWidthPx + cardSpacingPx);
    }
}
