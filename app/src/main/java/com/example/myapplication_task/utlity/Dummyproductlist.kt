package com.example.myapplication_task.utlity

import com.example.myapplication_task.R
import com.example.myapplication_task.model.MainModel
import com.example.myapplication_task.model.ListModel


object Dummyproductlist {
    fun getProduct1() :List<MainModel>{
        val sections : ArrayList<MainModel> = ArrayList()
        val product1 : ArrayList<ListModel> = ArrayList()
        product1.add(ListModel(R.drawable.p1,"Product1_1"))
        product1.add(ListModel(R.drawable.p2,"Product1_2"))
        product1.add(ListModel(R.drawable.p3,"Product1_3"))
        product1.add(ListModel(R.drawable.p4,"Product1_4"))
        sections.add(MainModel(0, R.drawable.p1,product1))
        val product2 : ArrayList<ListModel> = ArrayList()
        product2.add(ListModel(R.drawable.p5,"Product2_1"))
        product2.add(ListModel(R.drawable.p6,"Product2_2"))
        product2.add(ListModel(R.drawable.p7,"Product2_3"))
        sections.add(MainModel(1, R.drawable.p5,product2))
        val product3 : ArrayList<ListModel> = ArrayList()
        product3.add(ListModel(R.drawable.p8,"Product3_1"))
        product3.add(ListModel(R.drawable.p9,"Product3_2"))
        sections.add(MainModel(2, R.drawable.p8,product3))
        val product4 : ArrayList<ListModel> = ArrayList()
        product4.add(ListModel(R.drawable.p10,"Product4_1"))
        product4.add(ListModel(R.drawable.p11,"Product4_2"))
        sections.add(MainModel(3, R.drawable.p10,product4))
        return sections

    }

}