package likert.app.Util;

import likert.app.Callback.OnClickRecycler;

public class RecyclerClick {

    private OnClickRecycler onClickRecycler;
    private int position;

    public RecyclerClick(final OnClickRecycler onClickRecycler) {
        this.onClickRecycler = onClickRecycler;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void execute() {
        onClickRecycler.onClick(getPosition());
    }
}
