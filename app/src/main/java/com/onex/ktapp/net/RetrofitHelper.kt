import com.onex.ktapp.BuildConfig
import com.onex.ktapp.api.ApiService
import com.onex.ktapp.constant.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 其实是一种单例并且懒加载的一种方法
 */


//class UserManager private constructor(name: String) {
//    companion object {
//        @Volatile private var INSTANCE: UserManager? = null
//
//        fun getInstance(name: String): UserManager =
//            // 第一次判空
//            INSTANCE?: synchronized(this) {
//                // 第二次判空
//                INSTANCE?:UserManager(name).also { INSTANCE = it }
//            }
//    }
//}
//
//// 使用
//UserManager.getInstance("Tom")


object RetrofitHelper {

    private var retrofit: Retrofit? = null

    val service: ApiService by lazy {
        getRetrofit()!!.create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)
        }
        builder.retryOnConnectionFailure(true)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        return builder.build()
    }

}