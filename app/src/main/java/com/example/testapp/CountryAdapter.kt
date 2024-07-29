package com.example.testapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.CountryRowBinding
import java.io.Serializable

class CountryAdapter(val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding : CountryRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val bindings = CountryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(bindings)
    }

    override fun getItemCount(): Int {
       return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.txtCountryRow.text = countryList[position].name
        holder.binding.txtInfo.text = "Detaylı bilgi için tıklayınız"
        holder.binding.imageView.setImageResource(countryList[position].img)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,CountryInfo::class.java)
            intent.putExtra("counrtyInfo",countryList[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}