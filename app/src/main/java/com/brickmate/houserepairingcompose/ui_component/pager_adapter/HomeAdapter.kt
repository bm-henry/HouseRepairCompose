package com.brickmate.houserepairingcompose.ui_component.pager_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.brickmate.houserepairingcompose.fragment.order.OfferFragment


class HomeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return OfferFragment.createInstance()
            }
//            1 -> {
//                return ShoppingFragment.createInstance()
//            }
//            2 -> {
//                return EducationMaterialFragment()
//            }
//            3 -> {
//                return CategoryServiceFragment.createInstance()
//            }
//            4 -> {
//                return ProcessFragment()
//            }

        }
        return Fragment()
    }


}