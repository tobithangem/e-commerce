package com.ecommerce.tgdd.dto.sdi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartAddProductSdi {
    private Long usereId;
    private Long productId;
}
