package com.example.book

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.book.databinding.FragmentCalculateAddBinding
import java.text.SimpleDateFormat
import java.util.*

class Calculate_add_fragment : Fragment() {
    private var _binding : FragmentCalculateAddBinding? = null
    private val binding get() = _binding!!
    private var nowch = ""
    private var date = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculateAddBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (binding.number.text.toString().isNotEmpty() && nowch != ""){
                val action = Calculate_add_fragmentDirections.actionCalculateAddFragmentToHomeFragment(binding.number.text.toString().toInt()*-1,nowch,date)
                Navigation.findNavController(view).navigate(action)
            }
            else{
                Toast.makeText(activity,"請輸入數值且選擇項目",Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonSW.setOnClickListener {
            findNavController().navigate(R.id.action_calculate_add_fragment_to_calculate_negative_Fragment)
        }
        binding.buttonSalary.setOnClickListener {
            binding.textViewch.text = "現在選擇：早餐"
            nowch = "早餐";
        }
        binding.buttonGiveBack.setOnClickListener {
            binding.textViewch.text = "現在選擇：晚餐"
            nowch = "晚餐";
        }
        binding.buttonTrade.setOnClickListener {
            binding.textViewch.text = "現在選擇：飲料"
            nowch = "飲料";
        }
        binding.buttonCollectRent.setOnClickListener {
            binding.textViewch.text = "現在選擇：娛樂"
            nowch = "娛樂";
        }
        binding.buttonBonus.setOnClickListener {
            binding.textViewch.text = "現在選擇：午餐"
            nowch = "午餐";
        }
        binding.buttonDividend.setOnClickListener {
            binding.textViewch.text = "現在選擇：交通"
            nowch = "交通";
        }
        binding.buttonInvest.setOnClickListener {
            binding.textViewch.text = "現在選擇：醫療"
            nowch = "早餐";
        }
        binding.buttonOther.setOnClickListener {
            binding.textViewch.text = "現在選擇：其他"
            nowch = "其他";
        }
        binding.buttonBill.setOnClickListener {
            binding.textViewch.text = "現在選擇：房租"
            nowch = "房租";
        }
        binding.buttonSelectDate.setOnClickListener {
            val datePickerFragment = DatePickerFragment()
            val supportFragmentManger = requireActivity().supportFragmentManager

            supportFragmentManger.setFragmentResultListener(
                "REQUEST_KEY",viewLifecycleOwner
            ){
                    resultKey,bundle ->
                if (resultKey == "REQUEST_KEY"){15
                    date = bundle.getString("SELECTED_DATE").toString()
                    binding.textViewDate.text = "日期: "+ date
                }
            }
            datePickerFragment.show(supportFragmentManger, "DatePickerFragment")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
