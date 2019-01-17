package masegi.sho.tutorialepoxy.ui.common

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.ModelView.Size

@ModelView(saveViewState = true, autoLayout = Size.MATCH_WIDTH_WRAP_HEIGHT)
class HorizontalCarousel(context: Context): Carousel(context) {

    init {
        isNestedScrollingEnabled = false
    }

    override fun createLayoutManager(): LayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}
