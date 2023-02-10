package com.byundonghwan.recyclerview_week3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.byundonghwan.recyclerview_week3.databinding.ListItemBinding

class ProfileAdapter(val profileList : ArrayList<Profiles> ) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CustomViewHolder(binding).apply{

            // 리사이클러뷰 아이템 클릭시
            itemView.setOnClickListener {

                // 클릭된 어뎁터의 position -> 현재 위치
                val curPos : Int = adapterPosition
                // 원하는 아이템 객체 형태로 가져옴.
                val profile : Profiles = profileList[curPos]
                Toast.makeText(parent.context, "이름 : ${profile.name} \n 나이 : ${profile.age} \n 직업 : ${profile.job} ", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // onCreateViewHoler로 만들어진 View 데이터를 매치.
        holder.gender.setImageResource(profileList[position].gender)
        holder.name.text = profileList[position].name
        holder.age.text = profileList[position].age.toString()
        holder.job.text = profileList[position].job
    }

    override fun getItemCount(): Int {
       return profileList.size
    }

    class CustomViewHolder(private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val gender = binding.ivProfile// 성별
        val name = binding.tvName // 이름
        val age = binding.tvAge // 나이
        val job = binding.tvJob // 직업

    }


}