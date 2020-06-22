package cn.fzj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    private int id;
    private int uid;
    private String username;
    private String bookName;
    private BigDecimal price;
    private String picture;
    private String description;
    private int status;
}
