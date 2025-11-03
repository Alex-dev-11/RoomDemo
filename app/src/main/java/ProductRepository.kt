import androidx.lifecycle.MutableLiveData

class ProductRepository (private val productDao: productDao) {
    val searchResult = MutableLiveData<List<Product>>()
    val allProducts: LivaData<List<Product>> = productDao.getAllProducts()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    fun insertProduct(newproduct: Product) {
        coroutineScope.launch(Dispatchers.IO) {
            productDao.insertProduct(newproduct)
        }
    }
    fun deleteProduct(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            productDao.deleteProduct(name)
        }
    }fun findProduct(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private fun asyncFind(name: String): Deferred<List<Product>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async productDao.findProduct(name)
        }
}