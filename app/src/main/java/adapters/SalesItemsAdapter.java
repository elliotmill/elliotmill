package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.elliotmiller.week2appem1974.R;

import data.SalesItem;
import fragments.SalesItems;

/**
 * Created by azeezolaniran on 23/07/2017.
 */

public class SalesItemsAdapter extends RecyclerView.Adapter<SalesItemsAdapter.ViewHolder>{
    private SalesItem[] salesItems;
    private Context context;
    private SalesItems.SalesItemsListener salesItemListener;

    public SalesItemsAdapter(Context ctx, SalesItem[] items, SalesItems.SalesItemsListener sL) {
        super();
        this.context = ctx;
        this.salesItems = items;
        this.salesItemListener = sL;
    }


    @Override
    public SalesItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.sales_item, null);
        return new SalesItemsAdapter.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(SalesItemsAdapter.ViewHolder holder, int position) {
        SalesItem item = this.salesItems[position];
        holder.ivIcon.setImageDrawable(
                this.context.getResources().getDrawable(
                        getCookieDrawableFromId(position)
                )
        );
        holder.tvName.setText(item.getItemName());
    }

    public static int getCookieDrawableFromId(int position) {
        switch (position) {
            case 0: {
                return R.drawable.chocolate_chip_cookie;
            }
            case 1: {
                return R.drawable.sugar_cookie;
            }
            case 2: {
                return R.drawable.mmcookie;
            }
            case 3: {
                return R.drawable.oatmeal_raisin_cookie;
            }
            case 4: {
                return R.drawable.snickerdoodle_cookie;
            }
            case 5: {
                return R.drawable.white_chocolate_cookie;
            }
            default:{
                return R.drawable.chocolate_chip_cookie;
            }
        }
    }

    @Override
    public int getItemCount() {
        return this.salesItems.length ;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivIcon;
        Button btnPurchase;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            this.ivIcon = (ImageView) itemView.findViewById(R.id.iv_item_icon);
            itemView.findViewById(R.id.btn_purchase).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    salesItemListener.selectItem(getAdapterPosition());
                }
            });
        }
    }
}
