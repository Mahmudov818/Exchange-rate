package uz.mahmudovdev.exchange_rate

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.mahmudovdev.exchange_rate.adapter.RvAdapter
import uz.mahmudovdev.exchange_rate.databinding.ActivityMainBinding
import uz.mahmudovdev.exchange_rate.model.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RvAdapter
    var dataList = ArrayList<Response>()
    val titleList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRv()
        loadData()
        setData()
        binding.calculate.setOnClickListener {
            calculateSum()
        }
    }

    private fun setData() {
        binding.usdToUzs.text = titleList[0]
        binding.eurToUzs.text = titleList[1]
        binding.gbpToUzs.text = titleList[2]
        binding.kztToUzs.text = titleList[3]
        binding.jypToUzs.text = titleList[4]
        binding.rubToUzs.text = titleList[5]
    }

    private fun calculateSum() {
//        Toast.makeText(this, binding.radioGroup.checkedRadioButtonId.toString(), Toast.LENGTH_SHORT).show()
        val radioButton = findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
        when (radioButton.text) {
            titleList[0] -> {
                val value = dataList[23].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: java.lang.Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            titleList[1] -> {
                val value = dataList[7].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

            }
            titleList[2] -> {
                val value = dataList[8].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            titleList[3] -> {
                val value = dataList[13].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            titleList[4] -> {
                val value = dataList[10].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            titleList[5] -> {
                val value = dataList[18].cbPrice?.toDouble()
                val input = binding.inputAmount.text.toString().toDouble()
                try {
                    binding.outputAmount.text = "${value!! * input}"
                } catch (e: Exception) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    private fun loadData() {
        val url = "https://nbu.uz/en/exchange-rates/json/"
        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val json = response.toString()
                refreshData(json)
            },
            { error ->
                print("Error")
            })
        val queue = Volley.newRequestQueue(binding.root.context)
        queue.add(stringRequest)

        titleList.add("USSD to UZS")
        titleList.add("EUR to UZS")
        titleList.add("GBP to UZS")
        titleList.add("KZT to UZS")
        titleList.add("JYP to UZS")
        titleList.add("RUB to UZS")
    }

    private fun refreshData(json: String) {
        val type = object : TypeToken<ArrayList<Response>?>() {}.type
        val exchanges: ArrayList<Response> = Gson().fromJson(json, type)
        dataList = exchanges
        adapter.refreshData(exchanges)
    }

    private fun initRv() {
        adapter = RvAdapter()
        binding.rv.adapter = adapter
    }
}