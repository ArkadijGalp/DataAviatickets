package space.arkady.aviaticketsdao.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.databinding.ActivityMainBinding
import space.arkady.aviaticketsdao.presentation.fragments.FragmentFlightRegistration
import space.arkady.aviaticketsdao.utils.openFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding<ActivityMainBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        openFragment(
            R.id.frameFragment,
            FragmentFlightRegistration.newInstance(),
            FragmentFlightRegistration.TAG
        )
    }
}