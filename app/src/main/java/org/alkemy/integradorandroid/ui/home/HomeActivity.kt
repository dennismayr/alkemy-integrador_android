package org.alkemy.integradorandroid.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import org.alkemy.integradorandroid.R
import org.alkemy.integradorandroid.databinding.ActivityHomeBinding
import org.alkemy.integradorandroid.utils.Utils

private var participants: String? = null
//private lateinit var adapter : DogAdapter
private var dogList = mutableListOf<String>()
private val utils = Utils()

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editText.addTextChangedListener { charSequence ->
            participants = if (utils.validateInput(charSequence.toString())) {
                charSequence.toString()
            } else {
                utils.snackBar(binding.root, getString(R.string.home_snack_bar_error))
                null
            }
        }

        binding.termsAndConditions.setOnClickListener {
            val dialogPopUp = TermsAndConditionPopUp()
            dialogPopUp.show(supportFragmentManager, "termsAndConditions")
        }
    }
}