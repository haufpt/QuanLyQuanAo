package nhom5.quanao.FragmentNV_Admin;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import nhom5.quanao.DAO.NhanVienDAO;
import nhom5.quanao.Entity.NhanVien;
import nhom5.quanao.NVA_Loader.NV_DonHang_Loader;
import nhom5.quanao.R;

import java.util.ArrayList;


public class NV_TTDonHang1_Fragment extends Fragment {

    Context context;
    String TAG = "NV_DonHang_Activity_____";
    RecyclerView recyclerView;
    LinearLayout linearLayout, linearDonHangEmpty;
    NhanVien nhanVien;
    public NV_TTDonHang1_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_k_h__t_t_don_hang1_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        linearLayout = view.findViewById(R.id.loadingView);
        recyclerView = view.findViewById(R.id.recyclerView_KH_DonHang);
        linearDonHangEmpty = view.findViewById(R.id.linearDonHangEmpty);

        getUser();
        if (nhanVien != null) {
            NV_DonHang_Loader nv_donHang_loader = new NV_DonHang_Loader(context, recyclerView, linearLayout, linearDonHangEmpty,"Đang giao hàng");
            nv_donHang_loader.execute(nhanVien.getMaNV());
        }else{
            NV_DonHang_Loader nv_donHang_loader = new NV_DonHang_Loader(context, recyclerView, linearLayout, linearDonHangEmpty,"Đang giao hàng");
            nv_donHang_loader.execute("No Data");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getUser();
        if (nhanVien != null) {
            NV_DonHang_Loader nv_donHang_loader = new NV_DonHang_Loader(context, recyclerView, linearLayout, linearDonHangEmpty,"Đang giao hàng");
            nv_donHang_loader.execute(nhanVien.getMaNV());
        }else{
            NV_DonHang_Loader nv_donHang_loader = new NV_DonHang_Loader(context, recyclerView, linearLayout, linearDonHangEmpty,"Đang giao hàng");
            nv_donHang_loader.execute("No Data");
        }
    }

    private void getUser(){
        SharedPreferences pref = context.getSharedPreferences("Who_Login", MODE_PRIVATE);
        if (pref == null) {
            nhanVien = null;
        } else {
            String user = pref.getString("who", "");
            NhanVienDAO nhanVienDAO = new NhanVienDAO(context);
            ArrayList<NhanVien> list = nhanVienDAO.selectNhanVien(null, "maNV=?", new String[]{user}, null);
            if (list.size() > 0){
                nhanVien = list.get(0);
            }
        }
    }

}