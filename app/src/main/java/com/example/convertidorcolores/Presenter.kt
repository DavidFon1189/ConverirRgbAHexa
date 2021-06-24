package com.example.convertidorcolores

import com.example.convertidorcolores.retrofit.RetrofitClietn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter constructor(view: Contract.View, retrofitClietn: RetrofitClietn): BasePresenter(), Contract.Presenter {
    var view: Contract.View? = null
    var retrofitClietn: RetrofitClietn? = null

    init {
        this.view = view
        this.retrofitClietn = retrofitClietn
    }

    override fun getInfo() {
        RetrofitClietn.provideAPIService()?.getInfo()?.enqueue(object :
            Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                view?.failGetAddressesServer("ERROR")

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    view?.response(response)
                } else {
                    view?.failGetAddressesServer("ERROR")
                }
            }
        })
    }


}