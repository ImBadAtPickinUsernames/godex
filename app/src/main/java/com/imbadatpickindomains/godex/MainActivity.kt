package com.imbadatpickindomains.godex

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.entry_item.view.*


class MainActivity : AppCompatActivity() {
    private var pd = PokedexData()
    var adapter: PokedexItemAdapter? = null
    private var pokedexList = ArrayList<PokedexGridItem>()

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

        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        // loads the pokemon-sprites and names
        initGView()
        // no use
        pd.getPokemonData(this)
    }

   private fun initGView(){
       loadPokemon(pd.getPokemonNames())
       adapter = PokedexItemAdapter(this, pokedexList)
       gvEntrys.adapter = adapter
    }

    class PokedexItemAdapter(context: Context, var pokedexList: ArrayList<PokedexGridItem>) : BaseAdapter() {
        var context: Context? = context

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
            val pokedexNum = position.toInt()

            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val pokedexItemView = inflator.inflate(R.layout.entry_item, null)
            pokedexItemView.imgPokemon.setImageResource(pokedexItem.image!!)
            pokedexItemView.tvName.text = pokedexItem.name!!

            pokedexItemView.setOnClickListener(){
                val intent = Intent(context, PokemonDetailView::class.java)
                intent.putExtra("dexNum", pokedexNum)
                context!!.startActivity(intent)
            }

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
