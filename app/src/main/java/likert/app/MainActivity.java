package likert.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import likert.app.Util.AddArrays;

import static likert.app.Util.Constant.BAD;
import static likert.app.Util.Constant.LIKE;
import static likert.app.Util.Constant.LOVE;
import static likert.app.Util.Constant.MAX;
import static likert.app.Util.Constant.NOT_KNOW;
import static likert.app.Util.Constant.NOT_LIKE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView reaction1, reaction2, reaction3, reaction4, reaction5;
    private ImageView allImages[];
    private TextView textReaction1, textReaction2, textReaction3, textReaction4, textReaction5;
    private TextView allTexts[];
    private AppCompatEditText editText;
    private TextView counterText;
    private TextView question;
    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private ArrayList<TextView> textViews = new ArrayList<>();
    private ArrayList<Drawable> imagesDefault = new ArrayList<>();
    private ArrayList<Drawable> imagesColor = new ArrayList<>();
    private ArrayList<String> textQuestions = new ArrayList<>();
    private ConstraintLayout layout, layoutResult;
    private Switch switchResult;
    private TextView send;
    private TextView title;
    private TextView textInfo;
    private TextView refresh;
    private TableLayout tableLayout;
    private Button prox;
    private AddArrays addArrays;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setSubtitle(getString(R.string.table_toolbar));

        init();
        registerClick();

        allImages = new ImageView[]{reaction1, reaction2, reaction3, reaction4, reaction5};
        allTexts = new TextView[]{textReaction1, textReaction2, textReaction3, textReaction4, textReaction5};

        addArrays = new AddArrays(this);
        addArrays.addArrayList();
        addArrayList();
    }

    private void registerClick() {
        reaction1.setOnClickListener(this);
        reaction2.setOnClickListener(this);
        reaction3.setOnClickListener(this);
        reaction4.setOnClickListener(this);
        reaction5.setOnClickListener(this);
        send.setOnClickListener(this);
        prox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reaction1:
                defaultReactions(BAD);
                break;
            case R.id.reaction2:
                defaultReactions(NOT_LIKE);
                break;
            case R.id.reaction3:
                defaultReactions(NOT_KNOW);
                break;
            case R.id.reaction4:
                defaultReactions(LIKE);
                break;
            case R.id.reaction5:
                defaultReactions(LOVE);
                break;
            case R.id.send:
                tableLayout.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
                if (!switchResult.isChecked()) {

                    SpannableStringBuilder title_string = new SpannableStringBuilder(getString(R.string.success_text));
                    int color = getResources().getColor(android.R.color.holo_orange_dark);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    title_string.setSpan(fcs, 20, title_string.length(), 0);

                    title.setText(title_string);
                    layoutResult.setVisibility(View.VISIBLE);
                    layoutResult.setBackgroundColor(getResources().getColor(R.color.branco));
                    textInfo.setText(getString(R.string.success_body));
                    refresh.setVisibility(View.GONE);
                } else {
                    title.setText(getString(R.string.error_text));
                    layoutResult.setVisibility(View.VISIBLE);
                    layoutResult.setBackgroundColor(getResources().getColor(R.color.cinza));
                    textInfo.setText(getString(R.string.error_body));
                    refresh.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.prox:
                Intent intent = new Intent(this, MainRecycle.class);
                startActivity(intent);
                break;
        }
    }

    private void defaultReactions(int position) {
        for (int i = 0; i < MAX; i++) {
            if (i == position) {
                imageViews.get(i).setImageDrawable(imagesColor.get(i));
                textViews.get(i).setTypeface(null, Typeface.BOLD);
                question.setText(textQuestions.get(i));
            } else {
                imageViews.get(i).setImageDrawable(imagesDefault.get(i));
                textViews.get(i).setTypeface(null, Typeface.NORMAL);
            }
        }
        layout.setVisibility(View.VISIBLE);
    }

    public void addArrayList() {
        for (int i = 0; i < MAX; i++) {
            imageViews.add(allImages[i]);
            textViews.add(allTexts[i]);
            imagesDefault.add(addArrays.getImagesDefault().get(i));
            imagesColor.add(addArrays.getImagesColor().get(i));
            textQuestions.add(addArrays.getTextQuestions().get(i));
        }
    }


    public void sizeImage(int i) {
        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
        imageViews.get(i).getLayoutParams().height = dimensionInDp;
        imageViews.get(i).getLayoutParams().width = dimensionInDp;
        imageViews.get(i).requestLayout();
    }

    public void init() {
        reaction1 = (ImageView) findViewById(R.id.reaction1);
        reaction2 = (ImageView) findViewById(R.id.reaction2);
        reaction3 = (ImageView) findViewById(R.id.reaction3);
        reaction4 = (ImageView) findViewById(R.id.reaction4);
        reaction5 = (ImageView) findViewById(R.id.reaction5);
        textReaction1 = (TextView) findViewById(R.id.textReaction1);
        textReaction2 = (TextView) findViewById(R.id.textReaction2);
        textReaction3 = (TextView) findViewById(R.id.textReaction3);
        textReaction4 = (TextView) findViewById(R.id.textReaction4);
        textReaction5 = (TextView) findViewById(R.id.textReaction5);
        editText = (AppCompatEditText) findViewById(R.id.edt);
        counterText = (TextView) findViewById(R.id.num_caracteres);
        question = (TextView) findViewById(R.id.question);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        layoutResult = (ConstraintLayout) findViewById(R.id.layoutResult);
        switchResult = (Switch) findViewById(R.id.switch_id);
        send = (TextView) findViewById(R.id.send);
        title = (TextView) findViewById(R.id.title);
        textInfo = (TextView) findViewById(R.id.info);
        refresh = (TextView) findViewById(R.id.refresh);
        tableLayout = (TableLayout) findViewById(R.id.table);
        prox = (Button) findViewById(R.id.prox);
    }
}
