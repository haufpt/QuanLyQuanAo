package nhom5.quanao.NVA_Loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nhom5.quanao.DAO.NhanVienDAO;
import nhom5.quanao.Entity.NhanVien;
import nhom5.quanao.NAV_Adapter.QL_ThongKe_Adapter;
import nhom5.quanao.Support.GetData;

public class QL_ThongKe_Loader extends AsyncTask<String, Void, ArrayList<NhanVien>> {
    @SuppressLint("StaticFieldLeak")
    Context context;
    String TAG = "QL_ThongKe_Loader_____";
    NhanVienDAO nhanVienDAO;
    ArrayList<NhanVien> listNV = new ArrayList<>();
    @SuppressLint("StaticFieldLeak")
    RecyclerView reView;
    @SuppressLint("StaticFieldLeak")
    LinearLayout loadingView;
    String[] getDate;

    public QL_ThongKe_Loader(Context context, RecyclerView reView, LinearLayout loadingView, String[] getDate) {
        this.context = context;
        this.reView = reView;
        this.loadingView = loadingView;
        this.getDate = getDate;
    }

    @Override
    protected ArrayList<NhanVien> doInBackground(String... strings) {
        GetData data = new GetData(context);
        nhanVienDAO = new NhanVienDAO(context);
        listNV = nhanVienDAO.selectNhanVien(null, null, null, null);
        data.addDataDoanhSo(listNV, getDate);

        listNV.clear();
        return nhanVienDAO.selectNhanVien(null, null, null, "doanhSo DESC");
    }

    @Override
    protected void onPostExecute(ArrayList<NhanVien> listNV) {
        super.onPostExecute(listNV);

        if (loadingView != null && reView != null){
            loadingView.setVisibility(View.GONE);
            setupReView(listNV, reView);
        }
    }

    private void setupReView(ArrayList<NhanVien> listNV, RecyclerView recyclerView) {
        Log.d(TAG, "setUpReView: true");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        QL_ThongKe_Adapter ql_thongKe_adapter = new QL_ThongKe_Adapter(listNV, context);
        recyclerView.setAdapter(ql_thongKe_adapter);
    }

}
