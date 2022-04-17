package pavel.ivanov.core.viewmodel

// Ещё выше стоит интерактор. Здесь уже чистая бизнес-логика
interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
