package lab.controller;

import java.util.List;
import lab.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.model.Flower;

@RequestMapping("/flower")
@RestController
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping()
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @PostMapping()
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.addFlower(flower);
    }
}
