package luongvo.com.todolistminimal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import luongvo.com.todolistminimal.Adapters.MyFragmentPagerAdapter;
import luongvo.com.todolistminimal.Adapters.TodoListAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment extends Fragment {

    private int mPage;
    @BindView(R.id.todoList) ListView todoList;
    TodoListAdapter fragmentPagerAdapter;
    private ArrayList<ToDoItem> toDoItems;


    private static final String ARG_PAGE = "ARG_PAGE";

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toDoItems = new ArrayList<>();
        fragmentPagerAdapter = new TodoListAdapter(getActivity().getApplicationContext(), R.layout.todo_item, toDoItems);
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        toDoItems.add(new ToDoItem("Test", true));
        todoList.setAdapter(fragmentPagerAdapter);
    }
}
