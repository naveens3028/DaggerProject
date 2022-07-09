package com.example.dagger2application

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.dagger2application.network.RetrofitInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class FirstFragmentViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService : RetrofitInterface

    init {
        (application as MyApplication).getMainComponentInstance().inject(this)
    }

    fun getDataFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = mService.getUserData()
/*
            if (call.isSuccessful) {
                Log.e("OpCheck", call.body().toString())
            } else {
                Log.e("OpCheck1", call.body().toString())
            }
*/
            call.enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("CheckOp--------->"+t)
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    println("CheckOp--------->"+response.body().toString())
                }
            })
        }
    }

}