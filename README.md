# LockableCollapsingToolbar
Extend CollapsingToolbarLayout to enable or disable collapsing during scroll or dragging

```kotlin
// Init
val collapsingToolbarLayout = findViewById<View>(R.id.collapsing_toolbar_layout) as LockableCollapsingToolbar
collapsingToolbarLayout.setViews(findViewById<View>(R.id.recycler_view), findViewById<View>(R.id.app_bar_layout))

// Lock the CollapsingToolbarLayout during scroll
collapsingToolbarLayout.setExpandLock(true)

// Lock CollapsingToolbarLayout during scroll and lock AppBar from dragging
collapsingToolbarLayout.setExpandLock(true, true)
```
