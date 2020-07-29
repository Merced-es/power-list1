package edu.cnm.deepdive.powerlist1.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.Holder> {

  private final Context context;
  private final List<Goal> goals;
  private final OnClickListener clickListener;

  public GoalAdapter(Context context, List<Goal> goals,
      OnClickListener clickListener) {
    super();
    this.context = context;
    this.goals = goals;
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
    private final TextView description;
    private final TextView goal;
    private final TextView powerList;

    public Holder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
      description = itemView.findViewById(R.id.description);
      goal = itemView.findViewById(R.id.goal);
      powerList = itemView.findViewById(R.id.title);
    }

    private void bind(int position) {
      Goal item = goals.get(position);
      goal.setText(item.getTitle());
      description.setText(item.getDescription());
      itemView.setOnClickListener((v) -> clickListener.onClick(v, getAdapterPosition(), item));
    }

  }

  public interface OnClickListener {

    void onClick(View view, int position, Goal goal);

  }
}

