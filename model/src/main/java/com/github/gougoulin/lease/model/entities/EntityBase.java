package com.github.gougoulin.lease.model.entities;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class EntityBase {
    @Schema(description = "PK")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "Creat time")
    @TableField(value = "created_at", fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NEVER)
    private Date createdAt;

    @Schema(description = "Last update time")
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE, update = "now()")
    private Date updatedAt;

    @Schema(description = "Soft delete indicator: 1: deleted; 0: not deleted")
    @TableField(value="deleted")
    private Boolean deleted;
}
