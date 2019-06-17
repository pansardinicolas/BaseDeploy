package teste.nicolas.basedeploy.viewmodel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import teste.nicolas.basedeploy.databinding.UpcomingMovieItemBinding
import teste.nicolas.basedeploy.model.data.dto.local.UpcomingMovie


class UpcomingMoviesAdapter(var items: List<UpcomingMovie>) : RecyclerView.Adapter<UpcomingMoviesAdapter.ViewHolder>(),
    AdapterItemsContract {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: UpcomingMovieItemBinding = UpcomingMovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<UpcomingMovie>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: UpcomingMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(upcomingMovie: UpcomingMovie) {
            binding.movie = upcomingMovie
            binding.executePendingBindings()
        }
    }
}