package com.example.cloudstarter;

import com.example.cloudstarter.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> all() {
        return itemService.findAll();
    }

    @PostMapping
    public Item create(@RequestBody ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.update(id, itemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemService.delete(id);
    }
}