package likert.app.MainRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import likert.app.R;

public class MainHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView description;

    public MainHolder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        description = (TextView) itemView.findViewById(R.id.text);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getDescription() {
        return description;
    }
}
