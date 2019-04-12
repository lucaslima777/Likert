package likert.app.MainRecycler;

import android.graphics.drawable.Drawable;

public class MainModel {

    private final Drawable idImageColor;
    private final Drawable idImageDefalt;
    private final String txtDescription;

    public MainModel(Drawable idImageColor, Drawable idImageDefalt, String txtDescription) {
        this.idImageColor = idImageColor;
        this.txtDescription = txtDescription;
        this.idImageDefalt = idImageDefalt;
    }

    public Drawable getIdImageColor() {
        return idImageColor;
    }

    public Drawable getIdImageDefalt() {
        return idImageDefalt;
    }

    public String getTxtDescription() {
        return txtDescription;
    }
}
