package fr.hadja.hadjamariamadiallo_wikicountries.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Activity.CountryItemActivity;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.R;

public class CountriesDisplayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Country> countryList;

    public CountriesDisplayAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    public Country getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_horlderview, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DataHolder){

            final DataHolder dataHolder = (DataHolder)holder;
            final Country country = countryList.get(dataHolder.getAdapterPosition()
            );
            dataHolder.cName.setText(country.getName());
            Picasso.with(dataHolder.card.getContext()).load(country.getFlag()).into(dataHolder.card);
            dataHolder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(dataHolder.edit.getContext(), CountryItemActivity.class);
                    intent.putExtra("cName",country.getName());

                    dataHolder.edit.getContext().startActivity(intent);
                }
            });

        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.countryList.size();
    }
    public void addItem(int position, Country item) {
        countryList.add(position, item);
        notifyItemInserted(position);
        //notifyItemRangeChanged(position+1, getItemCount());
    }

    public void removeItem(int position) {
        countryList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }
    public class DataHolder extends RecyclerView.ViewHolder{
        Button edit;
        TextView cName;
        ImageView card;
        public DataHolder(View itemView){
            super(itemView);
            edit = itemView.findViewById(R.id.edit);
            cName = itemView.findViewById(R.id.cName);
            card = itemView.findViewById(R.id.card);
        }
    }
}
