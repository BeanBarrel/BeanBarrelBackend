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

        items.add(createItem(1, "Cranberry Hot Chocolate", "4 OZ", 100.0));
        items.add(createItem(1, "Classic Cinnamon", "4 OZ", 40.0));
        items.add(createItem(1, "Classic Cinnamon", "7 OZ", 70.0));
        items.add(createItem(1, "Espresso 4 OZ", "4 OZ", 40.0));
        items.add(createItem(1, "Babyccino 4OZ", "4 OZ", 60.0));
        items.add(createItem(1, "Piccolo Latte 4OZ", "4OZ", 70.0));
        items.add(createItem(1, "Americano 7OZ", "7OZ", 90.0));
        items.add(createItem(1, "Cappuccino 7OZ", "7OZ", 120.0));
        items.add(createItem(1, "Cappuccino 8OZ", "8OZ", 140.0));
        items.add(createItem(1, "Flat White 8OZ", "8 OZ", 130.0));
        items.add(createItem(1, "Café Latte 7OZ", "7OZ", 120.0));
        items.add(createItem(1, "Café Latte 8OZ", "8OZ", 140.0));
        items.add(createItem(2, "Café bombon 4OZ", "4OZ", 80.0));
        items.add(createItem(1, "Hazelnut latte 7OZ", "7OZ", 140.0));
        items.add(createItem(1, "Hazelnut latte 8OZ", "8OZ", 160.0));
        items.add(createItem(1, "Irish Latte 7OZ", "7OZ", 140.0));
        items.add(createItem(1, "Irish Latte 8OZ", "8OZ", 160.0));
        items.add(createItem(1, "Caramel Latte 7OZ", "7OZ", 140.0));
        items.add(createItem(1, "Caramel Latte 8OZ", "8OZ", 160.0));
        items.add(createItem(1, "Butterscotch Latte 7OZ", "7OZ", 140.0));
        items.add(createItem(1, "Butterscotch Latte 8 OZ", "8OZ", 160.0));
        items.add(createItem(1, "Vanilla Latte 7OZ", "7OZ", 140.0));
        items.add(createItem(1, "Vanilla Latte 8 OZ", "8OZ", 160.0));
        items.add(createItem(1, "Mocha Coffee 7OZ", "7OZ", 180.0));
        items.add(createItem(1, "Hot Chocolate", "4OZ", 79.0));
        items.add(createItem(1, "Premium Hot Chocolate", "4OZ", 99.0));
        items.add(createItem(1, "Lemon Tea", "7OZ", 40.0));
        items.add(createItem(1, "Green Tea with Honey", "7OZ", 40.0));
        items.add(createItem(1, "Black Tea with Ginger", "7OZ", 40.0));
        items.add(createItem(3, "Iced Coffee", "8OZ", 130.0));
        items.add(createItem(3, "Iced Espresso 4OZ", "4OZ", 55.0));
        items.add(createItem(3, "Iced Americano", "8OZ", 95.0));
        items.add(createItem(3, "Iced Hazelnut Latte", "8OZ", 140.0));
        items.add(createItem(3, "Iced Irish Latte", "8OZ", 140.0));
        items.add(createItem(3, "Iced Caramel Latte", "8OZ", 140.0));
        items.add(createItem(3, "Iced Vanilla Latte", "8OZ", 140.0));
        items.add(createItem(4, "Iced Vietnamese Coffee 4OZ", "4OZ", 80.0));
        items.add(createItem(4, "Americola", "8OZ", 100.0));
        items.add(createItem(4, "Cranberry Coffee", "8OZ", 120.0));
        items.add(createItem(5, "Cold Coffee", "8OZ", 150.0));
        items.add(createItem(5, "Hazelnut CC", "8OZ", 160.0));
        items.add(createItem(5, "Irish CC", "8OZ", 160.0));
        items.add(createItem(5, "Vanilla CC", "8OZ", 160.0));
        items.add(createItem(5, "Caramel CC", "8OZ", 160.0));
        items.add(createItem(6, "Chocolate Frappe", "8OZ", 180.0));
        items.add(createItem(6, "Hazelnut Frappe", "8OZ", 180.0));
        items.add(createItem(6, "Vanilla Frappe", "8OZ", 180.0));
        items.add(createItem(6, "Caramel Frappe", "8OZ", 180.0));
        items.add(createItem(7, "Vanilla Affogato", "SINGLE SCOOP", 99.0));
        items.add(createItem(7, "Chocolate Affogato", "SINGLE SCOOP", 199.0));
        items.add(createItem(8, "Passionfruit Mojitto", "8OZ", 99.0));
        items.add(createItem(8, "Blue Ocean Mojitto", "8OZ", 99.0));
        items.add(createItem(8, "Green Apple Mojitto", "8OZ", 99.0));
        items.add(createItem(8, "Strawberry Mojitto", "8OZ", 99.0));
        items.add(createItem(8, "Watermelon Mojitto", "8OZ", 99.0));
        items.add(createItem(9, "Passionfruit Crushers", "8OZ", 109.0));
        items.add(createItem(9, "Watermelon Crushers", "8OZ", 109.0));
        items.add(createItem(9, "Green Apple Crushers", "8OZ", 109.0));
        items.add(createItem(9, "Popsicle Jamun", "8OZ", 150.0));
        items.add(createItem(9, "Popsicle Guvava", "8OZ", 150.0));
        items.add(createItem(9, "Popsicle Grape", "8OZ", 150.0));
        items.add(createItem(10, "Mango Kesar Shake", "8OZ", 200.0));
        items.add(createItem(10, "Butterscotch Frappe", "8OZ", 200.0));
        items.add(createItem(10, "Crunchy Biscoff Shake", "8OZ", 200.0));
        items.add(createItem(10, "mango kesar shake", "8OZ", 195.0));
        items.add(createItem(10, "butterscoch frappe", "8OZ", 195.0));
        items.add(createItem(10, "crunchy biscoff shake", "8OZ", 195.0));
        items.add(createItem(11, "Salty Waves Pops", "30GM", 50.0));
        items.add(createItem(11, "Cheddar Cheese Pops", "30GM", 60.0));
        items.add(createItem(11, "Caramel Crunch Pops", "30GM", 60.0));
        items.add(createItem(12, "Juicy Jamun Bliss", "POPSICLE", 45.0));
        items.add(createItem(12, "Guava Glow Stick", "POPSICLE", 45.0));
        items.add(createItem(12, "Grape Frost Burst", "POPSICLE", 45.0));
        items.add(createItem(12, "Cotton Candy", "POPSICLE", 35.0));
        items.add(createItem(12, "Lotus Biscoff", "POPSICLE", 35.0));
        items.add(createItem(12, "Black Current", "POPSICLE", 35.0));
        items.add(createItem(12, "Spanish Delight", "POPSICLE", 30.0));
        items.add(createItem(12, "Tender Coconut", "POPSICLE", 30.0));
        items.add(createItem(13, "Chocolate Brownie", "SNACKS", 110.0));
        items.add(createItem(13, "Chocolate Croissants", "SNACKS", 80.0));
        items.add(createItem(13, "Chocolate Muffins", "SNACKS", 40.0));
        items.add(createItem(13, "Butter Bun", "SNACKS", 40.0));
        items.add(createItem(13, "Chocolate Bun", "SNACKS", 45.0));
        items.add(createItem(13, "Chocochip Cookie", "SNACKS", 12.0));
        items.add(createItem(13, "Butter Cookie", "SNACKS", 15.0));
        items.add(createItem(13, "Coffee Cookie", "SNACKS", 15.0));
        items.add(createItem(13, "Masala cookie", "SNACKS", 15.0));
        items.add(createItem(13, "Normal Brownie", "SNACKS", 90.0));
        items.add(createItem(13, "VANNILA SCOOP", "ICE", 40.0));
        items.add(createItem(13, "CHOCO SCOOP", "ICE", 50.0));

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
