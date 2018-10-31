package masegi.sho.tutorialepoxy.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import masegi.sho.tutorialepoxy.model.City
import masegi.sho.tutorialepoxy.model.Home
import masegi.sho.tutorialepoxy.R
import masegi.sho.tutorialepoxy.databinding.MainFragmentBinding

class MainFragment : Fragment(), MainController.Callbacks {

    private lateinit var binding: MainFragmentBinding

    private val controller = MainController(this)

    // mock
    private lateinit var city: City

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.epoxyView.setController(controller)
        setupMock()
        updateController()
        return binding.root
    }

    private fun setupMock() {
        val homes = mutableListOf<Home>()
        for (i in 1..3) {
            val home =
                Home(getString(R.string.home_name), getString(R.string.home_owner), 0, 0)
            homes.add(home)
        }
        city = City(getString(R.string.city), getString(R.string.description), homes)
    }

    private fun updateController() {
        controller.setData(city)
    }

    override fun onLinkClick() {
        print("touched")
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
