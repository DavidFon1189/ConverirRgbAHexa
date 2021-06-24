package com.example.convertidorcolores

import retrofit2.Response

interface Contract {
    interface Presenter{
        fun getInfo()
    }

    interface View{
        fun getInfoView()
        fun response(response: Response<String>)
        fun failGetAddressesServer(error: String)
    }
}