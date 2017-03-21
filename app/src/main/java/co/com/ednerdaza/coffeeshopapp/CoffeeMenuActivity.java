package co.com.ednerdaza.coffeeshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeMenuActivity extends AppCompatActivity {

    @BindView(R.id.coffee_menu_view) CoffeeMenuView coffeeShopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_menu_activity);
        ButterKnife.bind(this);
        coffeeShopView = new CoffeeMenuView(this,null);
    }

}
