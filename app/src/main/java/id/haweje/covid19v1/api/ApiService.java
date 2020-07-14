package id.haweje.covid19v1.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static Retrofit getCoronaMathdro(){
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getKawalCovid(){
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL_API_INDO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
