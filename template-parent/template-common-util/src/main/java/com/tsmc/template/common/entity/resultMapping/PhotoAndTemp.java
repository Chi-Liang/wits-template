package com.tsmc.template.common.entity.resultMapping;

import javax.persistence.*;

import com.tsmc.template.common.dto.PhotoAndTempDto;
import com.tsmc.template.common.entity.OnPhotoLayer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SqlResultSetMapping(
        name = "PhotoAndTempMapping",
        classes = @ConstructorResult(
                targetClass = PhotoAndTempDto.class,
                columns = {
                    @ColumnResult(name = "PHOTO_LAYER", type = String.class),
                    @ColumnResult(name = "PHOTO_LAYER_NAME", type = String.class),
                    @ColumnResult(name = "CONFIG_TYPE", type = String.class),
                    @ColumnResult(name = "CONFIG_TYPE1", type = String.class)}))


@Entity
public class PhotoAndTemp {
	
	@Id
	private Long id;
	
}
