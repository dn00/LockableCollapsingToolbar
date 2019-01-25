
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

/**
 * Extend CollapsingToolbarLayout to enable or disable collapsing
 *
 * Source: https://code.luasoftware.com/tutorials/android/how-to-disable-or-lock-collapsingtoolbarlayout-collapse-or-expand/
 *
 */
class LockableCollapsingToolbar : CollapsingToolbarLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var mRecyclerView : View? = null
    private var mAppBar : AppBarLayout? = null

    /**
     * Set the views
     *
     * @param recyclerView the RecyclerView
     * @param appBar the AppBarLayout
     */
    fun setViews(recyclerView : View, appBar : AppBarLayout) {
        mRecyclerView = recyclerView
        mAppBar = appBar
    }

    /**
     * Lock or unlock CollapsingToolbarLayout from expanding
     *
     * @param lockScroll The boolean True to lock or False to unlock expanding
     */
    fun setExpandLock(lockScroll : Boolean) {
        ViewCompat.setNestedScrollingEnabled(mRecyclerView as View, !lockScroll)
    }
    /**
     * Lock or unlock CollapsingToolbarLayout from expanding
     * and lock or unlock dragging of AppBar
     *
     * @param lockScroll The boolean True to lock or False to unlock expanding
     * @param lockAppBar The boolean True to lock the AppBar from being draggable
     */
    fun setExpandLock(lockScroll : Boolean, lockAppBar : Boolean ) {
        ViewCompat.setNestedScrollingEnabled(mRecyclerView as View, !lockScroll)
        setAppBarDraggable(!lockAppBar)
    }

    /**
     * Enable or disable dragging of AppBar
     *
     * @Param canDrag The boolean True to set AppBar to draggable and vice versa
     */
    private fun setAppBarDraggable(canDrag : Boolean) {
        val params = mAppBar!!.layoutParams as CoordinatorLayout.LayoutParams
        if (params.behavior == null)
            params.behavior = AppBarLayout.Behavior()
        val behaviour = params.behavior as AppBarLayout.Behavior
        behaviour.setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
            override fun canDrag(appBarLayout: AppBarLayout): Boolean {
                return canDrag
            }
        })
    }

}

