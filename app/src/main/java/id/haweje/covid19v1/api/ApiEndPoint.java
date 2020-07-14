package id.haweje.covid19v1.api;

import java.util.List;

import id.haweje.covid19v1.model.Indonesia;
import id.haweje.covid19v1.model.World;
import id.haweje.covid19v1.model.negara.AttributesNegara;
import id.haweje.covid19v1.model.provinsi.Attributes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET(Api.END_POINT_PROVINSI)
    Call<List<Attributes>> getProvinsiList();

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<World> getWorldwideData();

    @GET(Api.END_POINT_IDN)
    Call<Indonesia> getIndonesiaData();

    @GET(Api.BASE_URL_API_INDO)
    Call<List<AttributesNegara>> getNegaraList();
}
