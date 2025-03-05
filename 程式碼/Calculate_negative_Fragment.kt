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
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.book.databinding.FragmentCalculateNegativeBinding
import com.example.book.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*


class Calculate_negative_Fragment : Fragment() {
    private var _binding : FragmentCalculateNegativeBinding? = null
    private val binding get() = _binding!!
    private var nowch = ""
    private var date = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculateNegativeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (binding.number.text.toString().isNotEmpty() && nowch != ""){
                val action = Calculate_negative_FragmentDirections.actionCalculateNegativeFragmentToHomeFragment(binding.number.text.toString().toInt(),nowch,date)
                Navigation.findNavController(view).navigate(action)
            }
            else{
                Toast.makeText(activity,"請輸入數值且選擇項目", Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonSW.setOnClickListener {
            findNavController().navigate(R.id.action_calculate_negative_Fragment_to_calculate_add_fragment)
        }
        binding.buttonBill.setOnClickListener {
            binding.textViewch.text = "現在選擇：發票"
            nowch = "發票";
        }
        binding.buttonBonus.setOnClickListener {
            binding.textViewch.text = "現在選擇：獎金"
            nowch = "獎金";
        }
        binding.buttonDividend.setOnClickListener {
            binding.textViewch.text = "現在選擇：股息"
            nowch = "股息";
        }
        binding.buttonCollectRent.setOnClickListener {
            binding.textViewch.text = "現在選擇：租金"
            nowch = "租金";
        }
        binding.buttonGiveBack.setOnClickListener {
            binding.textViewch.text = "現在選擇：回饋"
            nowch = "回饋";
        }
        binding.buttonInvest.setOnClickListener {
            binding.textViewch.text = "現在選擇：投資"
            nowch = "投資";
        }
        binding.buttonOther.setOnClickListener {
            binding.textViewch.text = "現在選擇：其他"
            nowch = "其他";
        }
        binding.buttonSalary.setOnClickListener {
            binding.textViewch.text = "現在選擇：薪水"
            nowch = "薪水";
        }
        binding.buttonTrade.setOnClickListener {
            binding.textViewch.text = "現在選擇：交易"
            nowch = "交易";
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
