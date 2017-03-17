package co.com.ednerdaza.coffeeshopapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;

/**
 * Created by edner.daza on 17/03/2017.
 */

public class CoffeeMenuView extends RecyclerView {

    private final String[] myDataset = {"uno", "dos", "tres"};
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CoffeeMenuView(Context context) {
        super(context);
    }

    public CoffeeMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(context);
        this.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new CoffeeMenuListAdapter(myDataset);
        this.setAdapter(mAdapter);
    }

    public CoffeeMenuView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void add (String item){
        //myDataset.
    }

}
