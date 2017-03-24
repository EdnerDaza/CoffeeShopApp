package co.com.ednerdaza.coffeeshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoffeeMenuActivity extends AppCompatActivity {

    @BindView(R.id.coffee_menu_view) CoffeeMenuView coffeeShopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_menu_activity);
        ButterKnife.bind(this);
        //coffeeShopView.show(coffeeList());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getRetrofitArray();
    }

    private List<Coffee> coffeeList() {
            List<Coffee> coffeeList = new ArrayList<>();
            coffeeList.add(new Coffee("Mad Max: Fury Road", "Action & Adventure", "2015"));
            coffeeList.add(new Coffee("Mad Max: Fury Road", "Action & Adventure", "2015"));
            coffeeList.add(new Coffee("Inside Out", "Animation, Kids & Family", "2015"));
            coffeeList.add(new Coffee("Star Wars: Episode VII - The Force Awakens", "Action", "2015"));
            coffeeList.add(new Coffee("Shaun the Sheep", "Animation", "2015"));
            coffeeList.add(new Coffee("The Martian", "Science Fiction & Fantasy", "2015"));
            coffeeList.add(new Coffee("Mission: Impossible Rogue Nation", "Action", "2015"));
            coffeeList.add(new Coffee("Up", "Animation", "2009"));
            coffeeList.add(new Coffee("Star Trek", "Science Fiction", "2009"));
            coffeeList.add(new Coffee("The LEGO Coffee", "Animation", "2014"));
            coffeeList.add(new Coffee("Iron Man", "Action & Adventure", "2008"));
            coffeeList.add(new Coffee("Aliens", "Science Fiction", "1986"));
            coffeeList.add(new Coffee("Chicken Run", "Animation", "2000"));
            coffeeList.add(new Coffee("Back to the Future", "Science Fiction", "1985"));
            coffeeList.add(new Coffee("Raiders of the Lost Ark", "Action & Adventure", "1981"));
            coffeeList.add(new Coffee("Goldfinger", "Action & Adventure", "1965"));
            coffeeList.add(new Coffee("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"));
            return coffeeList;
          }

    void getRetrofitArray() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo2304167.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Coffee>> call = service.getCoffeeList();

        call.enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(Call<List<Coffee>> call, Response<List<Coffee>> response) {
                try {
                    List<Coffee> CoffeeData = response.body();
                    coffeeShopView.show(CoffeeData);
                    Log.v("onResponse",CoffeeData.toString());
                }catch (Exception e) {
                    Log.v("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Coffee>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

}
