package pl.rzeszow.wsiz.projekt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;

    ArrayList<User> al_users;

    Intent intent;

    public Adapter(Context context, ArrayList<User> al_users) {
        this.context = context;
        this.al_users = al_users;
    }

    static class ViewHolder {
        TextView tv_name;
        ImageButton ib_youtube, ib_facebook, ib_twitter, ib_vkontakte, ib_instagram;
    }

    @Override
    public int getCount() {
        return al_users.size();
    }

    @Override
    public Object getItem(int position) {
        return al_users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final User user = (User) getItem(position);

        ViewHolder viewholder;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);

            viewholder = new ViewHolder();

            viewholder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewholder.ib_youtube = (ImageButton) convertView.findViewById(R.id.ib_youtube);
            viewholder.ib_facebook = (ImageButton) convertView.findViewById(R.id.ib_facebook);
            viewholder.ib_twitter = (ImageButton) convertView.findViewById(R.id.ib_twitter);
            viewholder.ib_vkontakte = (ImageButton) convertView.findViewById(R.id.ib_vkontakte);
            viewholder.ib_instagram = (ImageButton) convertView.findViewById(R.id.ib_instagram);

            convertView.setTag(viewholder);
            viewholder.tv_name.setTag(user);
            viewholder.ib_youtube.setTag(user);
            viewholder.ib_facebook.setTag(user);
            viewholder.ib_twitter.setTag(user);
            viewholder.ib_vkontakte.setTag(user);
            viewholder.ib_instagram.setTag(user);
        }
        else
        {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.tv_name.setText(user.name);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ib_youtube:
                        if (!user.youtube.equals("")) {
                            intent = new Intent(context, YouTube.class);
                            intent.putExtra("YouTube", user.youtube);
                            context.startActivity(intent);
                        }
                        break;
                    case R.id.ib_facebook:
                        if (!user.facebook.equals("")) {
                            intent = new Intent(context, Facebook.class);
                            intent.putExtra("Facebook", user.facebook);
                            context.startActivity(intent);
                        }
                        break;
                    case R.id.ib_twitter:
                        if (!user.twitter.equals("")) {
                            intent = new Intent(context, Twitter.class);
                            intent.putExtra("Twitter", user.twitter);
                            context.startActivity(intent);
                        }
                        break;
                    case R.id.ib_vkontakte:
                        if (!user.vkontakte.equals("")) {
                            intent = new Intent(context, VKontakte.class);
                            intent.putExtra("VKontakte", user.vkontakte);
                            context.startActivity(intent);
                        }
                        break;
                    case R.id.ib_instagram:
                        if (!user.instagram.equals("")) {
                            intent = new Intent(context, Instagram.class);
                            intent.putExtra("Instagram", user.instagram);
                            context.startActivity(intent);
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        viewholder.ib_youtube.setOnClickListener(onClickListener);
        viewholder.ib_facebook.setOnClickListener(onClickListener);
        viewholder.ib_twitter.setOnClickListener(onClickListener);
        viewholder.ib_vkontakte.setOnClickListener(onClickListener);
        viewholder.ib_instagram.setOnClickListener(onClickListener);

        return convertView;
    }
}
