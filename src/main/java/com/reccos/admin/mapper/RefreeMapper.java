package com.reccos.admin.mapper;

import com.reccos.admin.dto.RefreeRequest;
import com.reccos.admin.dto.RefreeResponse;
import com.reccos.admin.models.Refree;

public interface RefreeMapper {
    Refree toRefree(RefreeRequest refreeRequest);
    RefreeResponse toRefreeResponse(Refree refree);
}
