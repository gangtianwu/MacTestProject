package com.ding.pokedex.viewmodel;

import androidx.lifecycle.ViewModel;

import com.ding.pokedex.R;
import com.ding.pokedex.entity.Menu;
import com.ding.pokedex.entity.News;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {
    private List<Menu> listMenu;
    private List<News> listNews;

    // TODO: 2020/8/19 添加livedata 绑定 以及viewBinding
    public HomeFragmentViewModel() {
        listMenu = new ArrayList<>();
        listMenu.add(new Menu(1,"Pokedex", R.color.lightTeal));
        listMenu.add(new Menu(1,"Moves", R.color.lightRed));
        listMenu.add(new Menu(1,"Abilities", R.color.lightBlue));
        listMenu.add(new Menu(1,"Items", R.color.lightYellow));
        listMenu.add(new Menu(1,"Locations", R.color.lightPurple));
        listMenu.add(new Menu(1,"Type Charts", R.color.lightTeal));
//      list.add(new Menu(1,"Type Charts", R.color.lightBrown));

        listNews = new ArrayList<>();
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
        listNews.add(new News());
    }

    public  List<Menu> getData() {

        return listMenu;
    }

    public List<News> getNewsData() {

        return listNews;
    }
}
