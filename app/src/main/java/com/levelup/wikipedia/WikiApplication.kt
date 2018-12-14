package com.levelup.wikipedia

import android.app.Application
import com.levelup.wikipedia.managers.WikiManager
import com.levelup.wikipedia.providers.ArticleDataProvider
import com.levelup.wikipedia.respositories.ArticleDatabaseOpenHelper
import com.levelup.wikipedia.respositories.FavoritesRepository
import com.levelup.wikipedia.respositories.HistoryRepository

class WikiApplication : Application() {
    private var dbHelper: ArticleDatabaseOpenHelper? = null
    private var favoritesRepository: FavoritesRepository? = null
    private var historyRepository: HistoryRepository? = null
    private var wikiProvider: ArticleDataProvider? = null
    var wikiManager: WikiManager? = null
        private set

    override fun onCreate() {
        super.onCreate()

        dbHelper = ArticleDatabaseOpenHelper(applicationContext)
        favoritesRepository = FavoritesRepository(dbHelper!!)
        historyRepository = HistoryRepository(dbHelper!!)
        wikiProvider = ArticleDataProvider()
        wikiManager = WikiManager(wikiProvider!!, favoritesRepository!!, historyRepository!!)
    }
}