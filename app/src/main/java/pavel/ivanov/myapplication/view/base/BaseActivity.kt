package pavel.ivanov.myapplication.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.presenter.Presenter

abstract class BaseActivity<T: AppState> : AppCompatActivity(), View {

    // Храним ссылку на презентер
    protected lateinit var presenter: Presenter<T, View>

    protected abstract fun createPresenter(): Presenter<T, View>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}