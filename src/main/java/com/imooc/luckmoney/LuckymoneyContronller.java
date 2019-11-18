package com.imooc.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyContronller {
    @Autowired
    private LuckmoneyRepository luckmoneyRepository;
    @Autowired
    private LuckymoneyService luckymoneyService;
    //获取红包列表
    @GetMapping("/luckymoneys")
   public List<Luckymoney> list()
   {
       return luckmoneyRepository.findAll();
   }
   //创建红包
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer, @RequestParam("money")BigDecimal money)
    {
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return luckmoneyRepository.save(luckymoney);
    }
    //根据ID查询红包
    @GetMapping("/luckymoneys/{id}")
     public Luckymoney findById(@PathVariable("id") Integer id)
     {
         return luckmoneyRepository.findById(id).orElse(null);
     }
     //更新红包
     @PutMapping("/luckymoneys/{id}")
     public Luckymoney update(@PathVariable("id") Integer id,@RequestParam("consumer") String consumer)
     {
         Optional<Luckymoney> optional = luckmoneyRepository.findById(id);
         if(optional.isPresent())
         {
             Luckymoney luckymoney=optional.get();
            // luckymoney.setId(id);
             luckymoney.setConsumer(consumer);
             return luckmoneyRepository.save(luckymoney);
         }
        return null;
     }
     //事务
    @PostMapping("/luckymoneys/two")
    public void createTwo()
    {
        luckymoneyService.createTwo();
    }

}
