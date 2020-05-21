package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    @PostMapping("buy")
    public JSONResult buy(@RequestParam @Valid @NotBlank String carName,
                          @RequestParam @Valid @NotBlank String carType,
                          @RequestParam @Valid @NotNull Integer buyNumber){
        if(buyNumber>=1){
            Car car = null;
            Integer carNum= null;
            try {
                car = carService.findByCarNameAndCarType(carName,carType);
                carNum = car.getNum();
            } catch (Exception e) {
                return JSONResult.errorException(e.getMessage());
            }
            if(car.getNum()>=buyNumber){
                try {
                    Integer remainNum=carNum-buyNumber;
                    car.setNum(remainNum);
                    carService.updateById(car);
                } catch (Exception e) {
                    return JSONResult.errorException(e.getMessage());
                }
                return JSONResult.ok("购买成功!");
            }
            else {
                return JSONResult.errorException("剩余数量不足，请重新选择数量或其他车型");
            }

        }else {
            return JSONResult.errorException("请正确填写购买数量(大于等于1)！");
        }

    }



    @GetMapping("fuzzyQueryPage")
    public JSONResult FuzzyQueryPage(String carName,
                                 Integer fromItem,Integer toItem){
        Integer size=null;

        if(fromItem!=null && toItem!=null){
            if(fromItem>=0 && toItem>=0){
                size=toItem-fromItem+1;
                fromItem=fromItem-1;
            }
        }
        List<Car> cars = null;
        try {
            cars = carService.fuzzyQueryPage(carName, fromItem, size);
        } catch (Exception e) {
            return JSONResult.errorException(e.getMessage());
        }
        if(CollectionUtils.isEmpty(cars)){
           return JSONResult.errorMap("无此数据");
        }
        return JSONResult.ok(cars);
    }




    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }
}
