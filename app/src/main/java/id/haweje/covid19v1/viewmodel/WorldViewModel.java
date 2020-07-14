package id.haweje.covid19v1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.haweje.covid19v1.api.ApiEndPoint;
import id.haweje.covid19v1.api.ApiService;
import id.haweje.covid19v1.model.World;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WorldViewModel extends ViewModel {

    private MutableLiveData<World> mutableLiveData = new MutableLiveData<>();

    public void setSummaryWorld(){
        Retrofit retrofit = ApiService.getCoronaMathdro();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<World> call = apiEndPoint.getWorldwideData();
        call.enqueue(new Callback<World>() {
            @Override
            public void onResponse(Call<World> call, Response<World> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<World> call, Throwable t) {

            }
        });
    }

    public LiveData<World> getSummaryWorld(){
        return mutableLiveData;
    }
}
