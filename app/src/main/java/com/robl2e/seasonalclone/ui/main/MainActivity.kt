package com.robl2e.seasonalclone.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.robl2e.seasonalclone.R

// synthetic == butterknife for kotlin
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.v7.widget.DividerItemDecoration
import com.robl2e.seasonalclone.data.produce.ProduceItem


class MainActivity : AppCompatActivity() {
    var adapter : ProduceListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initializeList()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun initializeList() {
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        produceList.addItemDecoration(itemDecoration)

        if (adapter == null) {
            adapter = ProduceListAdapter(loadProduceItems())
        }
        produceList.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    private fun loadProduceItems() : List<ProduceItem> {
        val produceRepo = ProduceRepository()
        return produceRepo.loadProduceItems(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
