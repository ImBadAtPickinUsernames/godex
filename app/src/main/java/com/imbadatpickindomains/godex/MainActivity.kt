package com.imbadatpickindomains.godex

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.entry_item.view.*
import java.lang.reflect.Array.get

class MainActivity : AppCompatActivity() {
    var pd = PokedexData()
    var adapter: PokedexItemAdapter? = null
    var pokedexList = ArrayList<PokedexGridItem>()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadPokemon(pd.getPokemonNames())
        adapter = PokedexItemAdapter(this, pokedexList)
        gvEntrys.adapter = adapter
    }

    class PokedexItemAdapter : BaseAdapter {
        var pokedexList = ArrayList<PokedexGridItem>()
        var context: Context? = null

        constructor(context: Context, pokedexList: ArrayList<PokedexGridItem>) : super() {
            this.context = context
            this.pokedexList = pokedexList
        }

        override fun getCount(): Int {
            return pokedexList.size
        }

        override fun getItem(position: Int): Any {
            return pokedexList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pokedexItem = this.pokedexList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var pokedexItemView = inflator.inflate(R.layout.entry_item, null)
            pokedexItemView.imgPokemon.setImageResource(pokedexItem.image!!)
            pokedexItemView.tvName.text = pokedexItem.name!!

            return pokedexItemView
        }
    }

    private fun loadPokemon(pokeArray :Array<String>) {
        for (i in 0 until pokeArray.size) {
            val name = "p" + i.inc()
            val resID = resources.getIdentifier(name, "drawable", packageName)
            pokedexList.add(PokedexGridItem(pokeArray[i], resID))
        }
    }
}
