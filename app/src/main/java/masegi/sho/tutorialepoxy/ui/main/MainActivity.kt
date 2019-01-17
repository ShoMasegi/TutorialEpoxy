package masegi.sho.tutorialepoxy.ui.main

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import masegi.sho.tutorialepoxy.R
import masegi.sho.tutorialepoxy.databinding.MainActivityBinding
import masegi.sho.tutorialepoxy.ui.common.actionBarHeight
import masegi.sho.tutorialepoxy.ui.common.statusBarHeight

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolBar()
        changeStatusBarColorTransparent()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val inset = resources.displayMetrics.density * 2f
        binding.collapsingToolbarLayout.scrimVisibleHeightTrigger =
                statusBarHeight + actionBarHeight + inset.toInt()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.main_favorite -> { true }
            R.id.main_share -> { true }
            else -> { super.onOptionsItemSelected(item) }
        }
    }

    private fun changeStatusBarColorTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById<View>(android.R.id.content).systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.argb(80, 0, 0, 0)
        }
    }

    private fun setupToolBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
