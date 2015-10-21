package eu.kanade.mangafeed.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import eu.kanade.mangafeed.data.models.Page;
import eu.kanade.mangafeed.ui.fragment.ReaderPageFragment;

public class ReaderPageAdapter extends SmartFragmentStatePagerAdapter {

    private List<Page> pages;

    public ReaderPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        if (pages != null)
            return pages.size();

        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        return ReaderPageFragment.newInstance(pages.get(position));
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
        notifyDataSetChanged();
    }

    public void replacePage(int position, Page page) {
        pages.set(position, page);
        notifyDataSetChanged();

        ReaderPageFragment fragment = (ReaderPageFragment)getRegisteredFragment(position);
        if (fragment != null) {
            fragment.setPage(page);
        }
    }

}