package com.chad.foodrecipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chad.foodrecipeapp.database.RecipeDatabase
import com.chad.foodrecipeapp.model.Category
import com.chad.foodrecipeapp.retrofit.ApiInterface
import com.chad.foodrecipeapp.retrofit.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

class SplashActivity :BaseActivity(), EasyPermissions.RationaleCallbacks, EasyPermissions.PermissionCallbacks {

    private var READ_STORAGE_PERMISSION = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        readStorageTask()
        initialize()
    }

    private fun initialize() {

        buttonGetStarted.setOnClickListener {
            var intent: Intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        lottieAnimation.imageAssetsFolder = "images"
        lottieAnimation.setAnimation("cooking.json")
    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance.create(ApiInterface::class.java)
        val call = service.getCategoryList()
        call.enqueue(object: Callback<Category> {
            override fun onResponse(call: Call<Category>, response: Response<Category>) {
                insertDataIntoDatabase(response.body())
            }

            override fun onFailure(call: Call<Category>, t: Throwable) {
                Toast.makeText(this@SplashActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun insertDataIntoDatabase(category: Category?) {

        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearDatabase()
                for(arr in category!!.categoryItems!!) {
                    RecipeDatabase.getDatabase(this@SplashActivity)
                            .recipeDao().insertCategory(arr)
                }
            }
        }
    }

    private fun hasReadStoragePermission() : Boolean {
        return EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private fun readStorageTask() {
        if (!hasReadStoragePermission()) {
            EasyPermissions.requestPermissions(this,
                    "This app needs to access your storage", READ_STORAGE_PERMISSION,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)
        } else {
            getCategories()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
       if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
           AppSettingsDialog.Builder(this).build().show()
       }
    }
}