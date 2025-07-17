package dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
	private Integer orderId;
	private String customerName;
	private Map<String, Integer> orderQuantity;
	private LocalDateTime localDateTime;
}
