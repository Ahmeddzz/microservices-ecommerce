package com.ahmedzahran.ProductServiceTwo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private long id;
    private String name;
    private long quantity;
    private long price;

}
