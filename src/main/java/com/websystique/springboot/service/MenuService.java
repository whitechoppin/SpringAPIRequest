package com.websystique.springboot.service;

import com.websystique.springboot.model.Menu;

import java.util.List;

public interface MenuService {
    Menu findById(long id);

    Menu findByJudul(String judul);

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenuById(long id);

    List<Menu> findAllMenus();

    void deleteAllMenus();

    boolean isMenuExist(Menu menu);
}
