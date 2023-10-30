package com

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amel.muslimmediaapp.model.network.ApiClient
import com.amel.muslimmediaapp.model.network.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel: ViewModel() {
    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>

    private var _aboutAlQuranNews = MutableLiveData<NewsResponse>()
    val aboutAlQuranNews get() = _aboutAlQuranNews as LiveData<NewsResponse>

    private var _alJazeeraNews = MutableLiveData<NewsResponse>()
    val alJazeeraNews get() = _alJazeeraNews as LiveData<NewsResponse>

    private var _warningForMuslimNews = MutableLiveData<NewsResponse>()
    val warningForMuslimNews get() = _warningForMuslimNews as LiveData<NewsResponse>

    private var _searchNews= MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    fun commonMuslimNews() {
        ApiClient.provideApiService().getCommonMuslimNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if(response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: Call success with HTTP status code ${response.body()}"
                        )
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure" + t.localizedMessage
                    )
                }
            })
    }

    fun aboutAlQuranNews() {
        ApiClient.provideApiService().getAlQuranNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: Call success with HTTP status code ${response.body()}"
                        )
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure" + t.localizedMessage
                    )
                }
            })
    }

    fun alJazeeraNews() {
        ApiClient.provideApiService().getAljazeeraNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: ${response.body()}"
                        )
                        _alJazeeraNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })


    }

    fun warningForMuslimNews() {
        ApiClient.provideApiService().getWarningForMuslimNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: ${response.body()}"
                        )
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun searchNews(q: String) {
        ApiClient.provideApiService().getSearchNews(q)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i(
                            "ViewModel",
                            "onResponse: ${response.body()}"
                        )
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }
}