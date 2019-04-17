package likert.app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import likert.app.Callback.OnClickRecycler;
import likert.app.MainRecycler.MainAdapter;
import likert.app.MainRecycler.MainModel;
import likert.app.Util.AddArrays;
import likert.app.Util.TitleColor;

import static likert.app.Util.Constant.MAX;

public class MainRecycle extends AppCompatActivity implements OnClickRecycler, View.OnClickListener {

    RecyclerView mRecyclerView;
    private List<MainModel> mainItemsList;
    private ArrayList<Drawable> imagesDefault = new ArrayList<>();
    private ArrayList<Drawable> imagesColor = new ArrayList<>();
    private ArrayList<String> textReactions = new ArrayList<>();
    private ArrayList<String> textQuestions = new ArrayList<>();
    private AppCompatEditText editText;
    private TextView counterText;
    private TextView question;
    private ConstraintLayout layout, layoutResult;
    private Switch switchResult;
    private TextView send;
    private TextView title;
    private TextView textInfo;
    private TextView refresh;
    private AddArrays addArrays;
    private TitleColor titleColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);
        getSupportActionBar().setSubtitle(getString(R.string.recycler_toolbar));

        init();
        registerClick();

        mRecyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        addArrays = new AddArrays(this);
        addArrays.addArrayList();
        addArrayList();

        initializeData();
        MainAdapter mAdapter = new MainAdapter(mainItemsList, this);
        mRecyclerView.setAdapter(mAdapter);
        titleColor = new TitleColor(this);

        final int max = 140;
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count <= max) {
                    counterText.setText((max - s.toString().length()) + " caracteres");
                } else {
                    counterText.setText("0 caracteres");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initializeData() {
        mainItemsList = new ArrayList<>();
        for (int i = 0; i < imagesColor.size(); i++) {
            mainItemsList.add(new MainModel(imagesColor.get(i), imagesDefault.get(i), textReactions.get(i)));
        }

    }

    private void registerClick() {
        send.setOnClickListener(this);
    }

    public void addArrayList() {

        for (int i = 0; i < MAX; i++) {
            imagesDefault.add(addArrays.getImagesDefault().get(i));
            imagesColor.add(addArrays.getImagesColor().get(i));
            textReactions.add(addArrays.getTextReactions().get(i));
            textQuestions.add(addArrays.getTextQuestions().get(i));
        }
    }


    @Override
    public void onClick(int position) {
        question.setText(textQuestions.get(position));
        layout.setVisibility(View.VISIBLE);
    }


    public void init() {

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                mRecyclerView.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
                if (!switchResult.isChecked()) {

                    title.setText(titleColor.getTitle());
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
        }
    }
}
