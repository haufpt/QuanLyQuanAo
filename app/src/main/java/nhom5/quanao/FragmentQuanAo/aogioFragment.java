package nhom5.quanao.FragmentQuanAo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import nhom5.quanao.Entity.Photo;
import nhom5.quanao.KH_Loader.KH_QuanAo_Loader;
import nhom5.quanao.R;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class aogioFragment extends Fragment {

    List<Photo> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aogio, container, false);


        list = setListPhoto();

        KH_QuanAo_Loader kh_quanAo_loader = new KH_QuanAo_Loader(getContext(), view.findViewById(R.id.recyclerView_Laptop_HP));
        kh_quanAo_loader.execute("LAoThun");

        return view;
    }

    private List<Photo> setListPhoto() {
        list.add(new Photo(R.drawable.thun_mot));
        list.add(new Photo(R.drawable.thun_hai));
        list.add(new Photo(R.drawable.thun_ba));
        list.add(new Photo(R.drawable.thun_bon));
        list.add(new Photo(R.drawable.thun_nam));
        return list;
    }
}