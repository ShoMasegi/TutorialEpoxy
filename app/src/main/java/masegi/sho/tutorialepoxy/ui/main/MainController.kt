package masegi.sho.tutorialepoxy.ui.main

import android.view.View
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import masegi.sho.tutorialepoxy.*
import masegi.sho.tutorialepoxy.model.City
import masegi.sho.tutorialepoxy.ui.common.horizontalCarousel
import masegi.sho.tutorialepoxy.ui.common.withModelsFrom

class MainController internal constructor(): TypedEpoxyController<City>() {

    interface Delegate {
        fun onLinkClick(view: View) {}
        fun onHeaderViewVisibilityChanged(percentVisibleHeight: Float) {}
    }

    var delegate: Delegate? = null

    override fun buildModels(data: City?) {
        data ?: return
        headerView {
            id("header view")
            cityName(data.name)
            description(data.description)
            onVisibilityChanged { _, _, percentVisibleHeight, _, _, _ ->
                delegate?.onHeaderViewVisibilityChanged(percentVisibleHeight)
            }
        }
        linkView {
            id("link view")
            onLinkClick { view -> delegate?.onLinkClick(view) }
        }
        homeHeaderView {
            id("home header view")
            headerTitle("Popular Homes")
        }
        horizontalCarousel {
            id("carousel")
            numViewsToShowOnScreen(1.05f)
            padding(Carousel.Padding.dp(20, 18))
            withModelsFrom(data.popularHomes) {
                HomeItemBindingModel_()
                    .id(it.name)
                    .title(it.name)
                    .username(it.owner)
            }
        }
        homeHeaderView {
            id("home header view")
            headerTitle("North End")
        }
        horizontalCarousel {
            id("carousel")
            numViewsToShowOnScreen(1.05f)
            padding(Carousel.Padding.dp(20, 18))
            withModelsFrom(data.popularHomes) {
                HomeItemBindingModel_()
                    .id(it.name)
                    .title(it.name)
                    .username(it.owner)
            }
        }
        footerView {
            id("footer view")
        }
    }
}
