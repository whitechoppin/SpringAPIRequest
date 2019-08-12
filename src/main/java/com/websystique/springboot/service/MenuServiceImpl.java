package com.websystique.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.websystique.springboot.model.Menu;

@Service("menuService")
public class MenuServiceImpl implements MenuService{


    private static final AtomicLong counter = new AtomicLong();

    private static List<Menu> menus;

    static{
        menus= populateDummyMenus();
    }

    public List<Menu> findAllMenus() {
        return menus;
    }

    public Menu findById(long id) {
        for(Menu menu : menus){
            if(menu.getId() == id){
                return menu;
            }
        }
        return null;
    }

    public Menu findByJudul(String judul) {
        for(Menu menu : menus){
            if(menu.getJudul().equalsIgnoreCase(judul)){
                return menu;
            }
        }
        return null;
    }

    public void saveMenu(Menu menu) {
        menu.setId(counter.incrementAndGet());
        menus.add(menu);
    }

    public void updateMenu(Menu menu) {
        int index = menus.indexOf(menu);
        menus.set(index, menu);
    }

    public void deleteMenuById(long id) {

        for (Iterator<Menu> iterator = menus.iterator(); iterator.hasNext(); ) {
            Menu menu = iterator.next();
            if (menu.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isMenuExist(Menu menu) {
        return findByJudul(menu.getJudul())!=null;
    }

    public void deleteAllMenus(){
        menus.clear();
    }

    private static List<Menu> populateDummyMenus(){
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu(counter.incrementAndGet(),"PromoCard"));
        menus.add(new Menu(counter.incrementAndGet(),"CategoryCard"));
        menus.add(new Menu(counter.incrementAndGet(),"FlashSaleCard"));
        menus.add(new Menu(counter.incrementAndGet(),"HistoryCard"));
        menus.add(new Menu(counter.incrementAndGet(),"NewsCard"));
        return menus;
    }
}
