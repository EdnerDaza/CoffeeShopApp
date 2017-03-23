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
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMenuView extends RecyclerView {

  private CoffeeMenuListAdapter mAdapter;

  public CoffeeMenuView(Context context) {
    this(context, null);
  }

  public CoffeeMenuView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    this.setHasFixedSize(true);
    // use a linear layout manager
    LayoutManager mLayoutManager = new LinearLayoutManager(context);
    this.setLayoutManager(mLayoutManager);
    // specify an adapter (see also next example)
    mAdapter = new CoffeeMenuListAdapter();
    this.setAdapter(mAdapter);
  }

  public void show(List<Coffee> coffeeList) {
    mAdapter.show(coffeeList);
  }

  static class CoffeeMenuListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Coffee> coffeeList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      // create a new view
      View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_menu_view, parent, false);
      // set the view's size, margins, paddings and layout parameters
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      holder.coffee(coffeeList.get(position));
    }

    @Override
    public int getItemCount() {
      return coffeeList.size();
    }

    public void show(List<Coffee> coffeeList) {
      this.coffeeList.addAll(coffeeList);
      notifyDataSetChanged();
    }
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.coffee_menu_view_name)
    TextView nameView;
    @BindView(R.id.coffee_menu_view_price)
    TextView priceView;
    @BindView(R.id.coffee_menu_view_image)
    TextView imageView;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void coffee(Coffee coffee) {
      nameView.setText(coffee.getName());
      priceView.setText(coffee.getPrice());
      imageView.setText(coffee.getImage());
    }
  }
}
