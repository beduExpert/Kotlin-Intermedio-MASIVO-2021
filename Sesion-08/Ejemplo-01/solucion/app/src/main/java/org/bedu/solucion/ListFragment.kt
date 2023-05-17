package org.bedu.solucion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import org.bedu.solucion.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapter
    private var listener : (Product) ->Unit = {}

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Product) -> Unit){
        listener = l
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        binding.recyclerProducts.setHasFixedSize(true)
        binding.recyclerProducts.layoutManager =  GridLayoutManager(
            activity,
            2,
            GridLayoutManager.VERTICAL,
            false
        )//LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapter(requireActivity(), getProducts(), listener)
        val largePadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        binding.recyclerProducts.addItemDecoration(GridDecoration(largePadding, smallPadding))
        //asignando el Adapter al RecyclerView
        binding.recyclerProducts.adapter = mAdapter
    }

    //generamos datos dummy con este método
    private fun getProducts(): MutableList<Product>{
        var products:MutableList<Product> = ArrayList()

        products.add(
            Product(
                "Control ps5",
                "Disponible el 20 de noviembre",
                "$1400",
                4.6f,
                R.drawable.control
            )
        )
        products.add(Product("Intel core i9", "10ma Generación", "$9800", 4.4f, R.drawable.corei9))
        products.add(Product("Lector Kobo", "Disponible Prime", "$2235", 3.8f, R.drawable.kobo))
        products.add(
            Product(
                "Audífonos Sony xm3",
                "Noise Cancelling",
                "$6449",
                4.8f,
                R.drawable.xm3
            )
        )

        return products
    }
}