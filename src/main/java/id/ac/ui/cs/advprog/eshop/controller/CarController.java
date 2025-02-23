package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private BaseService<Car> carService;

    @GetMapping("/create")
    public String createCarPage(Model model) {
        model.addAttribute("car", new Car());
        return "CreateCar";
    }

    @PostMapping("/create")
    public String createCarPost(@ModelAttribute Car car) {
        carService.create(car);
        return "redirect:/car/list";
    }

    @GetMapping("/list")
    public String carListPage(Model model) {
        List<Car> allCars = carService.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }

    @GetMapping("/edit/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        return "EditCar";
    }

    @PostMapping("/edit")
    public String editCarPost(@ModelAttribute Car car) {
        carService.update(car.getCarId(), car);
        return "redirect:/car/list";
    }

    @PostMapping("/delete/{carId}")
    public String deleteCarPost(@PathVariable String carId) {
        carService.deleteById(carId);
        return "redirect:/car/list";
    }
}
