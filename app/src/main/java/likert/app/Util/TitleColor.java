package likert.app.Util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import likert.app.R;

public class TitleColor {

    private SpannableStringBuilder title;
    private Context mContext;

    public TitleColor(Context mContext) {
        this.mContext = mContext;
        SpannableStringBuilder title = new SpannableStringBuilder(mContext.getString(R.string.success_text));
        int color = mContext.getResources().getColor(android.R.color.holo_orange_dark);
        ForegroundColorSpan fcs = new ForegroundColorSpan(color);
        title.setSpan(fcs, 20, title.length(), 0);
        setTitle(title);
    }

    public SpannableStringBuilder getTitle() {
        return title;
    }

    public void setTitle(SpannableStringBuilder title) {
        this.title = title;
    }
}
