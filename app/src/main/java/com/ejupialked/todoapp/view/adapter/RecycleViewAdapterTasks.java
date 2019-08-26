package com.ejupialked.todoapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejupialked.todoapp.R;
import com.ejupialked.todoapp.domain.model.Task;
import com.ejupialked.todoapp.view.presenter.TasksPresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapterTasks extends RecyclerView.Adapter<RecycleViewAdapterTasks.ViewHolder> {

    private final TasksPresenter presenter;
    private final List<Task> tasks;


    public RecycleViewAdapterTasks(TasksPresenter presenter) {
        this.presenter = presenter;
        this.tasks = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new RecycleViewAdapterTasks.ViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.render(task);

    }

    public TasksPresenter getPresenter() {
        return presenter;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void addAll(Collection<Task> collection) {
        tasks.addAll(collection);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_description)
        TextView txt_description;

        @BindView(R.id.txt_priority)
        TextView txt_priority;

        @BindView(R.id.txt_isComplete)
        TextView txt_isComplete;

       public ViewHolder(@NonNull View itemView, TasksPresenter presenter) {
           super(itemView);
           ButterKnife.bind(this, itemView);
       }

        public void render(Task task) {
           renderDescription(task.getDescrption());
           renderPriority(task.getPriority());
           renderCompleted(task.getIsCompleted());
        }

        private void renderDescription(String descrption) {
           txt_description.setText(descrption);
        }

        private void renderPriority(String priority) {
           txt_priority.setText(priority);
        }

        private void renderCompleted(String completed) {
           txt_isComplete.setText(completed);
        }

    }
}
