package bersatu.kita.part11.Api

import bersatu.kita.part11.Model.Pelajaran
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {
    private val BASE_URL = "https://solusibelajar-51291.firebaseio.com/"
    private val api: PhotosApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    fun getPhotos(): Single<List<Pelajaran>> {
        return api.getPhotos()
    }
}
