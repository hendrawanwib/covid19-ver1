package id.haweje.covid19v1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import id.haweje.covid19v1.api.ApiEndPoint;
import id.haweje.covid19v1.api.ApiService;
import id.haweje.covid19v1.model.negara.AttributesNegara;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NegaraViewModel extends ViewModel {
    private MutableLiveData<ArrayList<AttributesNegara>> mutableLiveData = new MutableLiveData<>();

    public void setNationData(){
        Retrofit retrofit = ApiService.getKawalCovid();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<List<AttributesNegara>> call = apiEndPoint.getNegaraList();
        call.enqueue(new Callback<List<AttributesNegara>>() {
            @Override
            public void onResponse(Call<List<AttributesNegara>> call, Response<List<AttributesNegara>> response) {
                mutableLiveData.setValue((ArrayList<AttributesNegara>) response.body());
            }

            @Override
            public void onFailure(Call<List<AttributesNegara>> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<AttributesNegara>> getNationListData(){
        return mutableLiveData;
    }
}
