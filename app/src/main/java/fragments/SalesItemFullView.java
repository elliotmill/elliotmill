package fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.elliotmiller.week2appem1974.R;

import adapters.SalesItemsAdapter;
import data.SalesItem;
import data.Store;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SalesItemFullView.SalesItemFullViewInterface} interface
 * to handle interaction events.
 * Use the {@link SalesItemFullView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SalesItemFullView extends Fragment {
    private static final String SALES_ITEM = "param1";


    private int salesItemId;

    private SalesItemFullViewInterface mListener;

    public SalesItemFullView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *@param salesId Id of the sales item (cookie in this case)
     * @return A new instance of fragment SalesItemFullView.
     */
    public static SalesItemFullView newInstance(int salesId) {
        SalesItemFullView fragment = new SalesItemFullView();
        Bundle args = new Bundle();
        args.putInt(SALES_ITEM, salesId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.salesItemId = getArguments().getInt(SALES_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final SalesItem[] salesItems = Store.getSalesItems();
        View root = inflater.inflate(R.layout.sales_item_full_view, container, false);
        ((ImageView)root.findViewById(R.id.iv_salesItem)).setImageDrawable(
                getContext().getResources().getDrawable(SalesItemsAdapter.getCookieDrawableFromId(this.salesItemId))
        );
        ((TextView)root.findViewById(R.id.tv_title)).setText(salesItems[this.salesItemId].getItemName());
        ((TextView)root.findViewById(R.id.tv_description)).setText(salesItems[this.salesItemId].getItemDescription());
        root.findViewById(R.id.btn_purchase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.addToCart(SalesItemFullView.this.salesItemId);
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SalesItemFullViewInterface) {
            mListener = (SalesItemFullViewInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface SalesItemFullViewInterface {
        void addToCart(int itemId);
    }
}
