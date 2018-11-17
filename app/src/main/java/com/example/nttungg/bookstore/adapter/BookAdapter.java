//package com.example.nttungg.bookstore.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.nttungg.bookstore.R;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
//
////    private Context mContext;
////    private ArrayList<User> mUsers;
////    private User mUser;
////    private LayoutInflater mLayoutInflater;
////    private BookAdapter.ItemClickListener mItemClickListener;
////
////    public BookAdapter(Context context, BookAdapter.ItemClickListener itemClickListener) {
////        mContext = context;
////        mItemClickListener = itemClickListener;
////    }
////
////    @Override
////    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
////        if (mLayoutInflater == null) {
////            mLayoutInflater = LayoutInflater.from(parent.getContext());
////        }
////
////        View view = mLayoutInflater.inflate(R.layout.item_list_story, parent, false);
////
////        return new ViewHolder(view);
////    }
////
////    @Override
////    public void onBindViewHolder(ViewHolder holder, int position) {
////        if (mUsers == null) return;
////        holder.bindData(mUsers.get(position));
////    }
////
////    @Override
////    public int getItemCount() {
////        return mUsers != null ? mUsers.size() : 0;
////    }
////
////    public void replaceData(ArrayList<User> users) {
////        if (mUsers == null) {
////            mUsers = users;
////        } else {
////            mUsers = new ArrayList<>();
////            mUsers.addAll(users);
////        }
////        notifyDataSetChanged();
////    }
////
////
//    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mItemClickListener.onItemClicked(mUsers,getPosition());
//                }
//            });
//        }
//
//        public void bindData(User user) {
//            if (user == null) return;
//            mUser = user;
//            ArrayList<String> urlImage = new ArrayList<>();
//            urlImage.add("https://images.pexels.com/photos/1056555/pexels-photo-1056555.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1587269/pexels-photo-1587269.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/106400/pexels-photo-106400.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1574162/pexels-photo-1574162.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1574651/pexels-photo-1574651.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1579616/pexels-photo-1579616.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1391480/pexels-photo-1391480.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/1319839/pexels-photo-1319839.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/669005/pexels-photo-669005.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/89643/pexels-photo-89643.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            urlImage.add("https://images.pexels.com/photos/671557/pexels-photo-671557.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            Glide.with(mContext)
//                    .load(urlImage.get(new Random().nextInt(urlImage.size()-1)))
//                    .into(mImageProfile);
//        }
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
//
//    public interface ItemClickListener {
//        void onItemClicked(List<User> user, int index);
//    }
//}
