package co.com.ednerdaza.coffeeshopapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by edner.daza on 17/03/2017.
 */

public class CoffeeMenuView extends RecyclerView {
    private final String[] myDataset = {"uno", "dos", "tres"};
    private List<Coffees> coffeeListMain = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public CoffeeMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //add();
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        this.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(context);
        this.setLayoutManager(mLayoutManager);

        additing();

        // specify an adapter (see also next example)
        mAdapter = new CoffeeMenuListAdapter(coffeeListMain);
        this.setAdapter(mAdapter);
    }

    private void additing() {
        Coffees coffee = new Coffees("Mad Max: Fury Road", "Action & Adventure", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Mad Max: Fury Road", "Action & Adventure", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Inside Out", "Animation, Kids & Family", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Shaun the Sheep", "Animation", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("The Martian", "Science Fiction & Fantasy", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Mission: Impossible Rogue Nation", "Action", "2015");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Up", "Animation", "2009");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Star Trek", "Science Fiction", "2009");
        coffeeListMain.add(coffee);

        coffee = new Coffees("The LEGO Coffees", "Animation", "2014");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Iron Man", "Action & Adventure", "2008");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Aliens", "Science Fiction", "1986");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Chicken Run", "Animation", "2000");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Back to the Future", "Science Fiction", "1985");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Raiders of the Lost Ark", "Action & Adventure", "1981");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Goldfinger", "Action & Adventure", "1965");
        coffeeListMain.add(coffee);

        coffee = new Coffees("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        coffeeListMain.add(coffee);
    }

    public CoffeeMenuView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private static class CoffeeMenuListAdapter extends RecyclerView.Adapter<ViewHolder>{
        private List<Coffees> coffeesList;

        public CoffeeMenuListAdapter(List<Coffees> coffeesList) {
            this.coffeesList = coffeesList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.coffee_menu_view, parent, false);
            // set the view's size, margins, paddings and layout parameters
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Coffees coffee = coffeesList.get(position);
            holder.nameView.setText(coffee.getName());
            holder.priceView.setText(coffee.getPrice());
            holder.imageView.setText(coffee.getImage());
        }

        @Override
        public int getItemCount() {
            return coffeesList.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        //@BindView(R.id.coffee_menu_view_name) TextView nameView;
        //@BindView(R.id.coffee_menu_view_price) TextView priceView;
        //@BindView(R.id.coffee_menu_view_image) TextView imageView;
        public TextView nameView, priceView, imageView;
        ViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(itemView);
            nameView = (TextView) itemView.findViewById(R.id.coffee_menu_view_name);
            priceView = (TextView) itemView.findViewById(R.id.coffee_menu_view_price);
            imageView = (TextView) itemView.findViewById(R.id.coffee_menu_view_image);
        }
    }
}
