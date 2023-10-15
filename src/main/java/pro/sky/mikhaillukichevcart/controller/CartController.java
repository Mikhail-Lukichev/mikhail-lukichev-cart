package pro.sky.mikhaillukichevcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mikhaillukichevcart.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class CartController {
    private final CartService orderService;

    public CartController(CartService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/add")
    public List<Integer> addOrder(@RequestParam(value = "id") String ids) {
        return orderService.addOrder(ids);
    }

    @GetMapping(path = "/get")
    public List<Integer> getOrder() {
        return orderService.getItems();
    }
}
