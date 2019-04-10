package likert.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView reaction1, reaction2, reaction3, reaction4, reaction5;
    private TextView textReaction1, textReaction2, textReaction3, textReaction4, textReaction5;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addArrayList();
        registerClick();

        final int max = 140;
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (count <= max) {
                    //counterText.setText("" + (max - count) + " caracteres");
                } else {
                    //counterText.setText("0 caracteres");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count <= max) {
                    //counterText.setText("" + (max - count) + " caracteres");
                } else {
                    //counterText.setText("0 caracteres");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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

    }

    private void registerClick() {
        reaction1.setOnClickListener(this);
        reaction2.setOnClickListener(this);
        reaction3.setOnClickListener(this);
        reaction4.setOnClickListener(this);
        reaction5.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reaction1:
                defaultReactions(0);
                break;
            case R.id.reaction2:
                defaultReactions(1);
                break;
            case R.id.reaction3:
                defaultReactions(2);
                break;
            case R.id.reaction4:
                defaultReactions(3);
                break;
            case R.id.reaction5:
                defaultReactions(4);
                break;
            case R.id.send:
                tableLayout.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
                if (!switchResult.isChecked()) {
                    title.setText("obrigado por dedicar\no seu tempo ;)");
                    layoutResult.setVisibility(View.VISIBLE);
                    layoutResult.setBackgroundColor(getResources().getColor(R.color.branco));
                    textInfo.setText("vamos analisar o seu comentário\npara deixar o app Itaú ainda\nmelhor para você.");
                    refresh.setVisibility(View.GONE);
                } else {
                    title.setText("desculpe, não foi\npossível enviar sua\navaliação :(");
                    layoutResult.setVisibility(View.VISIBLE);
                    layoutResult.setBackgroundColor(getResources().getColor(R.color.cinza));
                    textInfo.setText("verifique sua conexão de\ninternet e tente novamente");
                    refresh.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private void defaultReactions(int position) {
        for (int i = 0; i <= 4; i++) {
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
        imageViews.add(reaction1);
        imageViews.add(reaction2);
        imageViews.add(reaction3);
        imageViews.add(reaction4);
        imageViews.add(reaction5);

        textViews.add(textReaction1);
        textViews.add(textReaction2);
        textViews.add(textReaction3);
        textViews.add(textReaction4);
        textViews.add(textReaction5);

        imagesDefault.add(getResources().getDrawable(R.drawable.ruiminativo));
        imagesDefault.add(getResources().getDrawable(R.drawable.naogosteiinativo));
        imagesDefault.add(getResources().getDrawable(R.drawable.seilainativo));
        imagesDefault.add(getResources().getDrawable(R.drawable.gosteiinativo));
        imagesDefault.add(getResources().getDrawable(R.drawable.adoreiinativo));

        imagesColor.add(getResources().getDrawable(R.drawable.ruimativo));
        imagesColor.add(getResources().getDrawable(R.drawable.naogosteiativo));
        imagesColor.add(getResources().getDrawable(R.drawable.seilaativo));
        imagesColor.add(getResources().getDrawable(R.drawable.gosteiativo));
        imagesColor.add(getResources().getDrawable(R.drawable.adoreiativo));

        textQuestions.add("o que foi ruim?");
        textQuestions.add("o que você não gostou?");
        textQuestions.add("o que você achou?");
        textQuestions.add("o que você gostou?");
        textQuestions.add("o que você adorou?");
    }


    public void sizeImage(int i) {
        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());

        imageViews.get(i).getLayoutParams().height = dimensionInDp;
        imageViews.get(i).getLayoutParams().width = dimensionInDp;
        imageViews.get(i).requestLayout();
    }
}
