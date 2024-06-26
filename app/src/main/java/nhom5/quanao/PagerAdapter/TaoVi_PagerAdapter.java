package nhom5.quanao.PagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import nhom5.quanao.CreateWallet.Vi_Fragment1;
import nhom5.quanao.CreateWallet.Vi_Fragment2;
import nhom5.quanao.CreateWallet.Vi_Fragment3;


public class TaoVi_PagerAdapter  extends FragmentStatePagerAdapter {
    public TaoVi_PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Vi_Fragment1();
            case 1:
                return new Vi_Fragment2();
            case 2:
                return new Vi_Fragment3();
            default:
                return new Vi_Fragment1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
