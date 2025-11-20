package lab.service;


import lab.model.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> getFlowers();

    Flower addFlower(Flower flower);
}
