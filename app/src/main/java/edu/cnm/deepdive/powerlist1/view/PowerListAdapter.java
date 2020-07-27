package edu.cnm.deepdive.powerlist1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.PowerListWithItem;
import java.util.List;

public class PowerListAdapter extends RecyclerView.Adapter<PowerListAdapter.Holder> {

  private final Context context;
  private final List<PowerList> powerLists;
  private final OnClickListener clickListener;

  public PowerListAdapter(Context context, List<PowerList> powerLists,
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
    private final TextView powerList;

    public Holder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
      description = itemView.findViewById(R.id.description);
      goal = itemView.findViewById(R.id.goal);
      powerList = itemView.findViewById(R.id.powerList);
    }

    private void bind(int position) {
      PowerList item = powerLists.get(position);
      powerList.setText(item.getListTitle());
      description.setText(item.getDescription());
      itemView.setOnClickListener((v) -> clickListener.onClick(v, getAdapterPosition(), item));
    }

  }

  public interface OnClickListener {

    void onClick(View view, int position, PowerList powerList);

  }
}

