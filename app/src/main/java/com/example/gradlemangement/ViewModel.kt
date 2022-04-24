package com.example.gradlemangement

import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "ViewModel"
class MainViewModel : ViewModel(){
    var repository: repository = repository(Retrofit.apiService)
    var _getValue : MutableLiveData<UserResponse> = MutableLiveData<UserResponse>()
    val getValue : LiveData<UserResponse>
    get() {
      return _getValue
    }


    fun login(a : User){
         viewModelScope.launch {
             try {
                 var res = repository.login(a)
                 if(res.isSuccessful) {
                     _getValue.value = res.body()
                     Log.d(TAG,res.body()!!.token)
                 }

             }catch (e : Exception){
                 Log.d(TAG,e.message!!)
             }
         }
    }


}