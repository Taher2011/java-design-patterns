package flyweight.extrinsic_entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
	private String orderId;
	private String customerName;
	private String orderTable;
	private LocalDateTime orderTime;
}
