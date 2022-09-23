package com.geektech.lesson42.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lesson42.OnBoard
import com.geektech.lesson42.databinding.ItemOnBoardingPageBinding
import com.geektech.lesson42.loadImage

class OnBoardAdapter(private val onClick:()->Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val arrayListBoarding = arrayListOf<OnBoard>()

    init {
        arrayListBoarding.add(
            OnBoard(
                " https://cdn.shopify.com/s/files/1/1848/3979/products/HeroMommy1W_530x@2x.JPG?v=1523671101 ",
                "Сублимационная печать",
                "Это самый простой способ нанесения полноцветных изображений непосредственно на синтетические" +
                        " белые или светлые ткани. Краситель проникает внутрь волокон ткани, переходя из" +
                        " твердого состояния в газообразное"
            )
        )
        arrayListBoarding.add(
            OnBoard(
                " https://zaprintom.ru/api_static/get/uploads/attachments/2019/03/29/1553863696236_r65944_c0.tmb.png",
                "Требования к файлам ",
                " \"Масштаб изображения:1:1\",\n" +
                        "                \" Максимальный размер зоны печати: А3\",\n" +
                        "                \" Цветовая модель: CMYK\",\n" +
                        "                \"Разрешение: 300 dpi\",\n" +
                        "                \"Файлы в формате TIFF должны быть сжаты LZW-компрессией\",\n" +
                        "                \"Шрифты – в кривых, эффекты – растрированы, нет скрытых слоев и слоев с прозрачностью\"\n" +
                        "            )",

        )
        )
        arrayListBoarding.add(
            OnBoard(
                "https://i.pinimg.com/originals/00/d0/a0/00d0a04b1a920a0955b9d8ed0a972ba2.png ",
                "Требования к макетам для печати на футболках (сублимация)",
                "Макет в электронном виде предоставляется для печати посредством загрузки на сайт. " +
                        "\"Файл подготавливается по требованиям, описанным ниже, в зависимости\"\n" +
                        "                \" от выбранного способа печати на футболках\"",

            )
        )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardingPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(arrayListBoarding[position])
    }

    override fun getItemCount(): Int = arrayListBoarding.size


    inner class OnBoardViewHolder(private val binding: ItemOnBoardingPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(OnBoard: OnBoard) {
            binding.skip.setOnClickListener { onClick() }
            binding.bntStart.setOnClickListener { onClick() }
            binding.skip.isVisible = adapterPosition != arrayListBoarding.size - 1
            binding.bntStart.isVisible = adapterPosition == arrayListBoarding.size
            binding.tvTitle.text = OnBoard.title
            binding.tvDesc.text = OnBoard.description
            OnBoard.image?.let { binding.imagePager.loadImage(it) }

        }


    }
}



