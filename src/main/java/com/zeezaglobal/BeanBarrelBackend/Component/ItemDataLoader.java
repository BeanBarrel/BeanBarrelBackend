package com.zeezaglobal.BeanBarrelBackend.Component;

import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import com.zeezaglobal.BeanBarrelBackend.Entities.Item;
import com.zeezaglobal.BeanBarrelBackend.Repositories.GroupRepository;
import com.zeezaglobal.BeanBarrelBackend.Repositories.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ItemDataLoader {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GroupRepository groupRepository;

/*@PostConstruct
    public void loadItems() {
    List<Item> items = new ArrayList<>();

// HOT BEV (1)
    items.add(createItem(1, "DAVIDOFF", "4oz", 30.0));
    items.add(createItem(1, "Espresso", "4oz", 50.0));
    items.add(createItem(1, "Babyccino", "4oz", 70.0));
    items.add(createItem(1, "Piccolo Latte", "4oz", 80.0));
    items.add(createItem(1, "Americano", "8oz", 100.0));
    items.add(createItem(1, "Cappuccino", "7oz", 120.0));
    items.add(createItem(1, "Cappuccino", "8oz", 130.0));
    items.add(createItem(1, "Flat White", "7oz", 160.0));
    items.add(createItem(1, "Flat White", "8oz", 170.0));
    items.add(createItem(1, "Café Latte", "7oz", 130.0));
    items.add(createItem(1, "Café Latte", "8oz", 140.0));
    items.add(createItem(1, "Café bombon", "4oz", 80.0));
    items.add(createItem(1, "Hazelnut latte", "7oz", 150.0));
    items.add(createItem(1, "Hazelnut latte", "8oz", 160.0));
    items.add(createItem(1, "Irish Latte", "7oz", 150.0));
    items.add(createItem(1, "Irish Latte", "8oz", 160.0));
    items.add(createItem(1, "Caramel Latte", "7oz", 150.0));
    items.add(createItem(1, "Caramel Latte", "8oz", 160.0));
    items.add(createItem(1, "Butterscotch Latte", "7oz", 150.0));
    items.add(createItem(1, "Butterscotch Latte", "8oz", 160.0));
    items.add(createItem(1, "Vanilla Latte", "7oz", 150.0));
    items.add(createItem(1, "Vanilla Latte", "8oz", 160.0));
    items.add(createItem(1, "Mocha Coffee", "7oz", 160.0));
    items.add(createItem(1, "Mocha Coffee", "8oz", 170.0));
    items.add(createItem(1, "Premium Hot Chocolate", "4oz", 99.0));
    items.add(createItem(1, "Premium Hot Chocolate", "7oz", 130.0));
    items.add(createItem(1, "Premium Hot Chocolate", "8oz", 150.0));
    items.add(createItem(1, "Cranberry Hot Chocolate", "4oz", 120.0));
    items.add(createItem(1, "Cranberry Hot Chocolate", "7oz", 150.0));
    items.add(createItem(1, "Cranberry Hot Chocolate", "8oz", 170.0));
    items.add(createItem(1, "Hazlenut Hot Chocolate", "4oz", 120.0));
    items.add(createItem(1, "Hazlenut Hot Chocolate", "7oz", 150.0));
    items.add(createItem(1, "Hazlenut Hot Chocolate", "8oz", 170.0));

// HOT BEV SPL (2)
    items.add(createItem(2, "Café Bombon", "4OZ", 80.0));

// TEA (3)
    items.add(createItem(3, "Lemon Tea", "7oz", 30.0));
    items.add(createItem(3, "Green Tea with Honey", "7oz", 40.0));
    items.add(createItem(3, "Black Tea with Ginger", "7oz", 30.0));

// Group 4: ICED BEV
    items.add(createItem(4, "Iced Coffee", "350 ml", 120.0));
    items.add(createItem(4, "Iced Espresso", "350 ml", 80.0));
    items.add(createItem(4, "Iced Americano", "350 ml", 130.0));
    items.add(createItem(4, "Iced Hazelnut Latte", "350 ml", 140.0));
    items.add(createItem(4, "Iced Irish Latte", "350 ml", 140.0));
    items.add(createItem(4, "Iced Caramel Latte", "350 ml", 140.0));
    items.add(createItem(4, "Iced Vanilla Latte", "350 ml", 140.0));
    items.add(createItem(4, "Iced vietnamese coffee", "150 ml", 90.0));
    items.add(createItem(4, "Americola", "350 ml", 80.0));
// Group 5: ICED BEV SPL


// Group 6: COLD COFFEE
    items.add(createItem(6, "Cold Coffee", "350 ml", 130.0));
    items.add(createItem(6, "hazelnut CC", "350 ml", 150.0));
    items.add(createItem(6, "Irish cc", "350 ml", 150.0));
    items.add(createItem(6, "Vanilla cc", "350 ml", 150.0));
    items.add(createItem(6, "Caramel Cc", "350 ml", 150.0));
    items.add(createItem(6, "Butter scoth Cc", "350 ml", 150.0));

// Group 7: COFFEE FRAPPE
    items.add(createItem(7, "chocolate frappe", "350 ml", 170.0));
    items.add(createItem(7, "Hazelnut Frappe", "350 ml", 170.0));
    items.add(createItem(7, "Vanilla Frappe", "350 ml", 170.0));
    items.add(createItem(7, "Caramel Frappe", "350 ml", 170.0));

// Group 8: AFFAGATO
    items.add(createItem(8, "Vanilla Affogato", "350 ml", 100.0));
    items.add(createItem(8, "Chocolate Affogato", "350 ml", 110.0));

// Group 9: MOJITTO
    items.add(createItem(9, "Passionfruit", "350 ml", 75.0));
    items.add(createItem(9, "Blue Ocean", "350 ml", 75.0));
    items.add(createItem(9, "Green Apple", "350 ml", 75.0));
    items.add(createItem(9, "Strawberry", "350 ml", 75.0));
    items.add(createItem(9, "Watermelon", "350 ml", 75.0));

// Group 10: CRUSHERS
    items.add(createItem(10, "Passionfruit Crushers", "350 ml", 95.0));
    items.add(createItem(10, "Watermelon Crushers", "350 ml", 95.0));
    items.add(createItem(10, "Green apple Crushers", "350 ml", 95.0));

// Group 11: NONCOFFEE FRAPPE
    items.add(createItem(11, "mango kesar shake", "350 ml", 180.0));
    items.add(createItem(11, "butterscoch frappe", "350 ml", 180.0));
    items.add(createItem(11, "crunchy biscoff shake", "350 ml", 180.0));
    items.add(createItem(11, "Ferrero Frappe", "350 ml", 195.0));
    items.add(createItem(11, "Brownie Frappe", "350 ml", 195.0));

// Group 12: SNACKS
    items.add(createItem(12, "French Fries", "snacks", 70.0));
    items.add(createItem(12, "Peri peri Fries", "snacks", 80.0));
    items.add(createItem(12, "Chicken Nuggets (8pcs)", "8pc", 90.0));
    items.add(createItem(12, "Veg Nuggets (8pcs)", "8pc", 80.0));
    items.add(createItem(12, "Butter Bun", "snacks", 35.0));
    items.add(createItem(12, "Brownies", "snacks", 90.0));
    items.add(createItem(12, "Cookies", "snacks", 15.0));

// Group 13: SMOOTHIES
    items.add(createItem(13, "Blueberry Smoothie", "350 ml", 80.0));
    items.add(createItem(13, "Mixed Fruit Smoothie", "350 ml", 80.0));
    items.add(createItem(13, "Strawberry Smoothie", "350 ml", 70.0));
    items.add(createItem(13, "Mango Smoothie", "350 ml", 70.0));
    items.add(createItem(13, "Tender Coconut Smoothie", "350 ml", 70.0));

    items.add(createItem(14, "Classic Veg Burger", "snacks", 89.0));
    items.add(createItem(14, "Classic Chicken Burger", "snacks", 99.0));
    items.add(createItem(14, "Classic Beef Burger", "snacks", 129.0));
    items.add(createItem(14, "Spicy Veg Burger", "snacks", 119.0));
    items.add(createItem(14, "Spicy Chicken Burger", "snacks", 149.0));
    items.add(createItem(14, "Spicy Beef Burger", "snacks", 149.0));
    items.add(createItem(14, "Chicken Wings 2 Pieces", "snacks", 79.0));
    items.add(createItem(14, "Chicken Wings 4 Pieces", "snacks", 149.0));

    items.add(createItem(15, "Nutella", "CREAM CANDY", 45.0));
    items.add(createItem(15, "Blueberry", "CREAM CANDY", 45.0));
    items.add(createItem(15, "Tender Cococnut", "CREAM CANDY", 40.0));
    items.add(createItem(15, "Chikku", "CREAM CANDY", 40.0));
    items.add(createItem(15, "Kitkat", "CREAM CANDY", 40.0));
    items.add(createItem(15, "Snickers", "CREAM CANDY", 40.0));
    // Filter out nulls in case group not found
        items.removeIf(i -> i == null);

        itemRepository.saveAll(items);
        System.out.println("Items inserted successfully.");
    }*/

    private Item createItem(int groupId, String itemName, String itemDescription, double itemPrice) {
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        if (groupOpt.isEmpty()) {
            System.out.println("Group with ID " + groupId + " not found. Skipping item: " + itemName);
            return null;
        }

        Group group = groupOpt.get();
        Item item = new Item();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemPrice(itemPrice);
        item.setGroup(group);

        return item;
    }
}
