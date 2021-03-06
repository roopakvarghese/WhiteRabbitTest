package com.roopak.whiterabbittest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.roopak.whiterabbittest.BR
import com.roopak.whiterabbittest.R
import com.roopak.whiterabbittest.databinding.RvListProfileBinding
import com.roopak.whiterabbittest.models.RvCompanyProfile

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ViewHolder>()  {
    private var profileViewModels:List<RvCompanyProfile> = mutableListOf<RvCompanyProfile>()

    fun setProfileData(shopsViewModel: List<RvCompanyProfile>? ){
        shopsViewModel?.let{
            this.profileViewModels = it
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<RvListProfileBinding>(
            LayoutInflater.from(parent.context), R.layout.rv_list_profile, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val shop = profileViewModels[position]
        holder.bind(shop)

    }

    override fun getItemCount(): Int {
        return profileViewModels.size
    }

    inner class ViewHolder(private val binding: RvListProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(profile : RvCompanyProfile){
            binding.setVariable(BR.profile, profile)
            binding.executePendingBindings()
        }

    }

}