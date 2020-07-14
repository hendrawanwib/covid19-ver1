package id.haweje.covid19v1.ui.statistic.adapter.recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

import id.haweje.covid19v1.R;
import id.haweje.covid19v1.model.negara.AttributesNegara;
import id.haweje.covid19v1.model.negara.NegaraModel;

public class ListNationAdapter extends RecyclerView.Adapter<ListNationAdapter.ViewHolder> implements Filterable {

    private ArrayList<AttributesNegara> nationsModels = new ArrayList<>();

    public void setNationsModels(ArrayList<AttributesNegara> items){
        nationsModels.clear();
        nationsModels.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.search_item_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(nationsModels.get(position).getNegaraModel());
    }

    @Override
    public int getItemCount() {
        return nationsModels.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    final Filter filter = new Filter() {

        //run on Background Thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<AttributesNegara> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(nationsModels);
            } else {
                for (AttributesNegara attributesNegara : nationsModels) {
                    if (attributesNegara.toString().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(attributesNegara);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            nationsModels.clear();
            nationsModels.addAll((Collection<? extends AttributesNegara>) results.values);
            notifyDataSetChanged();
        }
    };


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdNegara;
        TextView tvConfirmed;
        TextView tvRecoverd;
        TextView tvDeaths;
        TextView tvListNegara;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdNegara = itemView.findViewById(R.id.tvid_prov_county);
            tvConfirmed = itemView.findViewById(R.id.tv_confirmed_holder);
            tvRecoverd = itemView.findViewById(R.id.tv_recovered_holder);
            tvDeaths = itemView.findViewById(R.id.tv_deaths_holder);
            tvListNegara = itemView.findViewById(R.id.tvlist_provinsi_country);
        }

        void bind(NegaraModel negaraModel){
            tvIdNegara.setText(negaraModel.getObjectId());
            tvConfirmed.setText(negaraModel.getConfirmed());
            tvDeaths.setText(negaraModel.getDeaths());
            tvRecoverd.setText(negaraModel.getRecovered());
            tvListNegara.setText(negaraModel.getCountryRegion());
        }
    }
}
