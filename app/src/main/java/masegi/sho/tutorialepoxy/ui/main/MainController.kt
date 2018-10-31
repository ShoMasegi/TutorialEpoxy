package masegi.sho.tutorialepoxy.ui.main

import com.airbnb.epoxy.TypedEpoxyController
import masegi.sho.tutorialepoxy.*
import masegi.sho.tutorialepoxy.model.City

class MainController internal constructor(
    private val callbacks: Callbacks
): TypedEpoxyController<City>() {

    interface Callbacks {
        fun onLinkClick()
    }

    override fun buildModels(data: City?) {
        data ?: return
        headerView {
            id("header view")
            cityName(data.name)
            description(data.description)
        }
        linkView {
            id("link view")
            onLinkClick { _ -> callbacks.onLinkClick() }
        }
        homeHeaderView {
            id("home header view")
        }
        data.popularHomes.forEach { home ->
            homeItem {
                id("home view ${home.name}")
                title(home.name)
                username(home.owner)
            }
        }
        footerView {
            id("footer view")
        }
    }
}
