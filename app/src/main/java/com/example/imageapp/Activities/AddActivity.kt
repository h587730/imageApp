package com.example.imageapp.Activities

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.imageapp.Model.Person
import com.example.imageapp.R

private const val TAG1 = "openGalleryForImage"
private const val TAG2 = "btnSubmit.setOnClickListener"
private const val TAG3 = "converToBitmap"

class AddActivity : AppCompatActivity() {

    private lateinit var btnSubmit: Button
    private lateinit var btnSelectImage: Button
    private lateinit var ivPreviewImage: ImageView

    private lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSelectImage = findViewById(R.id.btnSelectImage)
        ivPreviewImage = findViewById(R.id.IvPreviewImage)
        etName = findViewById(R.id.etName)



        btnSelectImage.setOnClickListener{
            openGalleryForImage()
            Log.i(TAG1, "Gallery Opened")
        }


        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val img = convertToBitmap(ivPreviewImage)
            val newPerson = Person(name, img)
            val output = Intent()
            output.putExtra("person", newPerson)
            setResult(Activity.RESULT_OK, output)
            finish()
            Log.i(TAG, "person sent")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 32) {
            ivPreviewImage.setImageURI(data?.data)
        }
    }

        private fun convertToBitmap(imageView: ImageView): Bitmap {
            imageView.buildDrawingCache()
            val bm = imageView.getDrawingCache()
            Log.i(TAG3, "image converted")
            return bm
        }

        private fun openGalleryForImage() {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 32)
        }

}
