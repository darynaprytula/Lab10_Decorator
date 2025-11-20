package lab.service.impl;

import lab.model.Flower;
import lab.repository.FlowerRepository;
import lab.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    private FlowerRepository flowerRepository;

    @Autowired
    public FlowerServiceImpl(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    @Override
    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }


}
