package masegi.sho.tutorialepoxy.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.airbnb.epoxy.EpoxyVisibilityTracker
import masegi.sho.tutorialepoxy.model.City
import masegi.sho.tutorialepoxy.model.Home
import masegi.sho.tutorialepoxy.R
import masegi.sho.tutorialepoxy.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    // MARK: - Property

    private lateinit var binding: MainFragmentBinding

    private val controller = MainController()
    private lateinit var city: City // mock


    // MARK: - Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setupController()
        setupMock()
        updateController()
        return binding.root
    }


    // MARK: - Private

    private fun setupMock() {
        val homes = mutableListOf<Home>()
        for (i in 1..6) {
            val home =
                Home(getString(R.string.home_name), getString(R.string.home_owner), 0, 0)
            homes.add(home)
        }
        city = City(getString(R.string.city), getString(R.string.description), homes)
    }

    private fun setupController() {
        binding.epoxyView.setController(controller)
        val visibilityTracker = EpoxyVisibilityTracker()
        visibilityTracker.attach(binding.epoxyView)
        controller.delegate = object : MainController.Delegate {
            @SuppressLint("ShowToast")
            override fun onLinkClick(view: View) {
                view.context?.let {
                    Toast.makeText(it, "LinkRow Clicked!!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onHeaderViewVisibilityChanged(percentVisibleHeight: Float) {
            }
        }
    }

    private fun updateController() {
        controller.setData(city)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
