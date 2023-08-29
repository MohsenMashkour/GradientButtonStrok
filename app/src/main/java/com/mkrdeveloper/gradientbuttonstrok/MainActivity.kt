package com.mkrdeveloper.gradientbuttonstrok

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mkrdeveloper.gradientbuttonstrok.models.Data
import com.mkrdeveloper.gradientbuttonstrok.models.MoviesList
import com.mkrdeveloper.gradientbuttonstrok.ui.theme.GradientButtonStrokTheme
import com.mkrdeveloper.gradientbuttonstrok.utils.RetrofitInstance
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientButtonStrokTheme {
                var moviesList = listOf<Data>()

                GlobalScope.launch(Dispatchers.IO) {
                    val response = try {
                        RetrofitInstance.api.getMoviesData()
                    }catch (e: IOException){
                        Toast.makeText(applicationContext, "app error ${e.message}", Toast.LENGTH_SHORT).show()
                        return@launch

                    }catch (e: HttpException){
                        Toast.makeText(applicationContext, "http error: ${e.message}", Toast.LENGTH_SHORT)
                            .show()
                        return@launch
                    }
                    if (response.isSuccessful && response.body() != null){
                        withContext(Dispatchers.Main){
                             moviesList = response.body()!!.data
                        }
                    }
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Banner screen" ){

                        composable("Banner screen"){
                            BannerScreen(navController)
                        }
                        composable("Home screen"){
                            HomeScreen(moviesList)
                        }
                    }
                }
            }
        }
    }
}

