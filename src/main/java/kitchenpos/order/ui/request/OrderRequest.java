package kitchenpos.order.ui.request;

import java.util.List;
import kitchenpos.order.application.request.OrderCommand;

public class OrderRequest {

    private Long orderTableId;
    private List<OrderLineItemRequest> orderLineItems;

    private OrderRequest() {
    }

    public OrderRequest(Long orderTableId, List<OrderLineItemRequest> orderLineItems) {
        this.orderTableId = orderTableId;
        this.orderLineItems = orderLineItems;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public List<OrderLineItemRequest> getOrderLineItems() {
        return orderLineItems;
    }

    public OrderCommand toCommand() {
        return OrderCommand.from(orderTableId, orderLineItems);
    }
}