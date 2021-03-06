package com.example.imageapp.Activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView


import androidx.appcompat.app.AppCompatActivity
import com.example.imageapp.Model.Person
import com.example.imageapp.R
import java.io.ByteArrayOutputStream

private const val TAG1 = "openGalleryForImage"
private const val TAG2 = "setOnClickListener"
private const val TAG3 = "convertToBitmap"
private const val TAG4 = "ImageReturned"
private const val TAG5 = "PersonCreated"
private const val TAG6 = "showIntent"

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

            val stream = ByteArrayOutputStream()
            img.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val bytes = stream.toByteArray()

            Log.i(TAG5, "Person created: $name, $bytes")
            val output = Intent()
            output.putExtra("name", name)
            output.putExtra("imgBytes", bytes)
            Log.i(TAG6, "$output")
            setResult(Activity.RESULT_OK, output)
            Log.i(TAG2, "person sent")
            finish()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 32) {
            ivPreviewImage.setImageURI(data?.data)
            Log.i(TAG4, "Image returned")

        }
    }

       /* private fun convertToBitmap(imageView: ImageView): Bitmap {
            imageView.buildDrawingCache()
            val bm = imageView.getDrawingCache()
            Log.i(TAG3, "image converted")
            return bm
        }*/


    private fun convertToBitmap(imageView: ImageView): Bitmap {
        val bm = (imageView.drawable as BitmapDrawable).bitmap
        Log.i(TAG3, "image converted")
        return bm
    }

        private fun openGalleryForImage() {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 32)
        }

}
