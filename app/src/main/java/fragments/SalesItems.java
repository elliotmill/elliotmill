package fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.elliotmiller.week2appem1974.R;

import adapters.SalesItemsAdapter;
import data.SalesItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SalesItems.SalesItemsListener} interface
 * to handle interaction events.
 * Use the {@link SalesItems#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SalesItems extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SalesItems.SalesItemsListener salesItemsHandler;

    public SalesItems() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment SalesItemsAdapter.
     */
    // TODO: Rename and change types and number of parameters
    public static SalesItems newInstance() {
        SalesItems fragment = new SalesItems();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SalesItem[] salesItems = SalesItem.getSalesItems();
        View root = inflater.inflate(R.layout.sales_items, container, false);
        ((TextView)root.findViewById(R.id.title)).setText(salesItems.length + " Cookies Available");
        recyclerView = (RecyclerView)root.findViewById(R.id.rv_sales_items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SalesItemsAdapter(getContext(), salesItems, this.salesItemsHandler));
        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SalesItemsListener) {
            this.salesItemsHandler = (SalesItemsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.salesItemsHandler = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface SalesItemsListener {
        void selectItem(int id);
    }
}
