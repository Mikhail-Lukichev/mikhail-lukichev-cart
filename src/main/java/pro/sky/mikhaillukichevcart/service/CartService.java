package pro.sky.mikhaillukichevcart.service;


import java.util.List;

public interface CartService {
    List<Integer> addOrder(String ids);

    List<Integer> getItems();
}
