package pl.rzeszow.wsiz.projekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener {

    ListView lv_users;
    ImageButton ib_add;

    ArrayList<User> al_users = new ArrayList<>();

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lv_users = (ListView) findViewById(R.id.lv_users);
        ib_add = (ImageButton) findViewById(R.id.ib_add);

        registerForContextMenu(lv_users);

        ib_add.setOnClickListener(this);

        adapter = new Adapter(this, al_users);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ib_add:
                Intent intent = new Intent(this, Add.class);
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case R.id.lv_users:
                menu.add(0,1,0,"Delete");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case 1:
                al_users.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }

        ArrayList<String> datalist = data.getStringArrayListExtra("pl.rzeszow.wsiz.projekt.data");

        al_users.add(new User(datalist.get(0), datalist.get(1), datalist.get(2), datalist.get(3), datalist.get(4), datalist.get(5)));

        lv_users.setAdapter(adapter);
    }
}
