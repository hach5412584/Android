package com.example.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book.databinding.FragmentHomeBinding

class homeFragment : Fragment(R.layout.fragment_home) {


    private val args : homeFragmentArgs by navArgs()
    private var type = ""
    private var number = 0
    private var date = ""

    private lateinit var adapter : RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookArrayList: ArrayList<book>

    lateinit var itemTitle :Array<String>
    lateinit var itemDetail :Array<String>
    lateinit var itemNumTitle :Array<String>
    lateinit var itemNumTitle_Number :Array<Int>
    lateinit var itemNumDetail :Array<String>

    private var _binding :FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        binding.bookdata.layoutManager = layoutManager
        binding.bookdata.setHasFixedSize(true)
        adapter = RecyclerAdapter(bookArrayList)
        binding.bookdata.adapter = adapter
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_calculate_add_fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun dataInitialize(){
        type = args.type
        number = args.numberData
        date = args.date
        bookArrayList = arrayListOf<book>()

        itemTitle = arrayOf(
            "2023/01/01",
            "2023/01/02"
        )

        itemDetail = arrayOf(
            "早餐\n"+"晚餐",
            "午餐\n"+"交通"
        )

        itemNumTitle = arrayOf(
            "-250元",
            "-200元"
        )
        itemNumTitle_Number = arrayOf(
            -250,
            -200
        )

        itemNumDetail = arrayOf(
            "-125元\n"+"-125元",
            "-100元\n"+"-100元"
        )
        var create = false
        if (type !="空" && number!=0 && date!="空"){
            for (i in itemTitle.indices){
                if (itemTitle[i] == date){
                    itemDetail[i] += "\n" + type
                    itemNumTitle_Number[i] += number
                    itemNumTitle[i] = itemNumTitle_Number[i].toString()+ "元"
                    itemNumDetail[i] += "\n" + number.toString() + "元"
                    create = true
                }
            }
            if (!create) {
                itemTitle += date
                itemDetail += type
                itemNumTitle += number.toString() + "元"
                itemNumDetail += number.toString() + "元"
                itemNumTitle_Number += number
            }
        }
        for (i in itemTitle.indices){
            val books = book(itemTitle[i],itemDetail[i],itemNumTitle[i],itemNumDetail[i])
            bookArrayList.add(books)
        }
    }
}