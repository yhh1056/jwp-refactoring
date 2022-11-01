package kitchenpos.table.application;

import java.util.List;
import kitchenpos.order.domain.OrderRepository;
import kitchenpos.order.domain.OrderStatus;
import kitchenpos.table.domain.OrderTable;
import org.springframework.stereotype.Component;

@Component
public class TableValidator {

    private final OrderRepository orderRepository;

    public TableValidator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void validateChangeEmpty(OrderTable orderTable) {
        if (orderRepository.existsByOrderTableIdAndOrderStatusIn(
                orderTable.getId(), List.of(OrderStatus.COOKING, OrderStatus.MEAL))) {
            throw new IllegalArgumentException("조리중이거나 식사 상태입니다.");
        }
    }
}