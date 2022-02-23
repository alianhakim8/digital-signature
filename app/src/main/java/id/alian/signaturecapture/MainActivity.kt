package id.alian.signaturecapture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.github.gcacace.signaturepad.views.SignaturePad
import id.alian.signaturecapture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var color = ContextCompat.getColor(applicationContext, R.color.purple_500)
        with(binding) {

            btnPurple.setOnClickListener {
                color = ContextCompat.getColor(applicationContext, R.color.purple_700)
            }

            btnTeal.setOnClickListener {
                color = ContextCompat.getColor(applicationContext, R.color.teal_700)
            }

            signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
                override fun onStartSigning() {
                    signaturePad.setPenColor(color)
                }

                override fun onSigned() {
                }

                override fun onClear() {
                }
            })

            btnSave.setOnClickListener {
                Toast.makeText(applicationContext, "Berhasil disimpan", Toast.LENGTH_SHORT).show()
            }

            btnClear.setOnClickListener {
                signaturePad.clear()
            }
        }
    }
}