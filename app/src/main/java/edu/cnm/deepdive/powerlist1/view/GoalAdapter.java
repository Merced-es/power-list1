package edu.cnm.deepdive.powerlist1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.view.GoalAdapter.Holder;
import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<Holder> {

  private final String unattributedPowerList;
  private final Context context;
  private final List<GoalWithList> goals;
  private final OnClickListener clickListener;

  public GoalAdapter(Context context,
      List<GoalWithList> goals,
      OnClickListener clickListener) {
    super();
    this.context = context;
    this.goals = goals;
    unattributedPowerList = context.getString(R.string.unattributed_power_list);
    this.clickListener = clickListener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_goal, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return goals.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final View itemView;
    private final TextView goal;
    private final TextView powerList;

    public Holder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
      goal = itemView.findViewById(R.id.goals_button);
      powerList = itemView.findViewById(R.id.power_list_button);
    }

    private void bind(int position) {
      GoalWithList item = goals.get(position);
      String listName =
          (item.getPowerList() != null) ? item.getPowerList().getListName() : unattributedPowerList;
      goal.setText(item.getText());
      powerList.setText(String.format(listName));
      itemView.setOnClickListener((v) -> clickListener.onClick(v, getAdapterPosition(), item));
    }

  }

  public interface OnClickListener {

    void onClick(View v, int position, GoalWithList goal);

  }
}
