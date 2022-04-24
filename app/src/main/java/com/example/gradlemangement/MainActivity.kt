package com.example.gradlemangement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import retrofit2.Callback
import com.example.gradlemangement.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Response


val BASE_URL = BuildConfig.BASE_URL
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.display.text = BASE_URL
        makeNetWorkCall()
        ma()
    }


//
//    private fun makeNetWorkCall(){
//      val a =   User("eve.holt@reqres.in", "cityslicka")
//        binding.display.setOnClickListener {
//            Retrofit.apiService.login(a).enqueue(object : Callback<UserResponse> {
//                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>
//                ) {
//                    val res = response.body()
//                    res?.let {
//                        Log.d(TAG,it.token)
//                    }
//
//                }
//
//                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
//    }

    private fun makeNetWorkCall(){
        val a =   User("eve.holt@reqres.in", "cityslicka")
        binding.display.setOnClickListener {
         viewModel.login(a)
        }
    }

    private fun ma(){
        viewModel.getValue.observe(this,{
            Log.d(TAG,it.token)
        })
    }




}