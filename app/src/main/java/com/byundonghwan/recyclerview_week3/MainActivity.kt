package com.byundonghwan.recyclerview_week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.byundonghwan.recyclerview_week3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding : ActivityMainBinding? = null

    // 매번 null 체크를 할 필요 없이 필요성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val profileList = arrayListOf(
            Profiles(R.drawable.man, "변동환",27, "안드로이드앱 개발자"),
            Profiles(R.drawable.man, "정채윤",27, "안드로이드앱 개발자"),
            Profiles(R.drawable.man, "이민정",27, "안드로이드앱 개발자"),
            Profiles(R.drawable.man, "황민정",27, "안드로이드앱 개발자"),
            Profiles(R.drawable.man, "김철수",27, "ios 개발자"),
            Profiles(R.drawable.man, "짱구",27, "안드로이드앱 개발자"),
            Profiles(R.drawable.man, "철수",27, "프론트 개발자"),
            Profiles(R.drawable.man, "맹구",27, "백엔드 개발자")
        )


        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)


    }
}