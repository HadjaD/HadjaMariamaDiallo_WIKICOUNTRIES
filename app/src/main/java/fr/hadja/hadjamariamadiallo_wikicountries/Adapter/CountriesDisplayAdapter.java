package fr.hadja.hadjamariamadiallo_wikicountries.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Activity.CountryItemActivity;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.PicassoTrustAll;
import fr.hadja.hadjamariamadiallo_wikicountries.R;

public class CountriesDisplayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Country> countryList;
    private Context context;
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
            final Country country = countryList.get(position);
            dataHolder.cName.setText(country.getName());
            PicassoTrustAll.getInstance(dataHolder.card.getContext()).load(country.getFlag())
                    .placeholder(R.mipmap.ic_launcher_round).resize(100,100)
                    .into(dataHolder.card);

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
    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView cName;
        ImageView card;
        View layout;
        public DataHolder(View itemView){
            super(itemView);
            layout = itemView;
            cName = itemView.findViewById(R.id.cName);
            card = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }
        public void onClick(View v){
            Toast.makeText(v.getContext(), cName.getText(), Toast.LENGTH_SHORT).show();
            Intent activity = new Intent(v.getContext(), CountryItemActivity.class);
            activity.putExtra("country", cName.getText());
            v.getContext().startActivity(activity);
        }
    }
}
