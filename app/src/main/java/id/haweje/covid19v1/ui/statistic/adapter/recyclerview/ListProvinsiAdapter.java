package id.haweje.covid19v1.ui.statistic.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.model.provinsi.Attributes;
import id.haweje.covid19v1.model.provinsi.ProvinsiModel;

public class ListProvinsiAdapter extends RecyclerView.Adapter<ListProvinsiAdapter.ViewHolder> {

    private ArrayList<Attributes> provinsiModels = new ArrayList<>();
    public void setProvinsiModels(ArrayList<Attributes> items) {
        provinsiModels.clear();
        provinsiModels.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate
                (R.layout.search_item_holder, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(provinsiModels.get(position).getProvinsiModel());
    }

    @Override
    public int getItemCount() {
        return provinsiModels.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvKodeProvinsi;
        TextView tvConfirmed;
        TextView tvRecovered;
        TextView tvDeath;
        TextView tvListProvinsi;

        ViewHolder(View itemView) {
            super(itemView);
            tvKodeProvinsi = itemView.findViewById(R.id.tvid_prov_county);
            tvConfirmed = itemView.findViewById(R.id.tv_confirmed_holder);
            tvRecovered = itemView.findViewById(R.id.tv_recovered_holder);
            tvDeath = itemView.findViewById(R.id.tv_deaths_holder);
            tvListProvinsi = itemView.findViewById(R.id.tvlist_provinsi_country);
        }

        void bind(ProvinsiModel provinsiModel){
            tvKodeProvinsi.setText(provinsiModel.getKode_provi());
            tvListProvinsi.setText(provinsiModel.getProvinsi());
            tvRecovered.setText(provinsiModel.getKasus_semb());
            tvConfirmed.setText(provinsiModel.getKasus_posi());
            tvDeath.setText(provinsiModel.getKasus_meni());
        }
    }


}
