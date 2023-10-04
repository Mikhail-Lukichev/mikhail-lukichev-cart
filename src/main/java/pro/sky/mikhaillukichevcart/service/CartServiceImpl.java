package pro.sky.mikhaillukichevcart.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.floor;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    private List<Integer> items;

    public List<Integer> getItems() {
        return items;
    }

    public void addItem(Integer id) {
        if (this.items == null) {
            items = new ArrayList<>(List.of(id));
        } else {
            items.add(id);
        }
    }

    public List<Integer> addOrder(String idString) {
        List<String> ids = new ArrayList<String>(Arrays.asList(idString.split(",")));
        ids.stream().filter(e -> StringUtils.isNumeric(e))
                .filter(e -> floor(Float.parseFloat(e)) == Float.parseFloat(e))
                .map(e -> Integer.valueOf(e))
                .forEach(e -> addItem(e));
        return this.getItems();
    }
}
