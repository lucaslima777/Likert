package likert.app.MainRecycler;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import likert.app.Callback.OnClickRecycler;
import likert.app.R;
import likert.app.Util.RecyclerClick;

import static likert.app.Util.Constant.MAX;

public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    private List<MainModel> mainAdapterList;
    private Context mContext;
    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private ArrayList<Drawable> imagesDefault = new ArrayList<>();
    private ArrayList<Drawable> imagesColor = new ArrayList<>();

    private ArrayList<TextView> textViews = new ArrayList<>();
    private ArrayList<String> textQuestions = new ArrayList<>();


    public MainAdapter(List<MainModel> list, Context context) {
        this.mainAdapterList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_main, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, final int i) {

        mainHolder.imageView.setImageDrawable(mainAdapterList.get(i).getIdImageColor());
        mainHolder.description.setText(mainAdapterList.get(i).getTxtDescription());

        imageViews.add(mainHolder.imageView);
        textViews.add(mainHolder.description);
        imagesColor.add(mainAdapterList.get(i).getIdImageColor());
        imagesDefault.add(mainAdapterList.get(i).getIdImageDefalt());
        textQuestions.add(mainAdapterList.get(i).getTxtDescription());

        mainHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultReactions(i, imageViews, imagesColor, imagesDefault, textViews, textQuestions);

                RecyclerClick recyclerClick = new RecyclerClick((OnClickRecycler) mContext);
                recyclerClick.setPosition(i);
            }
        });

    }

    private void defaultReactions(int position, ArrayList<ImageView> imageViews, ArrayList<Drawable> ImageColor, ArrayList<Drawable> ImageDefault, ArrayList<TextView> textViews, ArrayList<String> descriptions) {
        for (int i = 0; i < MAX; i++) {
            if (i == position) {
                imageViews.get(i).setImageDrawable(ImageColor.get(i));
                textViews.get(i).setTypeface(null, Typeface.BOLD);
            } else {
                imageViews.get(i).setImageDrawable(ImageDefault.get(i));
                textViews.get(i).setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mainAdapterList.size();
    }
}
