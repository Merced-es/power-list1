package edu.cnm.deepdive.powerlist1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.PowerListWithItems;
import java.util.List;

public class PowerListAdapter extends RecyclerView.Adapter<PowerListAdapter.Holder> {

  private final Context context;
  private final List<PowerListWithItems> powerLists;
  private final OnClickListener clickListener;

  public PowerListAdapter(Context context, List<PowerListWithItems> powerLists,
      OnClickListener clickListener) {
    super();
    this.context = context;
    this.powerLists = powerLists;
    this.clickListener = clickListener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) { holder.bind(position); }

  @Override
  public int getItemCount() {
    return powerLists.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final View itemView;
    private final TextView description;
    private final TextView goal;
    private final TextView title;
    private final ImageView collapse;
    private final ImageView expand;
    private final ListView items;

    public Holder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
      description = itemView.findViewById(R.id.description);
      goal = itemView.findViewById(R.id.goal);
      title = itemView.findViewById(R.id.title);
      collapse = itemView.findViewById(R.id.collapse);
      expand = itemView.findViewById(R.id.expand);
      items = itemView.findViewById(R.id.items);
    }

    private void bind(int position) {
      PowerListWithItems powerList = powerLists.get(position);
      title.setText(powerList.getListTitle());
      description.setText(powerList.getDescription());
      if (powerList.isExpanded()) {
        collapse.setVisibility(View.VISIBLE);
        collapse.setOnClickListener((v) -> powerList.setExpanded(false));
        items.setVisibility(View.VISIBLE);
        expand.setVisibility(View.GONE);
      } else {
        collapse.setVisibility(View.GONE);
        items.setVisibility(View.GONE);
        expand.setVisibility(View.VISIBLE);
        expand.setOnClickListener((v) -> powerList.setExpanded(true));
      }
//      itemView.setOnClickListener((v) -> clickListener.onClick(v, getAdapterPosition(), powerList));
    }

  }

  public interface OnClickListener {

    void onClick(View view, int position, PowerList powerList);

  }
}

