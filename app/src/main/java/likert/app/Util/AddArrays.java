package likert.app.Util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import likert.app.R;

public class AddArrays {

    private Context mContext;

    public AddArrays(Context mContext) {
        this.mContext = mContext;
    }

    private ArrayList<Drawable> imagesDefault = new ArrayList<>();
    private ArrayList<Drawable> imagesColor = new ArrayList<>();
    private ArrayList<String> textQuestions = new ArrayList<>();
    private ArrayList<String> textReactions = new ArrayList<>();

    public void addArrayList() {

        imagesDefault.add(mContext.getDrawable(R.drawable.ruiminativo));
        imagesDefault.add(mContext.getDrawable(R.drawable.naogosteiinativo));
        imagesDefault.add(mContext.getDrawable(R.drawable.seilainativo));
        imagesDefault.add(mContext.getDrawable(R.drawable.gosteiinativo));
        imagesDefault.add(mContext.getDrawable(R.drawable.adoreiinativo));

        imagesColor.add(mContext.getDrawable(R.drawable.ruimativo));
        imagesColor.add(mContext.getDrawable(R.drawable.naogosteiativo));
        imagesColor.add(mContext.getDrawable(R.drawable.seilaativo));
        imagesColor.add(mContext.getDrawable(R.drawable.gosteiativo));
        imagesColor.add(mContext.getDrawable(R.drawable.adoreiativo));

        textQuestions.add(mContext.getString(R.string.question_ruim));
        textQuestions.add(mContext.getString(R.string.question_n_gostou));
        textQuestions.add(mContext.getString(R.string.question_achou));
        textQuestions.add(mContext.getString(R.string.question_gostou));
        textQuestions.add(mContext.getString(R.string.question_adorou));

        textReactions.add(mContext.getString(R.string.ruim));
        textReactions.add(mContext.getString(R.string.n_gostei));
        textReactions.add(mContext.getString(R.string.sei_l));
        textReactions.add(mContext.getString(R.string.gostei));
        textReactions.add(mContext.getString(R.string.adorei));
    }

    public ArrayList<Drawable> getImagesDefault() {
        return imagesDefault;
    }

    public ArrayList<Drawable> getImagesColor() {
        return imagesColor;
    }

    public ArrayList<String> getTextQuestions() {
        return textQuestions;
    }

    public ArrayList<String> getTextReactions() {
        return textReactions;
    }
}
