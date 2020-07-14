package id.haweje.covid19v1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.haweje.covid19v1.api.ApiEndPoint;
import id.haweje.covid19v1.api.ApiService;
import id.haweje.covid19v1.model.Indonesia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaViewModel extends ViewModel {

    private MutableLiveData<Indonesia> mutableLiveData = new MutableLiveData<>();

    public void setIndonesiaData(){
        Retrofit retrofit = ApiService.getCoronaMathdro();
        ApiEndPoint apiEndPoint =retrofit.create(ApiEndPoint.class);
        Call<Indonesia> call = apiEndPoint.getIndonesiaData();
        call.enqueue(new Callback<Indonesia>() {
            @Override
            public void onResponse(Call<Indonesia> call, Response<Indonesia> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Indonesia> call, Throwable t) {

            }
        });
    }

public LiveData<Indonesia> getIndonesiaData(){
        return mutableLiveData;
}
}
