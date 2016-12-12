package connecton.com_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.katso.livebutton.LiveButton;

/**
 * Created by fathuriady on 11/12/16.
 */

public class HomeFragment extends Fragment {
    public HomeFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home,container,false);


        //Button Web Dev ke Activity List Web Dev
        LiveButton btnWebDev = (LiveButton) rootview.findViewById(R.id.btnWebDev);
        btnWebDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),WebDevelopmentList.class);
                startActivity(i);
            }
        });

        return rootview;
    }
}
