package org.o7planning.idillikatest.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.o7planning.idillikatest.R;
import org.o7planning.idillikatest.model.Constructor;

import java.util.ArrayList;


public class ConstructorListAdapter extends RecyclerView.Adapter<ConstructorListAdapter.MyViewHolder> {
    private ArrayList<Constructor> constructorList;
    private Context context;

    SharedPreferences sPref;

    public ConstructorListAdapter(ArrayList<Constructor> constructorList, Context context) {
        this.constructorList = constructorList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        if (sPref == null) {
            sPref = parent.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        }
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(constructorList.get(position));
    }

    @Override
    public int getItemCount() {
        return constructorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        Constructor currentModel;

        TextView title;
        ImageView image;
        TextView description;
        TextView price;
        boolean flag = true;

        ImageView like;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.txtDescription);
            title = itemView.findViewById(R.id.txtTitle);
            price = itemView.findViewById(R.id.textPrice);
            image = itemView.findViewById(R.id.imageCatalog);

            like = itemView.findViewById(R.id.like);

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (sPref.getBoolean(currentModel.getSectionId(), false)) {
                        like.setImageResource(R.drawable.boldlove);
                        saveData(currentModel.getSectionId(), false);
                    } else {
                        like.setImageResource(R.drawable.love);
                        saveData(currentModel.getSectionId(), true);
                    }
                    notifyItemRangeChanged(0, constructorList.size(), false);
                }
            });
        }

        public void bind(Constructor model) {
            currentModel = model;

            description.setText(model.getSectionDesc());
            title.setText(model.getSectionTitle());
            price.setText(model.getPrice());
            Picasso.get()
                    .load(model.getSectionImage())
                    .into(image);

            if (sPref.getBoolean(currentModel.getSectionId(), false)) {
                like.setImageResource(R.drawable.boldlove);
            } else {
                like.setImageResource(R.drawable.love);
            }
        }

        public void saveData(String id, boolean flag) {
            SharedPreferences.Editor ed = sPref.edit();
            ed.putBoolean(id, flag);
            ed.apply();
        }
    }
}
