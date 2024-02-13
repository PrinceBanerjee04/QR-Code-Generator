package com.example.qrcodegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val button = findViewById<Button>(R.id.btn_generate)
        val imageView = findViewById<ImageView>(R.id.QR_Code)

        button.setOnClickListener {
            val multiFormatWriter = MultiFormatWriter()

            try {
                val bitMatrix = multiFormatWriter.encode(
                    editText.text.toString(),
                    BarcodeFormat.QR_CODE,
                    300,
                    300
                )

                val barcodeEncoder = BarcodeEncoder()
                val bitmap = barcodeEncoder.createBitmap(bitMatrix)

                imageView.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                throw RuntimeException(e)
            }
        }
    }
}