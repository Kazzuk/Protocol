package com.nukkitx.protocol.bedrock.data.inventory.descriptor;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ItemDescriptorWithCount {
    public static final ItemDescriptorWithCount AIR = new ItemDescriptorWithCount(new DefaultDescriptor(0, 0), 0) {
        @Override
        public ItemData toItem() {
            return ItemData.AIR;
        }
    };

    private final ItemDescriptor descriptor;
    private final int count;

    public ItemData toItem() {
        return descriptor.toItem()
                .count(count)
                .build();
    }

    public static ItemDescriptorWithCount fromItem(ItemData item) {
        if (item == ItemData.AIR) {
            return AIR;
        }
        return new ItemDescriptorWithCount(new DefaultDescriptor(item.getId(), item.getDamage()), item.getCount());
    }
}
