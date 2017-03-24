package co.com.ednerdaza.coffeeshopapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by edner.daza on 24/03/2017.
 */

public interface RetrofitArrayAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @GET("getCoffeeList")
    Call<List<Coffee>> getCoffeeList();

}
