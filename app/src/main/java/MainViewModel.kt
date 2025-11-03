import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel (application: Application): ViewModel {
    val allProducts: LiveData<List<Product>>
    private val repository: ProductRepository
    val searchResult: MutableLiveData<List<Product>>

    init {
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = ProductRepository(productDao)

        allProducts = repository.allProducts
        searchResult = repository.searchResult
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }
    fun findProduct(name: String) {
        repository.findProduct(name)
    }
    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }


}