package id.haweje.covid19v1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import id.haweje.covid19v1.api.ApiEndPoint;
import id.haweje.covid19v1.api.ApiService;
import id.haweje.covid19v1.model.provinsi.Attributes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProvinsiViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Attributes>> mutableLiveData = new MutableLiveData<>();

    public void SetProvinsiData(){
        Retrofit retrofit = ApiService.getKawalCovid();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<List<Attributes>> call = apiEndPoint.getProvinsiList();
        call.enqueue(new Callback<List<Attributes>>() {
            @Override
            public void onResponse(Call<List<Attributes>> call, Response<List<Attributes>> response) {
                mutableLiveData.setValue((ArrayList<Attributes>) response.body());
            }

            @Override
            public void onFailure(Call<List<Attributes>> call, Throwable t) {

            }
        });
    }

   public LiveData<ArrayList<Attributes>> getProvinsiData(){
        return mutableLiveData;
   }
}
