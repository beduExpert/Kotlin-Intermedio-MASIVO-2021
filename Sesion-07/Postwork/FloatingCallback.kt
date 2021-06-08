import android.graphics.Rect
import android.os.Build
import android.support.annotation.MenuRes
import android.support.annotation.RequiresApi
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View

@RequiresApi(Build.VERSION_CODES.M)
class FloatingActionModeCallback : ActionMode.Callback2() {

    var onActionItemClickListener: OnActionItemClickListener? = null

    private var mode: ActionMode? = null
    @MenuRes private var menuResId: Int = 0
    private var contentLeft: Int = 0
    private var contentTop: Int = 0
    private var contentRight: Int = 0
    private var contentBottom: Int = 0

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        this.mode = mode
        mode.menuInflater.inflate(menuResId, menu)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
        return false
    }

    override fun onDestroyActionMode(mode: ActionMode) {
        this.mode = null
    }

    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
        onActionItemClickListener?.onActionItemClick(item)
        mode.finish()
        return true
    }

    override fun onGetContentRect(mode: ActionMode, view: View, outRect: Rect) {
        outRect.set(contentLeft, contentTop, contentRight, contentBottom)
    }

    fun startActionMode(view: View,
                       @MenuRes menuResId: Int,
                       contentLeft: Int = 0, contentTop: Int = 0,
                       contentRight: Int = view.width, contentBottom: Int = view.height) {
        this.menuResId = menuResId
        this.contentLeft = contentLeft
        this.contentTop = contentTop
        this.contentRight = contentRight
        this.contentBottom = contentBottom
        view.startActionMode(this, ActionMode.TYPE_FLOATING)
    }

    fun finishActionMode() {
        mode?.finish()
    }
}